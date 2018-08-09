package com.accp.entity;

import java.util.Date;

public class frienDapplfor {
    private Integer applforid;

    private String remark;

    private Integer userid;

    private Integer pasvuserid;

    private Integer isok;

    private Date createtime;

    private Integer groupingid;

    private String beizhu;
    
    private userTab userentity;
    
    private userTab userentitytwo;
   

	public userTab getUserentitytwo() {
		return userentitytwo;
	}

	public void setUserentitytwo(userTab userentitytwo) {
		this.userentitytwo = userentitytwo;
	}

	public userTab getUserentity() {
		return userentity;
	}

	public void setUserentity(userTab userentity) {
		this.userentity = userentity;
	}

	public Integer getApplforid() {
        return applforid;
    }

    public void setApplforid(Integer applforid) {
        this.applforid = applforid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPasvuserid() {
        return pasvuserid;
    }

    public void setPasvuserid(Integer pasvuserid) {
        this.pasvuserid = pasvuserid;
    }

    public Integer getIsok() {
        return isok;
    }

    public void setIsok(Integer isok) {
        this.isok = isok;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getGroupingid() {
        return groupingid;
    }

    public void setGroupingid(Integer groupingid) {
        this.groupingid = groupingid;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }
}