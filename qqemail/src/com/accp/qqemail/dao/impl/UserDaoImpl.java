package com.accp.qqemail.dao.impl;

import java.util.List;

import com.accp.qqemail.dao.UserDao;
import com.accp.qqemail.entity.User;
import com.accp.qqemail.util.DBHelper;

public class UserDaoImpl implements UserDao{

	@Override
	public List<User> query() {
		String sql="select * from user";
		return DBHelper.Query(User.class,sql);
	}

	@Override
	public User query(int userId) {
		String sql="select * from user where userId=?";
		List<User> lis=DBHelper.Query(User.class, sql, userId);
			if(lis!=null&&lis.size()!=0)
				return lis.get(0);
		return null;
	}

	@Override
	public User query(String email) {
		String sql="select * from user where email=?";
		List<User> lis=DBHelper.Query(User.class, sql,email);
		if(lis!=null&&lis.size()!=0)
			return lis.get(0);
		return null;
	}

	@Override
	public int insert(User user) {
		String sql="INSERT INTO `user` (`email`, `password`, `nickName`, `registerTime`)VALUES(?,?,?,CURDATE())";
		return DBHelper.update(sql, user.getEmail(),user.getPassword(),user.getNickName());
	}

	@Override
	public User query(User user) {
		String sql="select * from user where email=? and password=?";
		List<User> lis=DBHelper.Query(User.class, sql,user.getEmail(),user.getPassword());
		if(lis!=null&&lis.size()!=0)
			return lis.get(0);
		return null;
	}

}
