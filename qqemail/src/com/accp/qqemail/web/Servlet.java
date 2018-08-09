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
       UserService userservice=new UserServiceImpl();//用户表
       MailinfoService mailinfoservice=new MailinfoServiceImpl();//邮件表
       MailAndUserRelationService mailanduserrelationservice=new MailAndUserRelationServiceImpl();//关系表
       LianJieService lainjieservice=new LianJieServiceImpl();//连接查询
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void tologin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//跳到登录
    	request.getRequestDispatcher("WEB-INF/user/login.jsp").forward(request, response);
    }
    
    protected void dologin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//执行登录
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
    	//跳到注册
    	request.getRequestDispatcher("WEB-INF/user/zc.jsp").forward(request, response);
    }
    protected void dozc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//执行注册
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
    	//验证邮箱是否重名
    	String email=request.getParameter("email");
    	if(this.userservice.query(email)!=null) {
        	response.getWriter().append("有");
    	}
    	
    }
    protected void tosetEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//跳到写信界面
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/setEmail.jsp").forward(request, response);
    }
    
    protected void tosendEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//写信的界面,在iframe里跳
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/sendEmail.jsp").forward(request, response);
    }
    
    protected void toindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//主界面,在iframe里跳
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	//查询有多少未读
    	int mm=this.mailanduserrelationservice.queryweidu(uu.getUserId());
    	request.setAttribute("wd",mm);
    	//查询有多少收件
    	int sj=this.mailanduserrelationservice.querysj(uu.getUserId());
    	request.setAttribute("sj",sj);
    	
    	request.getRequestDispatcher("WEB-INF/user/index.jsp").forward(request, response);
    }
    protected void tosendindex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//主界面
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/sendIndex.jsp").forward(request, response);
    }
    protected void addMailInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//添加邮件
    	//普通收件人
    	String normalMail=request.getParameter("normalMail");
    	//抄送收件人
    	String copyEmail=request.getParameter("copyEmail");
    	//密送收件人
    	String secretEmail=request.getParameter("secretEmail");
    	//主题
    	String title=request.getParameter("title");
    	//内容
    	String recContent=request.getParameter("recContent");
    	//回执标识
    	String RecFlag=request.getParameter("RecFlag");
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	//发件人
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
    		String[] normalMail=request.getParameter("normalMail").split(";");//普通收件人
    		String[] copyEmail=request.getParameter("copyEmail").split(";");//抄送人
    		String[] secretEmail=request.getParameter("secretEmail").split(";");//密送人
    		String RecFlag=request.getParameter("RecFlag");//是否回执
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
    	//发件人的关系添加
    	HttpSession session = request.getSession();
		User uu =(User) session.getAttribute("user");
		//查邮件id
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
    	//收件人的关系添加
    	HttpSession session = request.getSession();
		User uu =(User) session.getAttribute("user"); 
		//System.out.println(sstype.length);
    	for (String string : sstype) {
    		//按邮箱查收件人对象
			User us=this.userservice.query(string);
			//查邮件id
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
    	//收件,在iframe里跳
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/sj.jsp").forward(request, response);
    }
    protected void querysj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//查询收件
    	String dqy =request.getParameter("dqy");
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	pageba<LianJie3> pp=lainjieservice.pagequery( uu.getUserId(), 2, 1, Integer.parseInt(dqy), 2);//用户id,是哪个文件夹,是否删除,当前页,总条数
    	response.getWriter().print(JSON.toJSON(pp));
    }
    protected void tosendtsj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//跳到收件
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/sendsj.jsp").forward(request, response);
    }
    protected void tofj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//发件,在iframe里跳
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/fj.jsp").forward(request, response);
    }
    protected void tosendtfj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//跳到发件
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/sendfj.jsp").forward(request, response);
    }
    protected void queryfj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//查询发件
    	String dqy =request.getParameter("dqy");
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
//    	System.out.println( uu.getUserId());
    	pageba<LianJie3> pp=lainjieservice.pagequery( uu.getUserId(), 1, 1, Integer.parseInt(dqy), 3);//用户id,是哪个文件夹,是否删除,当前页,总条数
    	response.getWriter().print(JSON.toJSON(pp));
    }
    protected void dofjsc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//改刪除关系
    	String relId=request.getParameter("relId");
    	this.mailanduserrelationservice.updatesc(0, Integer.parseInt(relId));
    }
    protected void dofjcdsc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//彻底删除
    	String relId=request.getParameter("relId");
    	this.mailanduserrelationservice.cdsc(Integer.parseInt(relId));
    }
    protected void tofolder_cont(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//跳到详情,在iframe里跳
    	String relId=request.getParameter("relId");
    	LianJie3 pp=lainjieservice.query(Integer.parseInt(relId));
    	request.setAttribute("email",pp);
    	request.getRequestDispatcher("WEB-INF/user/folder_cont.jsp").forward(request, response);
    }
    protected void toysc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//跳到以删除,在iframe里跳
    	
    	request.getRequestDispatcher("WEB-INF/user/ysc.jsp").forward(request, response);
    }
    protected void tosendysc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//跳到以删除
    
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/sendysc.jsp").forward(request, response);
    }
    protected void queryysc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//查询收件
       	String dqy =request.getParameter("dqy");
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	pageba<LianJie3> pp=lainjieservice.pagequery( uu.getUserId(), 0, 0 , Integer.parseInt(dqy), 2);//用户id,是哪个文件夹,是否删除,当前页,总条数
    	response.getWriter().print(JSON.toJSON(pp));
    }
    protected void doyido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//移动
    	String relId=request.getParameter("relId");
    	String foId=request.getParameter("foId");
    	this.mailanduserrelationservice.ydd(Integer.parseInt(foId),Integer.parseInt(relId));
    }
    protected void dobjiyd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//标记为已读
    	String readState=request.getParameter("readState");
    	String relId=request.getParameter("relId");
    	this.mailanduserrelationservice.bjiyd(Integer.parseInt(readState),Integer.parseInt(relId));
    }
    protected void tocaogao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//跳到草稿箱,在iframe里跳
    	request.getRequestDispatcher("WEB-INF/user/caogao.jsp").forward(request, response);
    }
    protected void tosendcaogao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//跳到草稿箱
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
    	request.getRequestDispatcher("WEB-INF/user/sendcaogao.jsp").forward(request, response);
    }
    protected void addcaogao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//添加草稿
    	//普通收件人
    	String normalMail=request.getParameter("normalMail");
    	//抄送收件人
    	String copyEmail=request.getParameter("copyEmail");
    	//密送收件人
    	String secretEmail=request.getParameter("secretEmail");
    	//主题
    	String title=request.getParameter("title");
    	//内容
    	String recContent=request.getParameter("recContent");
    	//回执标识
    	String RecFlag=request.getParameter("RecFlag");
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	//发件人
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
    	//查询草稿
    	String dqy =request.getParameter("dqy");
    	HttpSession session = request.getSession();
    	User uu =(User) session.getAttribute("user"); 
    	request.setAttribute("user",uu);
		
    	pageba<LianJie3> pp=lainjieservice.pagequerycg( 0,uu.getEmail(), Integer.parseInt(dqy), 2);//是否为草稿,用户邮箱,当前页,总条数
    	response.getWriter().print(JSON.toJSON(pp));
    }
    protected void doyjsc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//彻底删除
    	String mailId=request.getParameter("mailId");
    	
    	this.mailinfoservice.deleteyj(Integer.parseInt(mailId));
    }
    protected void tocgfolder_cont(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//跳到草稿详情,在iframe里跳
    	String mailId=request.getParameter("mailId");
    	Mailinfo pp=this.mailinfoservice.query(Integer.parseInt(mailId));
    	request.setAttribute("email",pp);
    	request.getRequestDispatcher("WEB-INF/user/cgfolder_cont.jsp").forward(request, response);
    } 
}
