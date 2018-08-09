package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.entity.dynamicState;
import com.accp.entity.qspace;
import com.accp.mapper.qspaceMapper;

@Service
public class QspaceService {

	@Autowired 
	private qspaceMapper qspaceMapper;
	
	public List<qspace> selectqspace(int userid) {
		return this.qspaceMapper.selectqspace(userid);
	}
	
	public List<qspace> selecthyqspace(int userid){
		return this.qspaceMapper.selecthyqspace(userid);
	}
}
