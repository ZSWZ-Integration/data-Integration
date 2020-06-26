package com.example.a_system.po.Course;

public class Course {
    private String Cno;
    private String Cname;
    private String teacher;
    private String Ctime;
    private String credit;
    private String share;
    private String Ctype;

    public Course(String cno, String cname, String teacher, String ctime, String credit, String share, String ctype) {
        Cno = cno;
        Cname = cname;
        this.teacher = teacher;
        Ctime = ctime;
        this.credit = credit;
        this.share = share;
        Ctype = ctype;
    }
}
