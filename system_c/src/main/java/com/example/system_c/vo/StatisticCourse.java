package com.example.system_c.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class StatisticCourse {
    private String cno;
    private String cname;
    private String teacher;
    private String credit;
    private int count;  //选该门课的人数

    public StatisticCourse(String cno, String cname, String teacher, String credit, int count) {
        this.cno = cno;
        this.cname = cname;
        this.teacher = teacher;
        this.credit = credit;
        this.count = count;
    }

    public StatisticCourse() {
        super();
    }

    @JacksonXmlProperty(localName = "课程编号C")
    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    @JacksonXmlProperty(localName = "课程名C")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @JacksonXmlProperty(localName = "授课教师C")
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @JacksonXmlProperty(localName = "课程学分C")
    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @JacksonXmlProperty(localName = "选课人数C")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
