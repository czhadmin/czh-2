package com.accp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.entity.friend;

public interface friendMapper {
    int deleteByPrimaryKey(Integer friendid);

    int insert(friend record);

    int insertSelective(friend record);

    friend selectByPrimaryKey(Integer friendid);

    int updateByPrimaryKeySelective(friend record);

    int updateByPrimaryKey(friend record);
    
    List<friend>selectgroupingId(int groupingid);
    
    List<friend> selectusid(int userid);
    
    friend selectsfhy(@Param("userid")int userid,@Param("frienduserid")int frienduserid);
}