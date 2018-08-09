package com.accp.mapper;

import java.util.List;

import com.accp.entity.grouping;

public interface groupingMapper {
    int deleteByPrimaryKey(Integer groupingid);

    int insert(grouping record);

    int insertSelective(grouping record);

    grouping selectByPrimaryKey(Integer groupingid);

    int updateByPrimaryKeySelective(grouping record);

    int updateByPrimaryKey(grouping record);
    
    //按用户id查分组
   List<grouping> selectuserId(int userId);
}