package com.accp.qqemail.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accp.qqemail.entity.LianJie3;
import com.accp.qqemail.entity.MailAndUserRelation;
import com.accp.qqemail.entity.Mailinfo;
import com.accp.qqemail.entity.User;
import com.accp.qqemail.entity.pageba;
import com.accp.qqemail.service.LianJieService;
import com.accp.qqemail.service.MailAndUserRelationService;
import com.accp.qqemail.service.MailinfoService;
import com.accp.qqemail.service.UserService;
import com.accp.qqemail.service.impl.LianJieServiceImpl;
import com.accp.qqemail.service.impl.MailAndUserRelationServiceImpl;
import com.accp.qqemail.service.impl.MailinfoServiceImpl;
import com.accp.qqemail.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/qq")
public class Servlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       UserService userservice=new UserServiceImpl();//�û���
       MailinfoService mailinfoservice=new MailinfoServiceImpl();//�ʼ���
       MailAndUserRelationService mailanduserrelationservice=new MailAndUserRelationServiceImpl();//��ϵ��
       LianJieService lainjieservice=new LianJieServiceImpl();//���Ӳ�ѯ
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void tologin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//������¼
    	request.getRequestDispatcher("WEB-INF/user/login.jsp").forward(request, response);
    }
    
    protected void dologin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//ִ�е�¼
    	String email=request.getParameter("email");
    	String password=request.getParameter("password");
    	User user =new User();
    	user.setEmail(email);
    	user.setPassword(password);
    	if(this.userservice.query(user)!=null) {
    		HttpSession session = request.getSession();
    		session.setAttribute("user",this.userservice.query(user));
    		response.sendRedirect("qq?type=tosendindex");
    	}else {
    		response.sendRedirect("qq?type=tozc");
    	}
    }
    protected void tozc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//����ע��
    	request.getRequestDispatcher("WEB-INF/user/zc.jsp").forward(request, response);
    }
    protected void dozc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//ִ��ע��
    	String email=request.getParameter("email");
    	String nickName=request.getParameter("nickName");
    	String password=request.getParameter("password");
    	User user =new User();
    	user.setEmail(email);
    	user.setPassword(password);
    	user.setNickName(nickName);
    	this.userservice.insert(user);
    	response.sendRedirect("qq?type=tologin");
    }
    protected void yzemail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//��֤�����Ƿ�����
    	String email=request.getParameter("email");
    	if(this.userservice.query(email)!=null) {
        	response.getWriter().append("��");
    	}
    	
    }
    protected void tosetEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//����д�Ž���
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/setEmail.jsp").forward(request, response);
    }
    
    protected void tosendEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//д�ŵĽ���,��iframe����
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/sendEmail.jsp").forward(request, response);
    }
    
    protected void toindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//������,��iframe����
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	//��ѯ�ж���δ��
    	int mm=this.mailanduserrelationservice.queryweidu(uu.getUserId());
    	request.setAttribute("wd",mm);
    	//��ѯ�ж����ռ�
    	int sj=this.mailanduserrelationservice.querysj(uu.getUserId());
    	request.setAttribute("sj",sj);
    	
    	request.getRequestDispatcher("WEB-INF/user/index.jsp").forward(request, response);
    }
    protected void tosendindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//������
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/sendIndex.jsp").forward(request, response);
    }
    protected void addMailInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//����ʼ�
    	//��ͨ�ռ���
    	String normalMail=request.getParameter("normalMail");
    	//�����ռ���
    	String copyEmail=request.getParameter("copyEmail");
    	//�����ռ���
    	String secretEmail=request.getParameter("secretEmail");
    	//����
    	String title=request.getParameter("title");
    	//����
    	String recContent=request.getParameter("recContent");
    	//��ִ��ʶ
    	String RecFlag=request.getParameter("RecFlag");
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	//������
    	String senEmail= uu.getEmail();
    	Mailinfo mailinfo =new Mailinfo();
    	mailinfo.setNormalEmail(normalMail);
    	mailinfo.setCopyEmail(copyEmail);
    	mailinfo.setTitle(title);
    	mailinfo.setRecContent(recContent);
    	mailinfo.setRecFlag(Integer.parseInt(RecFlag));
    	mailinfo.setSecretEmail(secretEmail);
    	mailinfo.setSenEmail(senEmail);
    	mailinfo.setIsdraft(1);
    	this.mailinfoservice.insert(mailinfo);
    }
    protected void addMailAndUserRelation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String[] normalMail=request.getParameter("normalMail").split(";");//��ͨ�ռ���
    		String[] copyEmail=request.getParameter("copyEmail").split(";");//������
    		String[] secretEmail=request.getParameter("secretEmail").split(";");//������
    		String RecFlag=request.getParameter("RecFlag");//�Ƿ��ִ
    		if(request.getParameter("normalMail")!="") {
    			sjr(request, response,normalMail,1,RecFlag,2);
    		}
    		if(request.getParameter("copyEmail")!="") {
    			sjr(request, response,copyEmail,2,RecFlag,2);
    		}
    		if(request.getParameter("secretEmail")!="") {
    			sjr(request, response,secretEmail,3,RecFlag,2);
    		}
    		fjr(request,response,0,RecFlag,1);
    		response.getWriter().print("true");
    }
    protected void fjr(HttpServletRequest request, HttpServletResponse response,int mailModel,String RecFlag,int FoId) throws ServletException, IOException {
    	//�����˵Ĺ�ϵ���
    	HttpSession session = request.getSession();
		User uu =(User) session.getAttribute("user");
		//���ʼ�id
		Mailinfo ma=this.mailinfoservice.query(uu.getEmail());
		MailAndUserRelation mailAndUserRelation=new MailAndUserRelation(); 
		mailAndUserRelation.setUserId(uu.getUserId());
		mailAndUserRelation.setMailId(ma.getMailId());
		mailAndUserRelation.setMailModel(mailModel);
		mailAndUserRelation.setReadState(0);
		mailAndUserRelation.setDeleteState(1);
		mailAndUserRelation.setFoId(FoId);
		mailAndUserRelation.setIsRec(Integer.parseInt(RecFlag));
		this.mailanduserrelationservice.insert(mailAndUserRelation);
		
    }
    protected void sjr(HttpServletRequest request, HttpServletResponse response,String[] sstype,int mailModel,String RecFlag,int FoId) throws ServletException, IOException {
    	//�ռ��˵Ĺ�ϵ���
    	HttpSession session = request.getSession();
		User uu =(User) session.getAttribute("user"); 
		//System.out.println(sstype.length);
    	for (String string : sstype) {
    		//��������ռ��˶���
			User us=this.userservice.query(string);
			//���ʼ�id
			Mailinfo ma=this.mailinfoservice.query(uu.getEmail());
			MailAndUserRelation mailAndUserRelation=new MailAndUserRelation(); 
			mailAndUserRelation.setUserId(us.getUserId());
			mailAndUserRelation.setMailId(ma.getMailId());
			mailAndUserRelation.setMailModel(mailModel);
			mailAndUserRelation.setReadState(0);
			mailAndUserRelation.setDeleteState(1);
			mailAndUserRelation.setFoId(FoId);
			mailAndUserRelation.setIsRec(Integer.parseInt(RecFlag));
			this.mailanduserrelationservice.insert(mailAndUserRelation);
    		}     
    } 
    protected void tosj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//�ռ�,��iframe����
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/sj.jsp").forward(request, response);
    }
    protected void querysj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//��ѯ�ռ�
    	String dqy =request.getParameter("dqy");
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	pageba<LianJie3> pp=lainjieservice.pagequery( uu.getUserId(), 2, 1, Integer.parseInt(dqy), 2);//�û�id,���ĸ��ļ���,�Ƿ�ɾ��,��ǰҳ,������
    	response.getWriter().print(JSON.toJSON(pp));
    }
    protected void tosendtsj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//�����ռ�
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/sendsj.jsp").forward(request, response);
    }
    protected void tofj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//����,��iframe����
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/fj.jsp").forward(request, response);
    }
    protected void tosendtfj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//��������
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/sendfj.jsp").forward(request, response);
    }
    protected void queryfj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//��ѯ����
    	String dqy =request.getParameter("dqy");
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
//    	System.out.println( uu.getUserId());
    	pageba<LianJie3> pp=lainjieservice.pagequery( uu.getUserId(), 1, 1, Integer.parseInt(dqy), 3);//�û�id,���ĸ��ļ���,�Ƿ�ɾ��,��ǰҳ,������
    	response.getWriter().print(JSON.toJSON(pp));
    }
    protected void dofjsc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//�Ąh����ϵ
    	String relId=request.getParameter("relId");
    	this.mailanduserrelationservice.updatesc(0, Integer.parseInt(relId));
    }
    protected void dofjcdsc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//����ɾ��
    	String relId=request.getParameter("relId");
    	this.mailanduserrelationservice.cdsc(Integer.parseInt(relId));
    }
    protected void tofolder_cont(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//��������,��iframe����
    	String relId=request.getParameter("relId");
    	LianJie3 pp=lainjieservice.query(Integer.parseInt(relId));
    	request.setAttribute("email",pp);
    	request.getRequestDispatcher("WEB-INF/user/folder_cont.jsp").forward(request, response);
    }
    protected void toysc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//������ɾ��,��iframe����
    	
    	request.getRequestDispatcher("WEB-INF/user/ysc.jsp").forward(request, response);
    }
    protected void tosendysc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//������ɾ��
    
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/sendysc.jsp").forward(request, response);
    }
    protected void queryysc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//��ѯ�ռ�
       	String dqy =request.getParameter("dqy");
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	pageba<LianJie3> pp=lainjieservice.pagequery( uu.getUserId(), 0, 0 , Integer.parseInt(dqy), 2);//�û�id,���ĸ��ļ���,�Ƿ�ɾ��,��ǰҳ,������
    	response.getWriter().print(JSON.toJSON(pp));
    }
    protected void doyido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//�ƶ�
    	String relId=request.getParameter("relId");
    	String foId=request.getParameter("foId");
    	this.mailanduserrelationservice.ydd(Integer.parseInt(foId),Integer.parseInt(relId));
    }
    protected void dobjiyd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//���Ϊ�Ѷ�
    	String readState=request.getParameter("readState");
    	String relId=request.getParameter("relId");
    	this.mailanduserrelationservice.bjiyd(Integer.parseInt(readState),Integer.parseInt(relId));
    }
    protected void tocaogao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//�����ݸ���,��iframe����
    	request.getRequestDispatcher("WEB-INF/user/caogao.jsp").forward(request, response);
    }
    protected void tosendcaogao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//�����ݸ���
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/sendcaogao.jsp").forward(request, response);
    }
    protected void addcaogao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//��Ӳݸ�
    	//��ͨ�ռ���
    	String normalMail=request.getParameter("normalMail");
    	//�����ռ���
    	String copyEmail=request.getParameter("copyEmail");
    	//�����ռ���
    	String secretEmail=request.getParameter("secretEmail");
    	//����
    	String title=request.getParameter("title");
    	//����
    	String recContent=request.getParameter("recContent");
    	//��ִ��ʶ
    	String RecFlag=request.getParameter("RecFlag");
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	//������
    	String senEmail= uu.getEmail();
    	Mailinfo mailinfo =new Mailinfo();
    	mailinfo.setNormalEmail(normalMail);
    	mailinfo.setCopyEmail(copyEmail);
    	mailinfo.setTitle(title);
    	mailinfo.setRecContent(recContent);
    	mailinfo.setRecFlag(Integer.parseInt(RecFlag));
    	mailinfo.setSecretEmail(secretEmail);
    	mailinfo.setSenEmail(senEmail);
    	mailinfo.setIsdraft(0);
    	this.mailinfoservice.insert(mailinfo);
    }
    protected void querycaogao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//��ѯ�ݸ�
    	String dqy =request.getParameter("dqy");
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
		
    	pageba<LianJie3> pp=lainjieservice.pagequerycg( 0,uu.getEmail(), Integer.parseInt(dqy), 2);//�Ƿ�Ϊ�ݸ�,�û�����,��ǰҳ,������
    	response.getWriter().print(JSON.toJSON(pp));
    }
    protected void doyjsc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//����ɾ��
    	String mailId=request.getParameter("mailId");
    	
    	this.mailinfoservice.deleteyj(Integer.parseInt(mailId));
    }
    protected void tocgfolder_cont(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//�����ݸ�����,��iframe����
    	String mailId=request.getParameter("mailId");
    	Mailinfo pp=this.mailinfoservice.query(Integer.parseInt(mailId));
    	request.setAttribute("email",pp);
    	request.getRequestDispatcher("WEB-INF/user/cgfolder_cont.jsp").forward(request, response);
    } 
}
