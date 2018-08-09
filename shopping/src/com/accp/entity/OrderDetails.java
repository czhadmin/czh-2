package com.accp.entity;

public class OrderDetails {

private int	orid;
private int orderId;
private int	  goodsId;
private double  price; 
private int qty;
public int getOrid() {
	return orid;
}
public void setOrid(int orid) {
	this.orid = orid;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public int getGoodsId() {
	return goodsId;
}
public void setGoodsId(int goodsId) {
	this.goodsId = goodsId;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public OrderDetails() {
	super();
}
public OrderDetails(int orderId, int goodsId, double price, int qty) {
	super();
	this.orderId = orderId;
	this.goodsId = goodsId;
	this.price = price;
	this.qty = qty;
}
public OrderDetails(int orid, int orderId, int goodsId, double price, int qty) {
	super();
	this.orid = orid;
	this.orderId = orderId;
	this.goodsId = goodsId;
	this.price = price;
	this.qty = qty;
}

	
}
