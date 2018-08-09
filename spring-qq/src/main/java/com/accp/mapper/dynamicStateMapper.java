package com.accp.mapper;

import com.accp.entity.dynamicState;
import com.accp.entity.dynamicStateWithBLOBs;

public interface dynamicStateMapper {
    int deleteByPrimaryKey(Integer stateid);

    int insert(dynamicState record);

    int insertSelective(dynamicState record);

    dynamicStateWithBLOBs selectByPrimaryKey(Integer stateid);

    int updateByPrimaryKeySelective(dynamicStateWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(dynamicStateWithBLOBs record);

    int updateByPrimaryKey(dynamicState record);
    
    dynamicState selectusid(int userid);
}