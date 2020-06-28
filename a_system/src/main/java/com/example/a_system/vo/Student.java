package com.example.a_system.vo;

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

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
