package com.accp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.entity.comments;
import com.accp.mapper.commentsMapper;

@Service
public class CommentsService {

	@Autowired
	private commentsMapper commentsMapper;
	public  int insert(comments record) {
		return this.commentsMapper.insert(record);
	}
	public comments selectcommentId(int commentid) {
		return this.commentsMapper.selectcommentId(commentid);
	}
}
