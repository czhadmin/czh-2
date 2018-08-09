package com.accp.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.entity.friend;
import com.accp.mapper.friendMapper;

@Service
public class FriendService {

		@Autowired
		private friendMapper friendMapper;
		
		public int insert(friend record) {
			return this.friendMapper.insert(record);
		}
		public List<friend>selectgroupingId(int groupingid){
			return this.friendMapper.selectgroupingId(groupingid);
		}
		
		public List<friend> selectusid(int userid){
			return this.friendMapper.selectusid(userid);
		}
		
		public  friend selectsfhy(@Param("userid")int userid,@Param("frienduserid")int frienduserid) {
			return this.friendMapper.selectsfhy(userid, frienduserid);
		}
}
