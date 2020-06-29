package com.example.a_system.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "A系统学生选课信息")
public class ChoiceVO {
    private String cno;
    private StudentVO student;
    private String grade;

    public ChoiceVO(String cno, StudentVO student, String grade) {
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
    public StudentVO getStudent() {
        return student;
    }

    public void setStudent(StudentVO student) {
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
