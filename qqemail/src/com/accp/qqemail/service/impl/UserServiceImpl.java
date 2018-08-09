package com.accp.qqemail.service.impl;

import java.util.List;

import com.accp.qqemail.dao.UserDao;
import com.accp.qqemail.dao.impl.UserDaoImpl;
import com.accp.qqemail.entity.User;
import com.accp.qqemail.service.UserService;

public class UserServiceImpl implements UserService {
		UserDao userdao=new UserDaoImpl();
	@Override
	public List<User> query() {
		// TODO Auto-generated method stub
		return this.userdao.query();
	}

	@Override
	public User query(int userId) {
		// TODO Auto-generated method stub
		return this.userdao.query(userId);
	}

	@Override
	public User query(String email) {
		// TODO Auto-generated method stub
		return this.userdao.query(email);
	}

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return this.userdao.insert(user);
	}

	@Override
	public User query(User user) {
		// TODO Auto-generated method stub
		return this.userdao.query(user);
	}

}
