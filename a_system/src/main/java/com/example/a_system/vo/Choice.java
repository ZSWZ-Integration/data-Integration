package com.example.a_system.vo;

public class Choice {
    private String cno;
    private String sno;
    private String grade;

    public Choice(String cno, String sno, String grade) {
        this.cno = cno;
        this.sno = sno;
        this.grade = grade;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
