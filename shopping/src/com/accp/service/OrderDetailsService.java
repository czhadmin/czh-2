package com.accp.service;

import java.util.List;

import com.accp.dao.OrderDetailsDao;
import com.accp.entity.OrderDetails;
import com.accp.entity.Orders;

public interface OrderDetailsService {
	 List<OrderDetailsDao> query();
	 
	 int zeng(OrderDetails orderdetails);
	 
	 OrderDetails query(int zhuid,int spid);
	 
	 int gai(OrderDetails orderdetails);
	 
	 int gaixj(double xj,int orid,int sl);
	 
	 OrderDetails chasum(int orderId);
	 
	 int delete(int orid);
	 
	 int deletezhu(int orderId); //已主购物车id删除(删除全部)
}
