package com.accp.entity;

import java.util.Date;

public class spaceBackImg {
    private Integer backimgid;

    private Integer spaceid;

    private Date createtime;

    private String url;

    public Integer getBackimgid() {
        return backimgid;
    }

    public void setBackimgid(Integer backimgid) {
        this.backimgid = backimgid;
    }

    public Integer getSpaceid() {
        return spaceid;
    }

    public void setSpaceid(Integer spaceid) {
        this.spaceid = spaceid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}