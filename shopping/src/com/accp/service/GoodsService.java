package com.accp.service;

import java.util.List;

import com.accp.entity.Goods;

public interface GoodsService {
	List<Goods> query();
	
	Goods query(int goodsid);
}
