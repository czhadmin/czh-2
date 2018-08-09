package com.accp.mapper;

import com.accp.entity.reply;

public interface replyMapper {
    int deleteByPrimaryKey(Integer replyid);

    int insert(reply record);

    int insertSelective(reply record);

    reply selectByPrimaryKey(Integer replyid);

    int updateByPrimaryKeySelective(reply record);

    int updateByPrimaryKeyWithBLOBs(reply record);

    int updateByPrimaryKey(reply record);
    
    reply selectreply(int replyid);
}