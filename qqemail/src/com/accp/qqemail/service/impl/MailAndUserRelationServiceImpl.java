package com.accp.qqemail.service.impl;

import com.accp.qqemail.dao.MailAndUserRelationDao;
import com.accp.qqemail.dao.impl.MailAndUserRelationDaoImpl;
import com.accp.qqemail.entity.MailAndUserRelation;
import com.accp.qqemail.service.MailAndUserRelationService;

public class MailAndUserRelationServiceImpl implements MailAndUserRelationService {
	
	MailAndUserRelationDao mdao=new MailAndUserRelationDaoImpl();
	@Override
	public int insert(MailAndUserRelation mailAndUserRelation) {
		// TODO Auto-generated method stub
		return this.mdao.insert(mailAndUserRelation);
	}
	@Override
	public int updatesc(int deleteState, int relId) {
		// TODO Auto-generated method stub
		return this.mdao.updatesc(deleteState, relId);
	}
	@Override
	public int cdsc(int relId) {
		// TODO Auto-generated method stub
		return this.mdao.cdsc(relId);
	}
	@Override
	public int ydd(int foId, int relId) {
		// TODO Auto-generated method stub
		return this.mdao.ydd(foId, relId);
	}
	@Override
	public int bjiyd(int readState,int relId) {
		// TODO Auto-generated method stub
		return this.mdao.bjiyd(readState,relId);
	}
	@Override
	public int queryweidu(int userId) {
		// TODO Auto-generated method stub
		return this.mdao.queryweidu(userId);
	}
	@Override
	public int querysj(int userId) {
		// TODO Auto-generated method stub
		return this.mdao.querysj(userId);
	}

}
