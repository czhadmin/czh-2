package com.accp.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.accp.dao.HeTiDao;
import com.accp.entity.HeTi;
import com.accp.util.DbHelper;

public class HeTiDaoImpl implements HeTiDao{

	@Override
	public List<HeTi> query(int orderId) {
		Connection conn=null;
		List<HeTi>lis=null;
		try {
			conn=DbHelper.getConnection();
			String sql="SELECT * FROM `orderdetails` AS congwc JOIN `goods` AS sp ON congwc.`orgoodsId`=sp.`id` WHERE congwc.`orderId`=?";
			QueryRunner query=new QueryRunner();
			lis=query.query(conn,sql,new BeanListHandler<HeTi>(HeTi.class),orderId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lis;
	}

}
