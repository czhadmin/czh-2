package com.accp.dao;

import java.util.List;

import com.accp.entity.Goods;

public interface GoodsDao {
	List<Goods> query();
	
	Goods query(int goodsid);
}
