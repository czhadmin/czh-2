package com.accp.qqemail.service;

import com.accp.qqemail.entity.Mailinfo;

public interface MailinfoService {
	int insert(Mailinfo mailinfo);
	
	 /*��������email�����ѯ*/
	 Mailinfo query(String senEmail);
	 
	 //ɾ���ݸ���
	 int deleteyj(int relId);
	 
	 
	 /*���ʼ�id��ѯ*/
	 Mailinfo query(int mailId);
	 
		/*������ִ�ʼ�*/
	 int huizhiinsert(Mailinfo mailinfo);
}
