package com.accp.entity;

import java.util.Date;
import java.util.List;

public class comments {
    private Integer commentid;

    private Integer stateid;

    private Integer userid;

    private Date commenttime;

    private String commenttext;

    private userTab plus;//评论用户
    
    private List<reply> replies;//回复
    
   
    
    public userTab getPlus() {
		return plus;
	}

	public void setPlus(userTab plus) {
		this.plus = plus;
	}

	public List<reply> getReplies() {
		return replies;
	}

	public void setReplies(List<reply> replies) {
		this.replies = replies;
	}



	public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
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

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext == null ? null : commenttext.trim();
    }
}