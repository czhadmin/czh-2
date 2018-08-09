package com.accp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.entity.dynamicState;
import com.accp.entity.friend;
import com.accp.entity.grouping;
import com.accp.entity.userTab;
import com.accp.service.DynamicStateService;
import com.accp.service.FriendService;
import com.accp.service.GroupingService;
import com.accp.service.UserTabService;

@Controller
public class QQController {

	@Autowired
	private UserTabService usertabservice;
	
	@Autowired
	private GroupingService groupingservice;// �����
	
	@Autowired
	private FriendService friendservice;// ���ѹ�ϵ��
	
	@Autowired
	private DynamicStateService dynamicstateservice;//��̬��
	
	@RequestMapping("/tozc")
	public Object tozc() {
		return "page/zc";
	}
	
	@RequestMapping("/todl")
	public Object todl(HttpServletRequest req) {
		String name=req.getParameter("name");
		System.out.println(name);
		return "page/dl";
	}
	
	@RequestMapping("/dodl")
	public Object dodl(HttpServletRequest req,HttpSession session) {
		String zh=req.getParameter("zh");
		String mm=req.getParameter("mm");
		if(this.usertabservice.selectdl(zh, mm)==null) {
			return "redirect:/todl";
		}
		session.setAttribute("user", this.usertabservice.selectdl(zh,mm));
		
		return "redirect:/toindex";
	}
	
	@RequestMapping("/tosearchFriend")//������ѯ�û�
	public Object tosearchFriend(HttpServletRequest request,HttpSession httpSession) {
		userTab uu=(userTab) httpSession.getAttribute("user");
		String pd=request.getParameter("pd");
		
		System.out.println(pd);
		request.setAttribute("userTab", uu);
		return "page/searchFriend";
	}
	
	@RequestMapping("/toindex")//����������
	public Object toindex() {
		return "page/index";
	}
	
	@RequestMapping("/toNewsList")//���������������Ϣ
	public Object toNewsList(HttpServletRequest request,HttpSession httpSession) {
		userTab uu=(userTab) httpSession.getAttribute("user");
		List<friend> lis=this.friendservice.selectusid(uu.getUserid());
		for (friend friend : lis) {
			dynamicState dd=this.dynamicstateservice.selectusid(friend.getHyuser().getUserid());
			friend.getHyuser().setDtstate(dd);;
		}
		request.setAttribute("lis",lis);
		return "page/NewsList";
	}
	
	@RequestMapping("/toaddFriend")//������Ӻ���
	public Object toaddFriend(HttpServletRequest req,HttpSession httpSession) {
		String userid=req.getParameter("userid");//��ȡҪ��ӵ��û�id
		userTab uu=(userTab)httpSession.getAttribute("user");
		
		if(this.friendservice.selectsfhy(uu.getUserid(),Integer.parseInt(userid))!=null){
			System.out.println("�����Ѿ��Ǻ���");
			return "redirect:/tosearchFriend?pd=1";
		}
		
		String groupingId=req.getParameter("groupingId");
		
		String fzname=req.getParameter("fzname");//��ȡѡ����������
		if(groupingId!=null) {
			req.setAttribute("groupingId",groupingId );
		}
		if(fzname!=null) {
			req.setAttribute("fzname",fzname );
		}
		
		userTab userTab=this.usertabservice.selectByPrimaryKey(Integer.parseInt(userid));
		
		req.setAttribute("userTab", userTab);
		
		
		req.setAttribute("uu", uu);
		return "page/addFriend";
	}
	
	@RequestMapping("/toyiaddFriend")//����ͬ���������
	public Object toyiaddFriend(HttpServletRequest req,HttpSession httpSession) {
		String userid=req.getParameter("userid");//��ȡ�û�id
		
		System.out.println(userid);
		
		String groupingId=req.getParameter("groupingId");//�Լ��ķ���id
		req.setAttribute("groupingId",groupingId );
		
		String hygroupingId=req.getParameter("hygroupingId");//���ѵķ���id
		
		httpSession.setAttribute("hygroupingId",hygroupingId);
		
		
		
		String beizhu=req.getParameter("beizhu");//��ȡ��ע
		
			httpSession.setAttribute("beizhu",beizhu );
		
		String fzname=req.getParameter("fzname");//��ȡѡ����������
		
			
		
		if(fzname!=null) {
			req.setAttribute("fzname",fzname );
		}
		
		userTab userTab=this.usertabservice.selectByPrimaryKey(Integer.parseInt(userid));
		
		req.setAttribute("userTab", userTab);
		
		userTab uu=(userTab)httpSession.getAttribute("user");
		req.setAttribute("uu", uu);
		
		return "page/toyiaddFriend";
	}
	
	@RequestMapping("/toselectGroup")//����ѡ�����
	public Object toselectGroup(HttpServletRequest req,HttpSession httpSession) {
		String userid=req.getParameter("userid");
		String hyid=req.getParameter("hyid");
		req.setAttribute("hyid", hyid);
		httpSession.setAttribute("tjuserid", userid);
		return "page/selectGroup";
	}
	
	@RequestMapping("/toselectGrouptoyi")//����ѡ�����(ͬ�����)
	public Object toselectGrouptoyi(HttpServletRequest req,HttpSession httpSession) {
		String userid=req.getParameter("userid");
		httpSession.setAttribute("tjuserid", userid);
		String hhid=req.getParameter("hhid");
		req.setAttribute("hhid",hhid);
		req.setAttribute("hygroupingId", httpSession.getAttribute("hygroupingId"));
		req.setAttribute("beizhu", httpSession.getAttribute("beizhu"));
		return "page/selectGrouptoyi";
	}
	
	@RequestMapping("/todotai")//������̬
	public Object todotai(HttpServletRequest req,HttpSession httpSession) {
		String uuuid=req.getParameter("uuuid");
		if(uuuid!="") {
			req.setAttribute("uuuid", uuuid);
		}
		userTab uu=(userTab)httpSession.getAttribute("user");
		req.setAttribute("uu", uu);
		return "page/dotai";
	}
	
	@RequestMapping("/toFriendsList")//�������ѷ���
	public Object toFriendsList(HttpServletRequest req,HttpSession httpSession) {
		userTab uu=(userTab)httpSession.getAttribute("user");
		List<grouping> gg = this.groupingservice.selectuserId(uu.getUserid());

		for (grouping grouping : gg) {
			List<friend> fflis = fflis = this.friendservice.selectgroupingId(grouping.getGroupingid());
			grouping.setFriendlis(fflis);
		}
		req.setAttribute("gg", gg);
		return "page/FriendsList";
	}
	@RequestMapping("/toaddState")//����������̬
	public Object toaddState(HttpServletRequest req) {
		String spaceId=req.getParameter("spaceId");
		req.setAttribute("aaa",spaceId);
		return "page/addState";
	}
}
