package com.ross.manger.info.entry;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable {
    private Integer proID;
    private String proName;
    private String proPerson;
    private String proState;
    private Date proDate;

    @Override
    public String toString() {
        return "Project{" +
                "proID=" + proID +
                ", proName='" + proName + '\'' +
                ", proPerson='" + proPerson + '\'' +
                ", proState='" + proState + '\'' +
                ", proDate=" + proDate +
                '}';
    }

    public Integer getProID() {
        return proID;
    }

    public void setProID(Integer proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProPerson() {
        return proPerson;
    }

    public void setProPerson(String proPerson) {
        this.proPerson = proPerson;
    }

    public String getProState() {
        return proState;
    }

    public void setProState(String proState) {
        this.proState = proState;
    }

    public Date getProDate() {
        return proDate;
    }

    public void setProDate(Date proDate) {
        this.proDate = proDate;
    }

    public Project() {
    }

    public Project(Integer proID, String proName, String proPerson, String proState, Date proDate) {
        this.proID = proID;
        this.proName = proName;
        this.proPerson = proPerson;
        this.proState = proState;
        this.proDate = proDate;
    }
}
