package com.accp.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.accp.dao.OrdersDao;
import com.accp.entity.Customers;
import com.accp.entity.Orders;
import com.accp.util.DbHelper;

public class OrdersDaoImpl implements OrdersDao {

	@Override
	public List<Orders> query() {
		Connection conn=null;
		List<Orders> lis=null;
		try {
			conn=DbHelper.getConnection();
			String sql="SELECT 	` id `, ` customerId `, ` total `,` createdDate `FROM ` orders ` ";
			QueryRunner query=new QueryRunner();
			lis=query.query(conn,sql,new BeanListHandler<Orders>(Orders.class));
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
	public int zeng(Orders orders) {
		Connection conn=null;
		try {
			conn=DbHelper.getConnection();
			String sql="INSERT INTO `orders` ( `customerId`,  `total`,  `createdDate`) VALUES (?,?,?) ;";
			QueryRunner query=new QueryRunner();
			return query.update(conn,sql,orders.getCustomerId(),orders.getTotal(),orders.getCreatedDate());
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

	@Override
	public Orders query(int customerId) {
		Connection conn=null;
		try {
			conn=DbHelper.getConnection();
			String sql="SELECT 	`id`, `customerId`, `total`,`createdDate` FROM `orders` WHERE customerId=?";
			QueryRunner query=new QueryRunner();
			return query.query(conn,sql,new BeanHandler<Orders>(Orders.class),customerId);
			
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
	public Orders queryid(int ordersid) {
		Connection conn=null;
		try {
			conn=DbHelper.getConnection();
			String sql="SELECT 	`id`, `customerId`, `total`,`createdDate` FROM `orders` WHERE id=?";
			QueryRunner query=new QueryRunner();
			return query.query(conn,sql,new BeanHandler<Orders>(Orders.class),ordersid);
			
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
	public int xg(int orderId,double Price) {
		Connection conn=null;
		try {
			conn=DbHelper.getConnection();
			String sql="UPDATE `orders` SET `total` = ? WHERE `id` = ? ;";
			QueryRunner query=new QueryRunner();
			return query.update(conn,sql,Price,orderId);
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

	@Override
	public int gwczeng(Orders oo) {
		Connection conn=null;
		try {
			conn=DbHelper.getConnection();
			String sql="insert into `orders` (`customerId`,`createdDate`) values( ?,curdate())";
			QueryRunner query=new QueryRunner();
			return query.update(conn,sql,oo.getCustomerId());
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
