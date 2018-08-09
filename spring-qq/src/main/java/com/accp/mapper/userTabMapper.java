package com.accp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.entity.userTab;

public interface userTabMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(userTab record);

    int insertSelective(userTab record);

    userTab selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(userTab record);

    int updateByPrimaryKeyWithBLOBs(userTab record);

    int updateByPrimaryKey(userTab record);
    
    userTab selectdl(@Param("username")String username,@Param("password")String password);
    
    List<userTab> selecthaoyou(@Param("username")String username);
    
    userTab selectus(int userid);
    List<userTab> selectqb();
}