package com.accp.entity;

public class dynamicStateWithBLOBs extends dynamicState {
    private String statetext;

    private String readed;

    public String getStatetext() {
        return statetext;
    }

    public void setStatetext(String statetext) {
        this.statetext = statetext == null ? null : statetext.trim();
    }

    public String getReaded() {
        return readed;
    }

    public void setReaded(String readed) {
        this.readed = readed == null ? null : readed.trim();
    }
}