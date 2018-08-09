package com.accp.qqemail.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.accp.qqemail.dao.MailAndUserRelationDao;
import com.accp.qqemail.entity.MailAndUserRelation;
import com.accp.qqemail.entity.Mailinfo;
import com.accp.qqemail.util.DBHelper;

public class MailAndUserRelationDaoImpl implements MailAndUserRelationDao{

	@Override
	public int insert(MailAndUserRelation mailAndUserRelation) {
		String sql="insert into `mailanduserrelation` (\r\n" + 
				"  `userId`,\r\n" + 
				"  `mailId`,\r\n" + 
				"  `mailModel`,\r\n" + 
				"  `readState`,\r\n" + 
				"  `deleteState`,\r\n" + 
				"  `foId`,\r\n" + 
				"  `isRec`,\r\n" + 
				"  `createTime`\r\n" + 
				") \r\n" + 
				"values\r\n" + 
				"  (\r\n" + 
				"    ?,\r\n" + 
				"    ?,\r\n" + 
				"    ?,\r\n" + 
				"    ?,\r\n" + 
				"    ?,\r\n" + 
				"    ?,\r\n" + 
				"    ?,\r\n" + 
				"    NOW())";
		return DBHelper.update(sql, mailAndUserRelation.getUserId(),mailAndUserRelation.getMailId()
				,mailAndUserRelation.getMailModel(),mailAndUserRelation.getReadState(),mailAndUserRelation.getDeleteState()
				,mailAndUserRelation.getFoId(),mailAndUserRelation.getIsRec());
	}

	@Override
	public int updatesc(int deleteState,int relId) {
		String sql="update `mailanduserrelation` set `deleteState` = ?  where `relId` =?";
		return DBHelper.update(sql, deleteState,relId);
	}

	@Override
	public int cdsc(int relId) {
		String sql="DELETE FROM`mailanduserrelation` WHERE `relId` = ?";
		return DBHelper.update(sql, relId);
	}

	@Override
	public int ydd(int foId,int relId) {
	String sql="update `qqemail`.`mailanduserrelation` set  `foId` = ? where `relId` = ? ";
		return DBHelper.update(sql,foId,relId);
	}

	@Override
	public int bjiyd(int readState,int relId) {
		String sql="update `qqemail`.`mailanduserrelation` set  `readState` = ? where `relId` = ? ";
		return DBHelper.update(sql,readState,relId);
	}

	@Override
	public int queryweidu(int userId) {
		String sql="SELECT COUNT(*) FROM `mailanduserrelation` WHERE `userId`=? AND `readState`=0 and foId=2";
		return (int)(long) DBHelper.Querydanhang(new ScalarHandler<>(), sql, userId);
	}

	@Override
	public int querysj(int userId) {
		String sql="SELECT COUNT(*) FROM `mailanduserrelation` WHERE `userId`=?  AND foId=2";
		return (int)(long) DBHelper.Querydanhang(new ScalarHandler<>(), sql, userId);
	}
}
