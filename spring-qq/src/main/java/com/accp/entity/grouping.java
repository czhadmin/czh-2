package com.accp.entity;

import java.util.List;

public class grouping {
    private Integer groupingid;

    private String groupingname;

    private Integer userid;

    private List<friend> friendlis;
    
    public List<friend> getFriendlis() {
		return friendlis;
	}

	public void setFriendlis(List<friend> friendlis) {
		this.friendlis = friendlis;
	}

	public Integer getGroupingid() {
        return groupingid;
    }

    public void setGroupingid(Integer groupingid) {
        this.groupingid = groupingid;
    }

    public String getGroupingname() {
        return groupingname;
    }

    public void setGroupingname(String groupingname) {
        this.groupingname = groupingname == null ? null : groupingname.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}