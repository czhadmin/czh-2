package com.accp.qqemail.service;

import java.util.List;

import com.accp.qqemail.entity.User;

public interface UserService {
	  /*查询全部*/
	  List<User> query();
	  
	  /*按用户id查询*/
	  User query(int userId);
	  
	  /*按邮箱称查询*/
	  User query(String email);
	  
	  /*按邮箱和密码称查询*/
	  User query(User user);
	  
	  /*新增用户*/
	  int insert(User user);
}
