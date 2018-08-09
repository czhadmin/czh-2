package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.entity.userTab;
import com.accp.mapper.userTabMapper;

@Service
public class UserTabService {

	@Autowired
	private userTabMapper userTabMapper;
	
	public int insertSelective(userTab record) {
		return this.userTabMapper.insertSelective(record);
	}

	public  int insert(userTab record) {
		return this.userTabMapper.insert(record);
	}
	
	public userTab selectdl(String username,String password){
		return this.userTabMapper.selectdl(username,password);
	}
	
	public  List<userTab> selecthaoyou(String username){
		return this.userTabMapper.selecthaoyou(username);
	}
	
	public userTab selectByPrimaryKey(Integer userid) {
		return this.userTabMapper.selectByPrimaryKey(userid);
	}
	
	public userTab selectus(int userid) {
		return this.userTabMapper.selectus(userid);
	}
	
	public List<userTab> selectqb(){
		return this.userTabMapper.selectqb();
	}
	
	public  int updateByPrimaryKeySelective(userTab record) {
		return this.userTabMapper.updateByPrimaryKeySelective(record);
	}
}
