package com.accp.qqemail.dao;

import java.util.List;

import com.accp.qqemail.entity.MailAndUserRelation;

public interface MailAndUserRelationDao {
	
		int insert(MailAndUserRelation mailAndUserRelation);
		
		int updatesc(int deleteState,int relId);
		
		//彻底删除
		int cdsc(int relId);
		
		//移动到
		int ydd(int foId,int relId);
		
		//标记为已读
		int bjiyd(int readState,int relId);
		
		//查询未读
		int queryweidu(int userId);
		
		//查询收件
		int querysj(int userId);
}
