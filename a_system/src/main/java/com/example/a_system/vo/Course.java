package com.example.a_system.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Course {

    private String cno;
    private String cname;
    private String teacher;
    private String ctime;
    private String credit;
    private String share;
    private String ctype;


    public Course() {
        super();
    }


    @JacksonXmlProperty(localName = "课程编号A")
    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    @JacksonXmlProperty(localName = "课程名A")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @JacksonXmlProperty(localName = "授课教师A")
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @JacksonXmlProperty(localName = "课程时间A")
    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    @JacksonXmlProperty(localName = "课程学分A")
    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @JacksonXmlProperty(localName = "是否共享A")
    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    @JacksonXmlProperty(localName = "所属学院A")
    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }


    public Course(String cno, String cname, String teacher, String ctime, String credit, String share, String ctype) {
        this.cno = cno;
        this.cname = cname;
        this.teacher = teacher;
        this.ctime = ctime;
        this.credit = credit;
        this.share = share;
        this.ctype = ctype;
    }



}
