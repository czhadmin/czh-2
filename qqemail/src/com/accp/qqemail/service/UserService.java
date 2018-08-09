package com.accp.qqemail.service;

import java.util.List;

import com.accp.qqemail.entity.User;

public interface UserService {
	  /*��ѯȫ��*/
	  List<User> query();
	  
	  /*���û�id��ѯ*/
	  User query(int userId);
	  
	  /*������Ʋ�ѯ*/
	  User query(String email);
	  
	  /*�����������Ʋ�ѯ*/
	  User query(User user);
	  
	  /*�����û�*/
	  int insert(User user);
}
