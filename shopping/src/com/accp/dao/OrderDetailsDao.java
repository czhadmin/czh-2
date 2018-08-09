package com.accp.dao;

import java.util.List;

import com.accp.entity.OrderDetails;
import com.accp.entity.Orders;

public interface OrderDetailsDao {
 List<OrderDetails> query();
 
 int zeng(OrderDetails orderdetails);
 
 OrderDetails query(int zhuid,int spid);
 
 int gai(OrderDetails orderdetails);
 
 int gaixj(double xj,int orid,int sl);
 
 OrderDetails chasum(int orderId);
 
 int delete(int orid); //�Ѵӹ��ﳵidɾ��(ɾ������)
 
 int deletezhu(int orderId); //�������ﳵidɾ��(ɾ��ȫ��)
}
