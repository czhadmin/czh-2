package com.accp.qqemail.service;

import com.accp.qqemail.entity.LianJie3;
import com.accp.qqemail.entity.pageba;

public interface LianJieService {
	pageba<LianJie3> pagequery(int userId,int foId,int deleteState,int dqy,int tiaoshu);
	
	//²Ý¸å
		pageba<LianJie3> pagequerycg(int isdraft,String senEmail,int dqy,int tiaoshu);
		
	LianJie3 query(int relId);
}
