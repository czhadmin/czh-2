package com.accp.dao;

import java.util.List;

import com.accp.entity.Orders;

public interface OrdersDao {
	List<Orders> query();
	
	int zeng(Orders orders);
	
	Orders query(int customerId);
	
	Orders queryid(int ordersid);
	
	int xg(int orderId,double Price); 
	
	int gwczeng(Orders oo);
}
