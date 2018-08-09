package com.accp.qqemail.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DBHelper {
	
	private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/qqemail";
	private static final String USER="root";
	private static final String PASSWORD="123";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_CLASS);
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
	
	/**
	 * 查询 
	 * @param clazz 什么实体类型
	 * @param sql sql语句
	 * @param params  参数
	 * @return 实体对象集合
	 */
	public static <T> List<T> Query(Class<T> clazz,String sql,Object...params){
		Connection connection = null;
		try {
			connection = getConnection();
			QueryRunner qr = new QueryRunner();
			return qr.query(connection, sql, new BeanListHandler<T>(clazz), params);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
		
	}
	
	/**
	 * 执行增删改
	 * @param sql
	 * @param params
	 * @return 受影响的行数
	 */
	public static int update(String sql,Object...params) {
		Connection connection = null;
		try {
			connection = getConnection();
			QueryRunner qr = new QueryRunner();
			return qr.update(connection, sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	public static Object Querydanhang(ResultSetHandler<?> res,String sql,Object...params){
		Connection connection = null;
		try {
			connection = getConnection();
			QueryRunner qr = new QueryRunner();
			return qr.query(connection, sql,res,params);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
	}
}
