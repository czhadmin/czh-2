package com.accp.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.entity.frienDapplfor;
import com.accp.mapper.frienDapplforMapper;

@Service
public class FrienDapplforService {

	@Autowired
	private frienDapplforMapper frienDapplforMapper;
	public  int insertSelective(frienDapplfor record) {
		return this.frienDapplforMapper.insertSelective(record);
	}
	
	public List<frienDapplfor> selectall(int userid){
		return this.frienDapplforMapper.selectall(userid);
	}
	
	public   int updateByPrimaryKey(@Param("isok")int isok,@Param("userid")int userid,@Param("pasvuserid")int pasvuserid) {
		return this.frienDapplforMapper.updateByPrimaryKey(isok,userid,pasvuserid);
	}
}
