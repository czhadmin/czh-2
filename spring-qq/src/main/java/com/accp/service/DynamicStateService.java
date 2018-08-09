package com.accp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.entity.dynamicState;
import com.accp.entity.dynamicStateWithBLOBs;
import com.accp.mapper.dynamicStateMapper;

@Service
public class DynamicStateService {

	@Autowired
	private dynamicStateMapper dynamicStateMapper;
	
	public  dynamicState selectusid(int userid) {
		
		return this.dynamicStateMapper.selectusid(userid);
	}
	
	public int insertSelective(dynamicState record) {
		return this.dynamicStateMapper.insertSelective(record);
	}
}
