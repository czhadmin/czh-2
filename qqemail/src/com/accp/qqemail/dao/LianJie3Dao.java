package com.accp.qqemail.dao;

import java.util.List;

import com.accp.qqemail.entity.LianJie3;
import com.accp.qqemail.entity.pageba;

public interface LianJie3Dao {
	
	pageba<LianJie3> pagequery(int userId,int foId,int deleteState,int dqy,int tiaoshu);
	//ฒÝธๅ
	pageba<LianJie3> pagequerycg(int isdraft,String senEmail,int dqy,int tiaoshu);
	//ฯ๊ว้
	LianJie3 query(int relId);
}
