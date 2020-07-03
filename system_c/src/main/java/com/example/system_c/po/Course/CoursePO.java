package com.example.system_c.po.Course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class CoursePO {

    private String Cno;
    private String Cname;
    private String teacher;
    private String credit;
    private String share;

    public CoursePO(String cno, String cname, String teacher, String credit, String share) {
        Cno = cno;
        Cname = cname;
        this.teacher = teacher;
        this.credit = credit;
        this.share = share;
    }

    public String getCno() {
        return Cno;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }
}
