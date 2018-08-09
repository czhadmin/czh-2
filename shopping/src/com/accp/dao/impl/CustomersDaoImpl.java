package com.accp.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.accp.dao.CustomersDao;
import com.accp.entity.Customers;
import com.accp.util.DbHelper;

public class CustomersDaoImpl implements CustomersDao {

	@Override
	public Customers query(String customerName, String customerPassword) {
		Connection conn=null;
		try {
			conn=DbHelper.getConnection();
			String sql="select id,customerName,customerPassword from customers where customerName=? and customerPassword=?";
			QueryRunner query=new QueryRunner();
			return query.query(conn,sql,new BeanHandler<Customers>(Customers.class),customerName,customerPassword);
			
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

	@Override
	public Customers query(String customerName) {
		Connection conn=null;
		try {
			conn=DbHelper.getConnection();
			String sql="select id,customerName,customerPassword from customers where customerName=?";
			QueryRunner query=new QueryRunner();
			return query.query(conn,sql,new BeanHandler<Customers>(Customers.class),customerName);
			
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

	@Override
	public int insert(Customers cus) {
		Connection conn=null;
		try {
			conn=DbHelper.getConnection();
			String sql="insert into customers(customerName,customerPassword) VALUES(?,?)";
			QueryRunner query=new QueryRunner();
			return query.update(conn,sql,cus.getCustomerName(),cus.getCustomerPassword());
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
		return 0;
	}

}
