package com.accp.entity;

public class HeTi {
		private int goodsid;//商品id
		private String goodstype;//商品类型
		private String descrption;//商品内容
		private double price;//商品价格
		private String color;//商品颜色
		private String image;//商品图片
		
		private int	orid;//从购物车id
		private int orderId;//主购物车id
		private int	  orgoodsId;//从购物车的商品id
		private double  orprice; //从购物车价格
		private int qty;//从购物车数量
		public int getGoodsid() {
			return goodsid;
		}
		public void setGoodsid(int goodsid) {
			this.goodsid = goodsid;
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
		public int getOrgoodsId() {
			return orgoodsId;
		}
		public void setOrgoodsId(int orgoodsId) {
			this.orgoodsId = orgoodsId;
		}
		public double getOrprice() {
			return orprice;
		}
		public void setOrprice(double orprice) {
			this.orprice = orprice;
		}
		public int getQty() {
			return qty;
		}
		public void setQty(int qty) {
			this.qty = qty;
		}
		public HeTi() {
			super();
		}
		public HeTi(int goodsid, String goodstype, String descrption, double price, String color, String image,
				int orid, int orderId, int orgoodsId, double orprice, int qty) {
			super();
			this.goodsid = goodsid;
			this.goodstype = goodstype;
			this.descrption = descrption;
			this.price = price;
			this.color = color;
			this.image = image;
			this.orid = orid;
			this.orderId = orderId;
			this.orgoodsId = orgoodsId;
			this.orprice = orprice;
			this.qty = qty;
		}
		
}
