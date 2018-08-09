package com.accp.qqemail.dao.impl;

import java.util.List;

import com.accp.qqemail.dao.MailinfoDao;
import com.accp.qqemail.entity.Mailinfo;
import com.accp.qqemail.util.DBHelper;

public class MailinfoDaoImpl implements MailinfoDao {
	@Override
	public int huizhiinsert(Mailinfo mailinfo) {
		String sql="INSERT INTO `mailinfo` (`Title`,`recContent`,`senEmail`,`normalEmail`,`isdraft`,`createTime`) VALUES(?,?,?,?,?,NOW())";
		return DBHelper.update(sql,mailinfo.getTitle(),mailinfo.getRecContent(),mailinfo.getSenEmail(),mailinfo.getNormalEmail(),mailinfo.getIsdraft());
	}
	@Override
	public int insert(Mailinfo mailinfo) {
		String sql="INSERT INTO `mailinfo` (`Title`,`recContent`,`senEmail`,`normalEmail`,`copyEmail`,`secretEmail`,`isdraft`,`RecFlag`,`createTime`) VALUES(?,?,?,?,?,?,?,?,NOW())";
		return DBHelper.update(sql,mailinfo.getTitle(),mailinfo.getRecContent(),mailinfo.getSenEmail(),mailinfo.getNormalEmail(),mailinfo.getCopyEmail(),mailinfo.getSecretEmail(),mailinfo.getIsdraft(),mailinfo.getRecFlag());
	}

	@Override
	public Mailinfo query(String senEmail) {
		String sql="SELECT * FROM `mailinfo` WHERE senEmail=? ORDER BY `createTime` DESC";
	    List<Mailinfo> lis=	DBHelper.Query(Mailinfo.class, sql, senEmail);
	    if(lis!=null&&lis.size()!=0) {
	    	return lis.get(0);
	    }
		return null;
	}

	@Override
	public int deleteyj(int relId) {
		String sql="DELETE FROM `mailinfo` WHERE `mailId` = ?";
		return DBHelper.update(sql,relId);
	}

	@Override
	public Mailinfo query(int mailId) {
		String sql="SELECT * FROM `mailinfo` WHERE mailId=?";
		  List<Mailinfo> lis=	DBHelper.Query(Mailinfo.class, sql, mailId);
		    if(lis!=null&&lis.size()!=0)
				return lis.get(0);
		return null;
	}

	
	
	
}
