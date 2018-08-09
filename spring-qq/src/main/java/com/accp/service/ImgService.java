package com.accp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.entity.img;
import com.accp.mapper.imgMapper;

@Service
public class ImgService {

	@Autowired
	private imgMapper imgMapper;
	
	public  int insertSelective(img record) {
		return this.imgMapper.insertSelective(record);
	}
}
