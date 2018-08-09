package com.accp.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.accp.dao.OrderDetailsDao;
import com.accp.entity.OrderDetails;
import com.accp.entity.Orders;
import com.accp.util.DbHelper;

public class OrderDetailsImpl implements OrderDetailsDao{

	@Override
	public List<OrderDetails> query() {
		return null;
	}

	@Override
	public int zeng(OrderDetails orderdetails) {
		Connection conn=null;
		try {
			conn=DbHelper.getConnection();
			String sql="INSERT INTO `orderdetails` (`orderId`,`orgoodsId`, `orprice`, `qty`) VALUES(?,?,?,?);";
			QueryRunner query=new QueryRunner();
			return query.update(conn,sql,orderdetails.getOrderId(),orderdetails.getGoodsId(),orderdetails.getPrice(),orderdetails.getQty());
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
	public OrderDetails query(int zhuid, int spid) {
		Connection conn=null;
		try {
			conn=DbHelper.getConnection();
			String sql="SELECT  * FROM`orderdetails` WHERE orderId=? AND orgoodsId=?";
			QueryRunner query=new QueryRunner();
			return query.query(conn,sql,new BeanHandler<OrderDetails>(OrderDetails.class),zhuid,spid);
			
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
	public int gai(OrderDetails orderdetails) {
		Connection conn=null;
		try {
			conn=DbHelper.getConnection();
			String sql="update orderdetails set qty=qty+1,orprice=orprice+? where orgoodsId=?";
			QueryRunner query=new QueryRunner();
			return query.update(conn,sql,orderdetails.getPrice(),orderdetails.getGoodsId());
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
	public int gaixj(double xj,int orid,int sl) {
		Connection conn=null;
		try {
			conn=DbHelper.getConnection();
			String sql="update orderdetails set orprice=?,qty=?  where orid=?";
			QueryRunner query=new QueryRunner();
			return query.update(conn,sql,xj,sl,orid);
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
	public OrderDetails chasum(int orderId) {
		Connection conn=null;
		try {
			conn=DbHelper.getConnection();
			String sql="select  `orid`, `orderId`, `orgoodsId`, sum(`orprice`)as price,`qty` from`orderdetails` where orderId=?";
			QueryRunner query=new QueryRunner();
			return query.query(conn,sql,new BeanHandler<OrderDetails>(OrderDetails.class),orderId);
			
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
	public int delete(int orid) {
		Connection conn=null;
		try {
			conn=DbHelper.getConnection();
			String sql="delete from  `orderdetails` where `orid` = ? ;";
			QueryRunner query=new QueryRunner();
			return query.update(conn,sql,orid);
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
	public int deletezhu(int orderId) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DbHelper.getConnection();
			String sql="delete from  `orderdetails` where `orderId` = ? ;";
			QueryRunner query=new QueryRunner();
			return query.update(conn,sql,orderId);
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
