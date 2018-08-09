package com.accp.qqemail.service.impl;

import com.accp.qqemail.dao.MailinfoDao;
import com.accp.qqemail.dao.impl.MailinfoDaoImpl;
import com.accp.qqemail.entity.Mailinfo;
import com.accp.qqemail.service.MailinfoService;

public class MailinfoServiceImpl implements MailinfoService {

		MailinfoDao maiiinfodao=new MailinfoDaoImpl();
	@Override
	public int insert(Mailinfo mailinfo) {
		// TODO Auto-generated method stub
		return this.maiiinfodao.insert(mailinfo);
	}
	@Override
	public Mailinfo query(String senEmail) {
		// TODO Auto-generated method stub
		return this.maiiinfodao.query(senEmail);
	}
	@Override
	public int deleteyj(int relId) {
		// TODO Auto-generated method stub
		return this.maiiinfodao.deleteyj(relId);
	}
	@Override
	public Mailinfo query(int mailId) {
		// TODO Auto-generated method stub
		return this.maiiinfodao.query(mailId);
	}
	@Override
	public int huizhiinsert(Mailinfo mailinfo) {
		// TODO Auto-generated method stub
		return this.maiiinfodao.huizhiinsert(mailinfo);
	}

}
