package com.example.center_system.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class StatisticStudent {

    private String sno;
    private String sname;
    private String sex;
    private String cno;
    private String cname;
    private String grade;

    public StatisticStudent(String sno, String sname, String sex, String cno, String cname, String grade) {

        this.sno = sno;
        this.sname = sname;
        this.sex = sex;
        this.cno = cno;
        this.cname = cname;
        this.grade = grade;

    }

    @JacksonXmlProperty(localName = "学生编号")
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @JacksonXmlProperty(localName = "学生姓名")
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @JacksonXmlProperty(localName = "学生性别")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @JacksonXmlProperty(localName = "课程编号")
    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    @JacksonXmlProperty(localName = "课程名")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @JacksonXmlProperty(localName = "课程成绩")
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
