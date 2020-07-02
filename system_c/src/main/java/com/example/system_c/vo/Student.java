package com.example.system_c.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

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

    public Student() {
        super();
    }

    @JacksonXmlProperty(localName = "学生账号C")
    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    @JacksonXmlProperty(localName = "学生密码C")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JacksonXmlProperty(localName = "创建日期C")
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @JacksonXmlProperty(localName = "学生编号C")
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @JacksonXmlProperty(localName = "学生姓名C")
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @JacksonXmlProperty(localName = "学生性别C")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
