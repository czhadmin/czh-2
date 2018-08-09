package com.accp.entity;

import java.util.Date;
import java.util.List;

public class dynamicState {
    private Integer stateid;

    private Integer spaceid;

    private String statetime;

    private String statetext;

    private String readed;
    
    private int userid;
    
    private userTab dtuserTab;//动态用户
    
    private List<img> imglis;
    
    
    private List<praiseRecord> praiseRecords;//点赞
    
    private List<comments> commentlis;//评论
    public List<img> getImglis() {
		return imglis;
	}

	public void setImglis(List<img> imglis) {
		this.imglis = imglis;
	}

	public userTab getDtuserTab() {
		return dtuserTab;
	}

	public void setDtuserTab(userTab dtuserTab) {
		this.dtuserTab = dtuserTab;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	
    
	public List<comments> getCommentlis() {
		return commentlis;
	}

	public void setCommentlis(List<comments> commentlis) {
		this.commentlis = commentlis;
	}

	public List<praiseRecord> getPraiseRecords() {
		return praiseRecords;
	}

	public void setPraiseRecords(List<praiseRecord> praiseRecords) {
		this.praiseRecords = praiseRecords;
	}

	public String getStatetext() {
		return statetext;
	}

	public void setStatetext(String statetext) {
		this.statetext = statetext;
	}

	public String getReaded() {
		return readed;
	}

	public void setReaded(String readed) {
		this.readed = readed;
	}

	public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public Integer getSpaceid() {
        return spaceid;
    }

    public void setSpaceid(Integer spaceid) {
        this.spaceid = spaceid;
    }

	public String getStatetime() {
		return statetime;
	}

	public void setStatetime(String statetime) {
		this.statetime = statetime;
	}





 
}