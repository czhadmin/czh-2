package com.accp.entity;

import java.util.List;

public class qspace {
    private Integer spaceid;

    private String backcolor;

    private Integer backimgid;

    private Integer userid;

    private String signature;
    
    private userTab kjuserTab;//¿Õ¼äuser

    private List<spaceBackImg> kjspaceBackImg;//¿Õ¼ä±³¾°Í¼
    
    private List<dynamicState> dynamicStates;//¶¯Ì¬
    
    
    
    public List<dynamicState> getDynamicStates() {
		return dynamicStates;
	}

	public void setDynamicStates(List<dynamicState> dynamicStates) {
		this.dynamicStates = dynamicStates;
	}

	public userTab getKjuserTab() {
		return kjuserTab;
	}

	public void setKjuserTab(userTab kjuserTab) {
		this.kjuserTab = kjuserTab;
	}

	public List<spaceBackImg> getKjspaceBackImg() {
		return kjspaceBackImg;
	}

	public void setKjspaceBackImg(List<spaceBackImg> kjspaceBackImg) {
		this.kjspaceBackImg = kjspaceBackImg;
	}

	public Integer getSpaceid() {
        return spaceid;
    }

    public void setSpaceid(Integer spaceid) {
        this.spaceid = spaceid;
    }

    public String getBackcolor() {
        return backcolor;
    }

    public void setBackcolor(String backcolor) {
        this.backcolor = backcolor == null ? null : backcolor.trim();
    }

    public Integer getBackimgid() {
        return backimgid;
    }

    public void setBackimgid(Integer backimgid) {
        this.backimgid = backimgid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }
}