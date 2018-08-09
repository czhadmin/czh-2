package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.entity.grouping;
import com.accp.mapper.groupingMapper;

@Service
public class GroupingService {

	@Autowired
	private groupingMapper groupingMapper;
	public     int insertSelective(grouping record) {
		return this.groupingMapper.insertSelective(record);
	}
	
	public List<grouping> selectuserId(int userId) {
		return this.groupingMapper.selectuserId(userId);
	}

}
