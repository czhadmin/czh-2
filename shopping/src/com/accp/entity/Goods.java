package com.accp.entity;

public class Goods {
private int id;
private String goodstype;
private String descrption;
private double price;
private String color;
private String image;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getGoodstype() {
	return goodstype;
}
public void setGoodstype(String goodstype) {
	this.goodstype = goodstype;
}
public String getDescrption() {
	return descrption;
}
public void setDescrption(String descrption) {
	this.descrption = descrption;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Goods() {
	super();
}
public Goods(String goodstype, String descrption, double price, String color, String image) {
	super();
	this.goodstype = goodstype;
	this.descrption = descrption;
	this.price = price;
	this.color = color;
	this.image = image;
}
public Goods(int id, String goodstype, String descrption, double price, String color, String image) {
	super();
	this.id = id;
	this.goodstype = goodstype;
	this.descrption = descrption;
	this.price = price;
	this.color = color;
	this.image = image;
}

}
