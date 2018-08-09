package com.accp.mapper;

import java.util.List;

import com.accp.entity.dynamicState;
import com.accp.entity.qspace;

public interface qspaceMapper {
    int deleteByPrimaryKey(Integer spaceid);

    int insert(qspace record);

    int insertSelective(qspace record);

    qspace selectByPrimaryKey(Integer spaceid);

    int updateByPrimaryKeySelective(qspace record);

    int updateByPrimaryKeyWithBLOBs(qspace record);

    int updateByPrimaryKey(qspace record);
    
    List<qspace> selectqspace(int userid);
    
    List<qspace> selecthyqspace(int userid);
    
}