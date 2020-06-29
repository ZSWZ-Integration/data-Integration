package com.example.a_system.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "A系统学生选课信息")
public class Choice {
    private String cno;
    private Student student;
    private String grade;

    public Choice(String cno, Student student, String grade) {

        this.cno = cno;
        this.student = student;
        this.grade = grade;

    }

    @JacksonXmlProperty(localName = "课程编号A")
    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    @JacksonXmlProperty(localName = "学生信息A")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @JacksonXmlProperty(localName = "学生成绩A")
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
