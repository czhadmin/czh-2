package com.accp.entity;

public class Orders {
	private int	id ;
	private int  customerId ;//用户id
	private double	  total ;//价格
	private String  createdDate ;//购买时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public Orders(int customerId, double total, String createdDate) {
		super();
		this.customerId = customerId;
		this.total = total;
		this.createdDate = createdDate;
	}
	public Orders() {
		super();
	}
	public Orders(int id, int customerId, double total, String createdDate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.total = total;
		this.createdDate = createdDate;
	}
}
