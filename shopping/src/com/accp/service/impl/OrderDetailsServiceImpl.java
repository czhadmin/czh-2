package com.accp.service.impl;

import java.util.List;

import com.accp.dao.OrderDetailsDao;
import com.accp.dao.impl.OrderDetailsImpl;
import com.accp.entity.OrderDetails;
import com.accp.entity.Orders;
import com.accp.service.OrderDetailsService;

public class OrderDetailsServiceImpl implements OrderDetailsService{

	 OrderDetailsDao orderdetailsdao=new OrderDetailsImpl(); 
	@Override
	public List<OrderDetailsDao> query() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int zeng(OrderDetails orderdetails) {
		// TODO Auto-generated method stub
		return this.orderdetailsdao.zeng(orderdetails);
	}

	@Override
	public OrderDetails query(int zhuid, int spid) {
		// TODO Auto-generated method stub
		return this.orderdetailsdao.query(zhuid, spid);
	}

	@Override
	public int gai(OrderDetails orderdetails) {
		// TODO Auto-generated method stub
		return this.orderdetailsdao.gai(orderdetails);
	}

	@Override
	public int gaixj(double xj, int orid,int sl) {
		// TODO Auto-generated method stub
		return this.orderdetailsdao.gaixj(xj, orid,sl);
	}
	
	@Override
	public OrderDetails chasum(int orderId) {
		// TODO Auto-generated method stub
		return this.orderdetailsdao.chasum(orderId);
	}

	@Override
	public int delete(int orid) {
		// TODO Auto-generated method stub
		return this.orderdetailsdao.delete(orid);
	}

	@Override
	public int deletezhu(int orderId) {
		// TODO Auto-generated method stub
		return this.orderdetailsdao.deletezhu(orderId);
	}

}
