package com.accp.mapper;

import com.accp.entity.img;

public interface imgMapper {
    int deleteByPrimaryKey(Integer imgid);

    int insert(img record);

    int insertSelective(img record);

    img selectByPrimaryKey(Integer imgid);

    int updateByPrimaryKeySelective(img record);

    int updateByPrimaryKeyWithBLOBs(img record);

    int updateByPrimaryKey(img record);
}