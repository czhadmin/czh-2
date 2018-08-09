package com.accp.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accp.dao.GoodsDao;
import com.accp.entity.Customers;
import com.accp.entity.Goods;
import com.accp.entity.HeTi;
import com.accp.entity.OrderDetails;
import com.accp.entity.Orders;
import com.accp.service.CustomersService;
import com.accp.service.GoodsService;
import com.accp.service.HeTiService;
import com.accp.service.OrderDetailsService;
import com.accp.service.OrdersService;
import com.accp.service.impl.CustomersServiceImpl;
import com.accp.service.impl.GoodsServiceImpl;
import com.accp.service.impl.HeTiServiceImpl;
import com.accp.service.impl.OrderDetailsServiceImpl;
import com.accp.service.impl.OrdersServiceImpl;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class CustomersServlet
 */
@WebServlet("/gw")
public class CustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CustomersService cusice=new CustomersServiceImpl();  //��¼ע��
       GoodsService goods=new GoodsServiceImpl();//��ҳ
       OrdersService orders=new OrdersServiceImpl();//���ﳵ����
       OrderDetailsService orderdetails=new OrderDetailsServiceImpl();//���ﳵ�ӱ� 
       HeTiService heti=new HeTiServiceImpl();//���ﳵ���Ӳ�ѯ
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		
		String type=request.getParameter("type");
		switch (type) {
		case "dlquery":
			dlquery(request,response);
			break;	
		case "dlyz":
			dlyz(request,response);
			break;	
		case "tozc":
			tozc(request,response);
			break;
		case "dozc":
			dozc(request,response);
			break;
		case "yzname":
			yzname(request,response);
			break;
		case "toindex":
			toindex(request,response);
			break;
		case "toxq":
			toxq(request,response);
			break;
		case "togwc":
			togwc(request,response);
			break;
		case "addgwc":
			addgwc(request,response);
			break;	
		case "xgxiaoji":
			xgxiaoji(request,response);
			break;
		case "xgzojia":
			xgzojia(request,response);
			break;
		case "spsc":
			spsc(request,response);
			break;
		case "spzosc":
			spzosc(request,response);
			break;
		case "totijiao":
			totijiao(request,response);
			break;
		default:
			break;
		}
		
	}
	protected void dlquery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������¼����
			request.getRequestDispatcher("/WEB-INF/customers/login.jsp").forward(request, response);
	}
	
	protected void dlyz(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��¼
		HttpSession session = request.getSession();
			String user=request.getParameter("user");
			String pwd=request.getParameter("pwd");
			if(this.cusice.query(user, pwd)!=null){
				response.sendRedirect("gw?type=toindex");
				System.out.println(this.cusice.query(user));
				session.setAttribute("user",this.cusice.query(user));
				
			}else{
				response.sendRedirect("gw?type=dlquery");
			}
	}

	protected void tozc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ע�����
			request.getRequestDispatcher("/WEB-INF/customers/zc.jsp").forward(request, response);
	}
	protected void dozc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ע��
		String customerName=request.getParameter("customerName");
		String customerPassword=request.getParameter("customerPassword");
		Customers cus=new Customers();
		cus.setCustomerName(customerName);
		cus.setCustomerPassword(customerPassword);
		this.cusice.insert(cus);
		Orders oo= new Orders();
		
	 Customers cc=	this.cusice.query(customerName);
		oo.setCustomerId(cc.getId());
		this.orders.gwczeng(oo);
		response.sendRedirect("gw?type=dlquery");
		
	}
	protected void yzname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ע����֤�����Ƿ��ظ�
			String customerName=request.getParameter("customerName");
			if(this.cusice.query(customerName)!=null){
				response.getWriter().append("0");
			}
		
	}
	protected void toindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����������
		   List<Goods> lis= this.goods.query();
		   request.setAttribute("lis",lis);
			request.getRequestDispatcher("/WEB-INF/customers/index.jsp").forward(request, response);
	}
	protected void toxq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������ҳ
		String goodsid=request.getParameter("goodsid");
		   Goods lis= this.goods.query(Integer.parseInt(goodsid));
		   request.setAttribute("lis",lis);
			request.getRequestDispatcher("/WEB-INF/customers/detail.jsp").forward(request, response);
	}
	protected void addgwc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String price=request.getParameter("price");//�۸�
		String id=request.getParameter("id");//��Ʒid
		HttpSession session = request.getSession();
		Customers ss=(Customers)session.getAttribute("user");
		Orders orders=new Orders();
		orders.setCustomerId(ss.getId());//�û�id
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
		orders.setCreatedDate(df.format(day));//ʱ��
		orders.setTotal(Double.parseDouble(price));//�۸�
		//this.orders.zeng(orders);//�����ﳵ�����������

		Orders oo=this.orders.query(ss.getId());
		OrderDetails orderdetails=new OrderDetails();
		orderdetails.setOrderId(oo.getId());//���ﳵ����id���ӱ��
		orderdetails.setGoodsId(Integer.parseInt(id));//��Ʒid
		orderdetails.setPrice(Double.parseDouble(price));//�۸�
		orderdetails.setQty(1);//��Ʒ����
		if(this.orderdetails.query(oo.getId(),Integer.parseInt(id))==null) {
			this.orderdetails.zeng(orderdetails);
		}else {
			this.orderdetails.gai(orderdetails);
		}
		response.sendRedirect("gw?type=togwc");
	}
	protected void togwc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�������ﳵҳ
		HttpSession session = request.getSession();
		Customers ss=(Customers)session.getAttribute("user");
		Orders oo=this.orders.query(ss.getId());
		List<HeTi> lis=	this.heti.query(oo.getId());
		request.setAttribute("lis",lis);
		OrderDetails o=this.orderdetails.chasum(oo.getId());
		request.setAttribute("olis",o);
		request.getRequestDispatcher("/WEB-INF/customers/cart.jsp").forward(request, response);
	}
	
	protected void xgxiaoji(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String xj=request.getParameter("xj");
			String orid=request.getParameter("orid");
			String sl=request.getParameter("sl");
			this.orderdetails.gaixj(Double.parseDouble(xj),Integer.parseInt(orid),Integer.parseInt(sl));
			response.getWriter().append(xj);
	}
	
	protected void xgzojia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId=request.getParameter("orderId");
		OrderDetails o=this.orderdetails.chasum(Integer.parseInt(orderId));
		this.orders.xg(Integer.parseInt(orderId),o.getPrice());
		response.getWriter().append(o.getPrice()+"");
	}
	
	protected void spsc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String orid=request.getParameter("orid");
			this.orderdetails.delete(Integer.parseInt(orid));
			
	}
	protected void spzosc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ɾ��ȫ�����ﳵ
			String orderId=request.getParameter("orderId");
			this.orderdetails.deletezhu(Integer.parseInt(orderId));
	}
	
	protected void totijiao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ύҳ��
		HttpSession session = request.getSession();
		Customers ss=(Customers)session.getAttribute("user");
		Orders ii=this.orders.query(ss.getId());
		Orders oo=this.orders.queryid(ii.getId());
		System.out.println(ss.getId());
		request.setAttribute("lis",oo);
		request.getRequestDispatcher("/WEB-INF/customers/tijiao.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
