package com.accp.entity;

import java.util.Date;
import java.util.List;

public class userTab {
    private Integer userid;

    private String username;

    private String password;

    private String nickname;

    private Date createtime;

    private String headimg;
    
    private List<grouping> groupinglis;
    
    private dynamicState dtstate;
    
    
    
    public dynamicState getDtstate() {
		return dtstate;
	}

	public void setDtstate(dynamicState dtstate) {
		this.dtstate = dtstate;
	}

	public List<grouping> getGroupinglis() {
		return groupinglis;
	}

	public void setGroupinglis(List<grouping> groupinglis) {
		this.groupinglis = groupinglis;
	}

	public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }
}