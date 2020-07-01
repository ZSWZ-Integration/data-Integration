package com.example.a_system.vo;

public class StatisticStudentVO {
    private String sno;
    private String sname;
    private String sex;
    private String cno;
    private String cname;
    private String grade;

    public StatisticStudentVO(String sno, String sname, String sex, String cno, String cname, String grade) {
        this.sno = sno;
        this.sname = sname;
        this.sex = sex;
        this.cno = cno;
        this.cname = cname;
        this.grade = grade;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
