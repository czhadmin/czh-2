package com.accp.service.impl;

import java.util.List;

import com.accp.dao.GoodsDao;
import com.accp.dao.impl.GoodsDaoImpl;
import com.accp.entity.Goods;
import com.accp.service.GoodsService;

public class GoodsServiceImpl implements GoodsService{
	GoodsDao goodsdao=new GoodsDaoImpl(); 
	@Override
	public List<Goods> query() {
		return this.goodsdao.query();
	}
	@Override
	public Goods query(int goodsid) {
		// TODO Auto-generated method stub
		return this.goodsdao.query(goodsid);
	}

}
