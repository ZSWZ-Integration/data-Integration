package com.example.center_system.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "学生选课信息")
public class StatisticStudentListVO {

    private List<StatisticStudent> studentList;

    public StatisticStudentListVO() {
        super();
    }

    @JacksonXmlElementWrapper(localName = "学生选课列表")
    @JacksonXmlProperty(localName = "学生选课信息")
    public List<StatisticStudent> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StatisticStudent> studentList) {
        this.studentList = studentList;
    }
}
