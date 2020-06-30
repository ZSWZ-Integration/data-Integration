package com.example.a_system.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class Student {
    private String acc;
    private String password;
    private String createDate;
    private String sno;
    private String sname;
    private String sex;

    public Student(String acc, String password, String createDate, String sno, String sname, String sex) {
        this.acc = acc;
        this.password = password;
        this.createDate = createDate;
        this.sno = sno;
        this.sname = sname;
        this.sex = sex;
    }

    @JacksonXmlProperty(localName = "学生账号A")
    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    @JacksonXmlProperty(localName = "学生密码A")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JacksonXmlProperty(localName = "创建日期A")
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @JacksonXmlProperty(localName = "学生编号A")
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @JacksonXmlProperty(localName = "学生姓名A")
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @JacksonXmlProperty(localName = "学生性别A")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
