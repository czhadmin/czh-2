package com.accp.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.accp.entity.comments;
import com.accp.entity.dynamicState;
import com.accp.entity.frienDapplfor;
import com.accp.entity.friend;
import com.accp.entity.grouping;
import com.accp.entity.img;
import com.accp.entity.praiseRecord;
import com.accp.entity.qspace;
import com.accp.entity.reply;
import com.accp.entity.spaceBackImg;
import com.accp.entity.userTab;
import com.accp.service.CommentsService;
import com.accp.service.DynamicStateService;
import com.accp.service.FrienDapplforService;
import com.accp.service.FriendService;
import com.accp.service.GroupingService;
import com.accp.service.ImgService;
import com.accp.service.PraiseRecordService;
import com.accp.service.QspaceService;
import com.accp.service.ReplyService;
import com.accp.service.UserTabService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

@RestController

@RequestMapping("/qqajax")
public class QQApiController {

	@Autowired
	private UserTabService usertabservice;// �û���

	@Autowired
	private GroupingService groupingservice;// �����

	@Autowired
	private FrienDapplforService friendapplforservice;// ���������

	@Autowired
	private FriendService friendservice;// ���ѹ�ϵ��

	@Autowired
	private QspaceService qspaceservice;// �ռ��

	@Autowired
	private CommentsService commentsservice;// ���۱�

	@Autowired
	private PraiseRecordService praiserecordservice;// ���ޱ�
	
	@Autowired
	private ReplyService replyservice;//�ظ���    
	
	@Autowired
	private DynamicStateService dynamicstateservice;//��̬��
	
	@Autowired
	private ImgService imgservice;//ͼƬ��
	
	@RequestMapping(value = "/dozc", method = RequestMethod.POST) // �����û�
	public Object dozc(HttpServletRequest request) {
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		StringBuilder str = new StringBuilder();// ����䳤�ַ���
		Random random = new Random();
		// ����������֣�����ӵ��ַ���
		for (int i = 0; i < 8; i++) {
			str.append(random.nextInt(10));
		}
		// ���ַ���ת��Ϊ���ֲ����
		String num = str.toString();
		System.out.println(num);

		userTab userTab = new userTab();
		userTab.setNickname(nickname);
		userTab.setPassword(password);
		userTab.setUsername(num);

		this.usertabservice.insertSelective(userTab);
		grouping record = new grouping();// ����Ĭ�Ϸ���
		record.setUserid(userTab.getUserid());
		record.setGroupingname("�ҵĺ���");
		this.groupingservice.insertSelective(record);
		return num;
	}

	@RequestMapping(value = "/chahaoyou", method = RequestMethod.GET) // ��ѯ�û�
	public Object chahaoyou(HttpServletRequest request) {
		String username = request.getParameter("username");
		List<userTab> lis = this.usertabservice.selecthaoyou(username);
		return JSON.toJSON(lis);
	}
	
	@RequestMapping(value = "/chahaoyouqb", method = RequestMethod.GET)
	public Object chahaoyouqb(HttpServletRequest request) {
		List<userTab> lis = this.usertabservice.selectqb();
		return JSON.toJSON(lis);
	}

	@RequestMapping(value = "/selectfenzu", method = RequestMethod.GET) // ��ѯ�û��ķ���
	public Object selectfenzu(HttpServletRequest request, HttpSession httpSession) {

		String userid = (String) httpSession.getAttribute("tjuserid");// �Ѵ���httpSession����û�id
		List<grouping> lis = this.groupingservice.selectuserId(Integer.parseInt(userid));
		return JSON.toJSON(lis);
	}

	@RequestMapping(value = "/addfriendApplfor", method = RequestMethod.POST) // �������������
	public Object addfriendApplfor(HttpServletRequest request, HttpSession httpSession) {
		String remark = request.getParameter("remark");// ��֤��Ϣ
		String pasvUserid = request.getParameter("pasvUserid");// ��������id
		String groupingId = request.getParameter("groupingId");// ����id
		String beizhu = request.getParameter("beizhu");// ��עid
		userTab uu = (userTab) httpSession.getAttribute("user");// �����˱��
		frienDapplfor friendapplfor = new frienDapplfor();
		friendapplfor.setBeizhu(beizhu);
		friendapplfor.setGroupingid(Integer.parseInt(groupingId));
		friendapplfor.setIsok(0);
		friendapplfor.setPasvuserid(Integer.parseInt(pasvUserid));
		friendapplfor.setRemark(remark);
		friendapplfor.setUserid(uu.getUserid());
		int i = this.friendapplforservice.insertSelective(friendapplfor);

		return i;
	}

	@RequestMapping(value = "/selectfriendApplfor", method = RequestMethod.GET)
	public Object selectfriendApplfor(HttpServletRequest request, HttpSession httpSession) {
		userTab uu = (userTab) httpSession.getAttribute("user");
		List<frienDapplfor> lis = this.friendapplforservice.selectall(uu.getUserid());
		return JSON.toJSON(lis);
	}

	@RequestMapping(value = "/addfriend", method = RequestMethod.POST)
	public Object addfriend(HttpServletRequest request, HttpSession httpSession) {
		String zijibeizu = request.getParameter("zijibeizu");
		String frienduserid = request.getParameter("frienduserid");
		String groupingId = request.getParameter("groupingId");
		userTab uu = (userTab) httpSession.getAttribute("user");
		System.out.println(httpSession.getAttribute("beizhu"));
		System.out.println(zijibeizu);
		System.out.println(frienduserid);
		System.out.println(groupingId);
		System.out.println(uu.getUserid());
		System.out.println(httpSession.getAttribute("hygroupingId"));

		friend friend = new friend();// ����Լ�����ѵĹ�ϵ
		friend.setFriendname(zijibeizu);
		friend.setFrienduserid(Integer.parseInt(frienduserid));
		friend.setGroupingid(Integer.parseInt(groupingId));
		friend.setUserid(uu.getUserid());
		this.friendservice.insert(friend);

		friend friendsd = new friend();// ��Ӻ������Լ��Ĺ�ϵ
		String beizhu = (String) httpSession.getAttribute("beizhu");
		friendsd.setFriendname(beizhu);
		friendsd.setFrienduserid(uu.getUserid());
		String aa = (String) httpSession.getAttribute("hygroupingId");
		int aa2 = Integer.parseInt(aa);
		friendsd.setGroupingid(aa2);
		friendsd.setUserid(Integer.parseInt(frienduserid));
		this.friendservice.insert(friendsd);

		// �ı������������֤״̬
		this.friendapplforservice.updateByPrimaryKey(1, Integer.parseInt(frienduserid), uu.getUserid());

		return 0;
	}

	@RequestMapping(value = "/gaibianisOkff", method = RequestMethod.POST)
	public Object gaibianisOkff(HttpServletRequest request, HttpSession httpSession) {
		String userid = request.getParameter("userid");
		userTab uu = (userTab) httpSession.getAttribute("user");
		// System.out.println(userid+"userid");
		// System.out.println(uu.getUserid()+"uuuuuuuuu");
		int i = this.friendapplforservice.updateByPrimaryKey(2, Integer.parseInt(userid), uu.getUserid());
		return i;
	}

	@RequestMapping(value = "/chadotai", method = RequestMethod.GET) // ��ѯ��̬
	public Object chadotai(HttpServletRequest request, HttpSession httpSession) {
		userTab uu = (userTab) httpSession.getAttribute("user");
		List<qspace> lis = this.qspaceservice.selectqspace(uu.getUserid());
		return JSON.toJSONStringWithDateFormat(lis, "yyyy-MM-dd HH:mm:ss");
	}
	
	@RequestMapping(value = "/anidchadotai", method = RequestMethod.GET) // ��ѯ���ѵĶ�̬
	public Object anidchadotai(HttpServletRequest request, HttpSession httpSession) {
		String userId=request.getParameter("userId");
		List<qspace> lis = this.qspaceservice.selecthyqspace(Integer.parseInt(userId));
		return JSON.toJSONStringWithDateFormat(lis, "yyyy-MM-dd HH:mm:ss");
	}
	
	@RequestMapping(value = "/addpl", method = RequestMethod.POST) // �������
	public Object addpl(HttpServletRequest request, HttpSession httpSession) {
		String stateId = request.getParameter("stateId");
		String commentText = request.getParameter("commentText");
		userTab uu = (userTab) httpSession.getAttribute("user");
		comments comments = new comments();
		comments.setCommenttext(commentText);
		comments.setStateid(Integer.parseInt(stateId));
		comments.setUserid(uu.getUserid());
		this.commentsservice.insert(comments);
		comments lis = this.commentsservice.selectcommentId(comments.getCommentid());
		return lis;
	}

	@RequestMapping(value = "/adddianzan", method = RequestMethod.POST) // ����
	public Object adddianzan(HttpServletRequest request, HttpSession httpSession) {
		String stateId = request.getParameter("stateId");
		userTab uu = (userTab) httpSession.getAttribute("user");

		praiseRecord record = new praiseRecord();
		record.setStateid(Integer.parseInt(stateId));
		record.setUserid(uu.getUserid());
		this.praiserecordservice.insert(record);
		praiseRecord lis = this.praiserecordservice.selectpraiseid(record.getPraiseid());
		return lis;
	}

	@RequestMapping(value = "/deletedianzan", method = RequestMethod.POST) // ɾ������
	public Object deletedianzan(HttpServletRequest request, HttpSession httpSession) {
		userTab uu = (userTab) httpSession.getAttribute("user");
		String stateId = request.getParameter("stateId");
		int i = this.praiserecordservice.deleteByPrimaryKey(uu.getUserid(), Integer.parseInt(stateId));
		return i;
	}

	@RequestMapping(value = "/addhuifu", method = RequestMethod.POST) // �����ظ�
	public Object addhuifu(HttpServletRequest request, HttpSession httpSession) {
		String pasvUserId = request.getParameter("pasvUserId");
		String replyText = request.getParameter("replyText");
		String commentId = request.getParameter("commentId");
		userTab uu = (userTab) httpSession.getAttribute("user");
		reply reply=new reply();
		reply.setPasvuserid(Integer.parseInt(pasvUserId));
		reply.setCommentid(Integer.parseInt(commentId));
		reply.setReplytext(replyText);
		reply.setUserid(uu.getUserid());
		this.replyservice.insert(reply);
		reply lis=this.replyservice.selectreply(reply.getReplyid());
		return lis;
	}

	@RequestMapping(value = "/chahaoyoulbiao", method = RequestMethod.GET) // ��ѯ����
	public Object chahaoyou(HttpServletRequest request, HttpSession httpSession) {
		userTab uu = (userTab) httpSession.getAttribute("user");
		List<grouping> gg = this.groupingservice.selectuserId(uu.getUserid());

		for (grouping grouping : gg) {
			List<friend> fflis = fflis = this.friendservice.selectgroupingId(grouping.getGroupingid());
			grouping.setFriendlis(fflis);
		}
		return gg;
	}

	@RequestMapping(value = "/addfenzu", method = RequestMethod.POST) 
	public Object addfenzu(HttpServletRequest request, HttpSession httpSession) {
		userTab uu = (userTab) httpSession.getAttribute("user");
		String 	groupingName=request.getParameter("groupingName");
		grouping record=new grouping();
		record.setGroupingname(groupingName);
		record.setUserid(uu.getUserid());
	int i=	this.groupingservice.insertSelective(record);
		return i;
	}
	
	//�ϴ��ļ����Զ��󶨵�MultipartFile��
    @RequestMapping(value="upload",method=RequestMethod.POST)
    public String upload(HttpServletRequest request,
    		@RequestParam("text") String text,
            @RequestParam("file") CommonsMultipartFile[] file,
            @ModelAttribute("user") userTab my,
            HttpSession httpSession) throws Exception {
    	userTab uu = (userTab) httpSession.getAttribute("user");
    	String aaa=request.getParameter("aaa");
//    	spaceBackImg myspace=spaceService.selectMySpace(my.getUserid());
    	dynamicState record=new dynamicState();
		record.setStatetext(text);
		record.setSpaceid(Integer.parseInt(aaa));
		record.setUserid(uu.getUserid());
		dynamicstateservice.insertSelective(record);
    	System.out.println(aaa);
    	
    	for (int i = 0; i < file.length; i++) {
	       //����ļ���Ϊ�գ�д���ϴ�·��
	       if(!file[i].isEmpty()) {
	           //�ϴ��ļ�·��
	    	   
	           String path = request.getServletContext().getRealPath("/imagesUpload/"+uu.getUsername());
	           System.out.println(path);
	           //�ϴ��ļ���
	           /*String filename = file[i].getOriginalFilename();*/
	           String contentType=file[i].getContentType();
	           String filename = UUID.randomUUID().toString()+"."+contentType.substring(contentType.indexOf("/")+1);
	           
	           File filepath = new File(path,filename);
	           //�ж�·���Ƿ���ڣ���������ھʹ���һ��
	           if (!filepath.getParentFile().exists()) { 
	               filepath.getParentFile().mkdirs();
	           }
	           String imgUrl=path + File.separator + filename;
	           {
	        	   img stateImg=new img();
	        	   stateImg.setImgtype(1);
	        	   stateImg.setMasterid(record.getStateid());
	        	   stateImg.setUrl(imgUrl.substring(imgUrl.indexOf("imagesUpload")));
	        	   imgservice.insertSelective(stateImg);
	           }
	           //���ϴ��ļ����浽һ��Ŀ���ļ�����
	           file[i].transferTo(new File(imgUrl));
	       }
    	}
    	return "0";
    }
	
  //�ϴ��ļ����Զ��󶨵�MultipartFile��
    @RequestMapping(value="uploadtox",method=RequestMethod.POST)
    public String uploadtox(HttpServletRequest request,
            @RequestParam("file") CommonsMultipartFile[] file,
            HttpSession httpSession) throws Exception {
    	userTab uu = (userTab) httpSession.getAttribute("user");
    	for (int i = 0; i < file.length; i++) {
	       //����ļ���Ϊ�գ�д���ϴ�·��
	       if(!file[i].isEmpty()) {
	           //�ϴ��ļ�·��
	    	   
	           String path = request.getServletContext().getRealPath("/imagesUpload/"+uu.getUsername());
	           System.out.println(path);
	           //�ϴ��ļ���
	           /*String filename = file[i].getOriginalFilename();*/
	           String contentType=file[i].getContentType();
	           String filename = UUID.randomUUID().toString()+"."+contentType.substring(contentType.indexOf("/")+1);
	           
	           File filepath = new File(path,filename);
	           //�ж�·���Ƿ���ڣ���������ھʹ���һ��
	           if (!filepath.getParentFile().exists()) { 
	               filepath.getParentFile().mkdirs();
	           }
	           String imgUrl=path + File.separator + filename;
	           {
	        	userTab userTab =new userTab();
	        	userTab.setUserid(uu.getUserid());
	        	userTab.setHeadimg(imgUrl.substring(imgUrl.indexOf("imagesUpload")));
	        	  this.usertabservice.insertSelective(userTab);
	        	   
	        	   
	           }
	           //���ϴ��ļ����浽һ��Ŀ���ļ�����
	           file[i].transferTo(new File(imgUrl));
	       }
    	}
    	return "0";
    }
	
	// @RequestMapping(value="/sctox",method=RequestMethod.POST)
	// public Object sctox(HttpServletRequest request,HttpSession session) throws
	// IOException, ServletException {//�ϴ�ͷ��
	// //�ϴ��ļ�
	// //��������ϴ����ļ�
	// String newfilename=null;
	//
	// Collection<Part> parts = request.getParts();
	// // System.out.println(parts);
	// for (Part part : parts) {
	// // System.out.println(part.getSubmittedFileName());
	// if(part.getSubmittedFileName()==null)
	// continue;
	// //���ԭʼ���ļ���
	// String filename = part.getSubmittedFileName();
	// //Ϊ�ϴ����ļ�������������(����)
	// String ext = filename.substring(filename.lastIndexOf("."));
	// newfilename = UUID.randomUUID().toString()+ext;
	//
	// //���upload������·����Ӧ������·��
	// String path = request.getServletContext().getRealPath("/upload");
	// //��upload��Ϊÿ���û������û���Id������Ӧ���ļ���
	// userTab uu=(userTab) session.getAttribute("user");
	// String userid = uu.getUsername();
	// path += "\\"+userid;
	// File file = new File(path);
	//
	// if(filename.lastIndexOf("/")!=-1) {
	// String[] fg=filename.split("/");
	// for (String string : fg) {
	// if(string.lastIndexOf(".")!=-1) {
	// break;
	// }
	// System.out.println(string);
	//
	// }
	//
	// }
	//
	//
	// return usertabservice;
	// }
	// return parts;
	// }
}