package com.accp.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.accp.dao.GoodsDao;
import com.accp.entity.Customers;
import com.accp.entity.Goods;
import com.accp.util.DbHelper;

public class GoodsDaoImpl implements GoodsDao {

	@Override
	public List<Goods> query() {
		Connection conn=null;
		List<Goods> lis=null;
		try {
			conn=DbHelper.getConnection();
			String sql="SELECT  * FROM`goods`;";
			QueryRunner query=new QueryRunner();
			lis=query.query(conn,sql,new BeanListHandler<Goods>(Goods.class));
		} catch (ClassNotFoundException | SQLException e) {
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

	@Override
	public Goods query(int goodsid) {
		Connection conn=null;
		try {
			conn=DbHelper.getConnection();
			String sql="SELECT  * FROM`goods` where id=?";
			QueryRunner query=new QueryRunner();
			return query.query(conn,sql,new BeanHandler<Goods>(Goods.class),goodsid);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
		return null;
	}



}
