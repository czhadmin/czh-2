package com.accp.mapper;

import com.accp.entity.spaceBackImg;

public interface spaceBackImgMapper {
    int deleteByPrimaryKey(Integer backimgid);

    int insert(spaceBackImg record);

    int insertSelective(spaceBackImg record);

    spaceBackImg selectByPrimaryKey(Integer backimgid);

    int updateByPrimaryKeySelective(spaceBackImg record);

    int updateByPrimaryKeyWithBLOBs(spaceBackImg record);

    int updateByPrimaryKey(spaceBackImg record);
}