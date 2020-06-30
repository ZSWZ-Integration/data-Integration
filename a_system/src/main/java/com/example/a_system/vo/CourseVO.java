package com.example.a_system.vo;

public class CourseVO {
    private String cno;
    private String cname;
    private String teacher;
    private String ctime;
    private String credit;
    private String share;
    private String ctype;

    public CourseVO(String cno, String cname, String teacher, String ctime, String credit, String share, String ctype) {
        this.cno = cno;
        this.cname = cname;
        this.teacher = teacher;
        this.ctime = ctime;
        this.credit = credit;
        this.share = share;
        this.ctype = ctype;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
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

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
}
