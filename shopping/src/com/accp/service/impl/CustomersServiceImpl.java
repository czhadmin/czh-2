package com.accp.service.impl;

import com.accp.dao.CustomersDao;
import com.accp.dao.impl.CustomersDaoImpl;
import com.accp.entity.Customers;
import com.accp.service.CustomersService;

public class CustomersServiceImpl implements CustomersService{
		CustomersDao  cusdao=new CustomersDaoImpl();
	@Override
	public Customers query(String customerName, String customerPassword) {
		// TODO Auto-generated method stub
		return this.cusdao.query(customerName,customerPassword);
	}

	@Override
	public Customers query(String customerName) {
		// TODO Auto-generated method stub
		return this.cusdao.query(customerName);
	}

	@Override
	public int insert(Customers cus) {
		// TODO Auto-generated method stub
		return this.cusdao.insert(cus);
	}

}
