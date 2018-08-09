package com.accp.mapper;

import org.apache.ibatis.annotations.Param;

import com.accp.entity.praiseRecord;

public interface praiseRecordMapper {
    int deleteByPrimaryKey(@Param("userid")Integer userid,@Param("stateId")int stateId);

    int insert(praiseRecord record);

    int insertSelective(praiseRecord record);

    praiseRecord selectByPrimaryKey(Integer praiseid);

    int updateByPrimaryKeySelective(praiseRecord record);

    int updateByPrimaryKey(praiseRecord record);
    
    
    praiseRecord selectpraiseid(int praiseid);
}