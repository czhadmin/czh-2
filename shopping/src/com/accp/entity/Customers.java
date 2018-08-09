package com.accp.entity;

public class Customers {
	private int id;
	private String customerName;
	private String customerPassword;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public Customers() {
		super();
	}
	public Customers(String customerName, String customerPassword) {
		super();
		this.customerName = customerName;
		this.customerPassword = customerPassword;
	}
	public Customers(int id, String customerName, String customerPassword) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
	}
	
}
