package com.accp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.entity.reply;
import com.accp.mapper.replyMapper;

@Service
public class ReplyService {

	@Autowired
	private replyMapper replyMapper;
	
	public  int insert(reply record) {
		return this.replyMapper.insert(record);
	}
	
	public  reply selectreply(int replyid) {
		return this.replyMapper.selectreply(replyid);
	}
}
