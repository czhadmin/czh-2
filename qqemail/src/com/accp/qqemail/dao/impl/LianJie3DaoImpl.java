package com.accp.qqemail.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.accp.qqemail.dao.LianJie3Dao;
import com.accp.qqemail.entity.LianJie3;
import com.accp.qqemail.entity.pageba;
import com.accp.qqemail.util.DBHelper;

public class LianJie3DaoImpl implements LianJie3Dao {

	@Override
	public pageba<LianJie3> pagequery(int userId, int foId, int deleteState, int dqy, int tiaoshu) {
		if(foId==0){
			//调用已删除
			pageba<LianJie3> stu=new pageba<LianJie3>(chacont1(userId,deleteState), dqy, tiaoshu, query1(userId,deleteState,dqy,tiaoshu));
			return stu;
		}
		pageba<LianJie3> stu=new pageba<LianJie3>(chacont(userId,foId,deleteState), dqy, tiaoshu, query(userId,foId,deleteState,dqy,tiaoshu));
		return stu;
	}
	
	public List<LianJie3> query(int userId,int foId,int deleteState,int dqy,int tiaoshu) {
		String sql=" SELECT gx.`mailId`,gx.`mailModel`,gx.`readState`,gx.`foId`,gx.`createTime`,gx.`relId`,gx.`isRec`,\r\n" + 
				"   yj.`Title`,yj.`senEmail`,yj.`recContent`,yj.`normalEmail`,yj.`copyEmail`,fj.`encAdress` FROM `mailanduserrelation` AS gx\r\n" + 
				"   JOIN `mailinfo` AS yj ON gx.`mailId`=yj.`mailId`\r\n" + 
				"  LEFT JOIN `enclosure` AS fj ON yj.`mailId`=fj.`mailId`\r\n" + 
				"   WHERE  gx.`userId`=? AND gx.`foId`=? AND gx.`deleteState`=?\r\n" + 
				" ORDER BY gx.`createTime` DESC LIMIT ?,?";
		return  DBHelper.Query(LianJie3.class, sql,userId,foId,deleteState,(dqy-1)*tiaoshu,tiaoshu);
	}
	public int chacont(int userId,int foId,int deleteState) {
		String sql=" SELECT COUNT(*) FROM `mailanduserrelation` AS gx\r\n" + 
				"    JOIN `mailinfo` AS yj ON gx.`mailId`=yj.`mailId`\r\n" + 
				"    LEFT JOIN `enclosure` AS fj ON yj.`mailId`=fj.`mailId`\r\n" + 
				"    WHERE  gx.`userId`=? AND gx.`foId`=? AND gx.`deleteState`=?\r\n" + 
				"    ORDER BY gx.`createTime` DESC";
		return (int)(long) DBHelper.Querydanhang(new ScalarHandler<>(),sql,userId,foId,deleteState);//总条数
	}
	@Override
	public LianJie3 query(int relId) {
		String sql="  SELECT gx.`mailId`,gx.`mailModel`,gx.`readState`,gx.`foId`,gx.`createTime`,gx.`relId`,gx.`isRec`,\r\n" + 
				" yj.`Title`,yj.`senEmail`,yj.`recContent`,yj.`normalEmail`,yj.`copyEmail`,fj.`encAdress` FROM `mailanduserrelation` AS gx\r\n" + 
				" JOIN `mailinfo` AS yj ON gx.`mailId`=yj.`mailId`\r\n" + 
				" LEFT JOIN `enclosure` AS fj ON yj.`mailId`=fj.`mailId`\r\n" + 
				" WHERE  gx.`relId`=?";
		List<LianJie3>lis=DBHelper.Query(LianJie3.class, sql,relId);
		if(lis!=null&&lis.size()!=0)
			return lis.get(0);
		return null;
	}
	
	//已删除
		public int chacont1(int userId,int deleteState) {
			String sql=" SELECT COUNT(*) FROM `mailanduserrelation` AS gx\r\n" + 
					"    JOIN `mailinfo` AS yj ON gx.`mailId`=yj.`mailId`\r\n" + 
					"    LEFT JOIN `enclosure` AS fj ON yj.`mailId`=fj.`mailId`\r\n" + 
					"    WHERE  gx.`userId`=?  AND gx.`deleteState`=?\r\n" + 
					"    ORDER BY gx.`createTime` DESC";
			return (int)(long) DBHelper.Querydanhang(new ScalarHandler<>(),sql,userId,deleteState);//总条数
		}
		//已删除
		public List<LianJie3> query1(int userId,int deleteState,int dqy,int tiaoshu) {
			String sql=" SELECT gx.`mailId`,gx.`mailModel`,gx.`readState`,gx.`foId`,gx.`createTime`,gx.`relId`,gx.`isRec`,\r\n" + 
					"   yj.`Title`,yj.`senEmail`,yj.`recContent`,yj.`normalEmail`,yj.`copyEmail`,fj.`encAdress` FROM `mailanduserrelation` AS gx\r\n" + 
					"   JOIN `mailinfo` AS yj ON gx.`mailId`=yj.`mailId`\r\n" + 
					"  LEFT JOIN `enclosure` AS fj ON yj.`mailId`=fj.`mailId`\r\n" + 
					"   WHERE  gx.`userId`=?  AND gx.`deleteState`=?\r\n" + 
					" ORDER BY gx.`createTime` DESC LIMIT ?,?";
			return  DBHelper.Query(LianJie3.class, sql,userId,deleteState,(dqy-1)*tiaoshu,tiaoshu);
		}
	//草稿箱
		public int chacontcaogao(int isdraft,String senEmail) {
			String sql="SELECT COUNT(*) FROM `mailinfo` AS yj\r\n" + 
					" LEFT JOIN `enclosure` AS fj ON yj.`mailId`=fj.`mailId`\r\n" + 
					"  WHERE   yj.`isdraft`=? and yj.`senEmail`=?";
			return (int)(long) DBHelper.Querydanhang(new ScalarHandler<>(),sql,isdraft,senEmail);//总条数
		}
		//草稿箱
		public List<LianJie3> querycaogao(int isdraft,String senEmail,int dqy,int tiaoshu) {
			String sql="SELECT yj.mailId,yj.`Title`,yj.`senEmail`,yj.`recContent`,yj.`normalEmail`,yj.`copyEmail`,fj.`encAdress`,yj.`createTime` FROM `mailinfo` AS yj\r\n" + 
					" LEFT JOIN `enclosure` AS fj ON yj.`mailId`=fj.`mailId`\r\n" + 
					"  WHERE   yj.`isdraft`=? and yj.`senEmail`=? LIMIT ?,?";
			return  DBHelper.Query(LianJie3.class, sql,isdraft,senEmail,(dqy-1)*tiaoshu,tiaoshu);
		}

		@Override
		//查草稿
		public pageba<LianJie3> pagequerycg(int isdraft,String senEmail,int dqy,int tiaoshu) {
			pageba<LianJie3> stu=new pageba<LianJie3>(chacontcaogao(isdraft, senEmail), dqy, tiaoshu,querycaogao( isdraft, senEmail, dqy, tiaoshu));
			return stu;
		}
	
}
