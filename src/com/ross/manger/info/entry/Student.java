package com.ross.manger.info.entry;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer stuId;
    private String stuNo;
    private String stuName;
    private String stuSex;
    private Byte stuAge;
    private String stuPhone;
    private String stuIdCard;
    private String stuEmail;
    private String stuAddr;
    private String stuGrade;
    private String stuClass;
    private String stuImg;
    private String stuPwd;
    private Integer authId;

    public Student() {
    }

    public Student(Integer stuId, String stuNo, String stuName, String stuSex, Byte stuAge, String stuPhone, String stuIdCard, String stuEmail, String stuAddr, String stuGrade, String stuClass, String stuImg, String stuPwd, Integer authId) {
        this.stuId = stuId;
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
        this.stuPhone = stuPhone;
        this.stuIdCard = stuIdCard;
        this.stuEmail = stuEmail;
        this.stuAddr = stuAddr;
        this.stuGrade = stuGrade;
        this.stuClass = stuClass;
        this.stuImg = stuImg;
        this.stuPwd = stuPwd;
        this.authId = authId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public Byte getStuAge() {
        return stuAge;
    }

    public void setStuAge(Byte stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuIdCard() {
        return stuIdCard;
    }

    public void setStuIdCard(String stuIdCard) {
        this.stuIdCard = stuIdCard;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getStuAddr() {
        return stuAddr;
    }

    public void setStuAddr(String stuAddr) {
        this.stuAddr = stuAddr;
    }

    public String getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(String stuGrade) {
        this.stuGrade = stuGrade;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuImg() {
        return stuImg;
    }

    public void setStuImg(String stuImg) {
        this.stuImg = stuImg;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuAge=" + stuAge +
                ", stuPhone='" + stuPhone + '\'' +
                ", stuIdCard='" + stuIdCard + '\'' +
                ", stuEmail='" + stuEmail + '\'' +
                ", stuAddr='" + stuAddr + '\'' +
                ", stuGrade='" + stuGrade + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", stuImg='" + stuImg + '\'' +
                ", stuPwd='" + stuPwd + '\'' +
                ", authId=" + authId +
                '}';
    }
}
