package com.accp.service;

import com.accp.entity.Customers;

public interface CustomersService {
	//�����ƺ������ѯ
	Customers query(String customerName,String customerPassword);
//�����Ʋ�ѯ�Ƿ��ظ�	
	Customers query(String customerName);
//�����û�
	int insert(Customers cus);
}
