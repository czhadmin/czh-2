package com.accp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.entity.praiseRecord;
import com.accp.mapper.praiseRecordMapper;

@Service
public class PraiseRecordService {

	@Autowired
	private praiseRecordMapper praiseRecordMapper;
	public int insert(praiseRecord record) {
		return this.praiseRecordMapper.insert(record);
	}
	
	public praiseRecord selectpraiseid(int praiseid) {
		return this.praiseRecordMapper.selectpraiseid(praiseid);
	}
	public  int deleteByPrimaryKey(Integer userid,int stateId) {
		return this.praiseRecordMapper.deleteByPrimaryKey(userid,stateId);
	}
}
