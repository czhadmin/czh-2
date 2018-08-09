package com.accp.mapper;

import com.accp.entity.comments;

public interface commentsMapper {
    int deleteByPrimaryKey(Integer commentid);

    int insert(comments record);

    int insertSelective(comments record);

    comments selectByPrimaryKey(Integer commentid);

    int updateByPrimaryKeySelective(comments record);

    int updateByPrimaryKeyWithBLOBs(comments record);

    int updateByPrimaryKey(comments record);
    
    comments selectcommentId(int commentid);
}