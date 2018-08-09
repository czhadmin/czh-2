package com.accp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.entity.frienDapplfor;

public interface frienDapplforMapper {
    int deleteByPrimaryKey(Integer applforid);

    int insert(frienDapplfor record);

    int insertSelective(frienDapplfor record);

    frienDapplfor selectByPrimaryKey(Integer applforid);

    int updateByPrimaryKeySelective(frienDapplfor record);

    int updateByPrimaryKey(@Param("isok")int isok,@Param("userid")int userid,@Param("pasvuserid")int pasvuserid);
    
    //≤È—Ø∫√”—…Í«Î±Ì
    List<frienDapplfor> selectall(@Param("user")int user);
}