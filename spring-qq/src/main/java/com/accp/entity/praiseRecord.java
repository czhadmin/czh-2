package com.accp.entity;

import java.util.Date;
import java.util.List;

public class praiseRecord {
    private Integer praiseid;

    private Integer stateid;

    private Integer userid;

    private Date createtime;

    private userTab dzuslist;
    

	public userTab getDzuslist() {
		return dzuslist;
	}

	public void setDzuslist(userTab dzuslist) {
		this.dzuslist = dzuslist;
	}

	public Integer getPraiseid() {
        return praiseid;
    }

    public void setPraiseid(Integer praiseid) {
        this.praiseid = praiseid;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}