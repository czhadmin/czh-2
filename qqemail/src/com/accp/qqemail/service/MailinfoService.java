package com.accp.qqemail.service;

import com.accp.qqemail.entity.Mailinfo;

public interface MailinfoService {
	int insert(Mailinfo mailinfo);
	
	 /*按发件人email倒序查询*/
	 Mailinfo query(String senEmail);
	 
	 //删除草稿箱
	 int deleteyj(int relId);
	 
	 
	 /*按邮件id查询*/
	 Mailinfo query(int mailId);
	 
		/*新增回执邮件*/
	 int huizhiinsert(Mailinfo mailinfo);
}
