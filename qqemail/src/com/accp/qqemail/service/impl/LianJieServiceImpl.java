package com.accp.qqemail.service.impl;

import com.accp.qqemail.dao.LianJie3Dao;
import com.accp.qqemail.dao.impl.LianJie3DaoImpl;
import com.accp.qqemail.entity.LianJie3;
import com.accp.qqemail.entity.pageba;
import com.accp.qqemail.service.LianJieService;

public class LianJieServiceImpl implements LianJieService {
		LianJie3Dao lianjiedao=new LianJie3DaoImpl();
	@Override
	public pageba<LianJie3> pagequery(int userId, int foId, int deleteState, int dqy, int tiaoshu) {
		// TODO Auto-generated method stub
		return this.lianjiedao.pagequery(userId, foId, deleteState, dqy, tiaoshu);
	}
	@Override
	public LianJie3 query(int relId) {
		// TODO Auto-generated method stub
		return this.lianjiedao.query(relId);
	}
	@Override
	public pageba<LianJie3> pagequerycg(int isdraft,String senEmail,int dqy,int tiaoshu) {
		// TODO Auto-generated method stub
		return this.lianjiedao.pagequerycg(isdraft, senEmail, dqy, tiaoshu);
	}

}
