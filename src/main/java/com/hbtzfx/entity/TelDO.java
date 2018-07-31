package com.hbtzfx.entity;

import java.util.Date;

public class TelDO {
    private Integer telId;
    private String telnumber;
    private String userName;
    private String desction;
    private String searchType;
    private String createdOnStr;
    private Date createdOn;

    public TelDO() {
    }

    public TelDO(String telnumber, String userName, String desction, String searchType) {
        this.telnumber = telnumber;
        this.userName = userName;
        this.desction = desction;
        this.searchType = searchType;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getCreatedOnStr() {
        return createdOnStr;
    }

    public void setCreatedOnStr(String createdOnStr) {
        this.createdOnStr = createdOnStr;
    }

    public Integer getTelId() {
        return telId;
    }

    public void setTelId(Integer telId) {
        this.telId = telId;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDesction() {
        return desction;
    }

    public void setDesction(String desction) {
        this.desction = desction;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
