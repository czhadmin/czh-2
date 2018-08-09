package com.accp.service.impl;

import java.util.List;

import com.accp.dao.OrdersDao;
import com.accp.dao.impl.OrdersDaoImpl;
import com.accp.entity.Orders;
import com.accp.service.OrdersService;

public class OrdersServiceImpl implements OrdersService {

		OrdersDao ordersdao=new OrdersDaoImpl();
	@Override
	public List<Orders> query() {
		// TODO Auto-generated method stub
		return this.ordersdao.query();
	}

	@Override
	public int zeng(Orders orders) {
		// TODO Auto-generated method stub
		return this.ordersdao.zeng(orders);
	}

	@Override
	public Orders query(int customerId) {
		// TODO Auto-generated method stub
		return this.ordersdao.query(customerId);
	}

	@Override
	public Orders queryid(int ordersid) {
		// TODO Auto-generated method stub
		return this.ordersdao.queryid(ordersid);
	}

	@Override
	public int xg(int orderId,double Price) {
		// TODO Auto-generated method stub
		return this.ordersdao.xg(orderId, Price);
	}

	@Override
	public int gwczeng(Orders oo) {
		// TODO Auto-generated method stub
		return this.ordersdao.gwczeng(oo);
	}



}
