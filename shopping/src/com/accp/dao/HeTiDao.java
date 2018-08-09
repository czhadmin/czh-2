package com.accp.dao;

import java.util.List;

import com.accp.entity.HeTi;

public interface HeTiDao {
	List<HeTi> query(int orderId);
}
