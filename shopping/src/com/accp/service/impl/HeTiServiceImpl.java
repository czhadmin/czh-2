package com.accp.service.impl;

import java.util.List;

import com.accp.dao.HeTiDao;
import com.accp.dao.impl.HeTiDaoImpl;
import com.accp.entity.HeTi;
import com.accp.service.HeTiService;

public class HeTiServiceImpl implements HeTiService {
		HeTiDao hetidao =new HeTiDaoImpl();
	@Override
	public List<HeTi> query(int orderId) {
		
		return this.hetidao.query(orderId);
	}

}
