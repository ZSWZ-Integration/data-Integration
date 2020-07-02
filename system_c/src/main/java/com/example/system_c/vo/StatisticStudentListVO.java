package com.example.system_c.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "C系统学生选课信息")
public class StatisticStudentListVO {

    private List<StatisticStudent> studentList;

    public StatisticStudentListVO() {
        super();
    }

    public StatisticStudentListVO(List<StatisticStudent> studentList) {
        this.studentList = studentList;
    }

    @JacksonXmlElementWrapper(localName = "学生选课列表C")
    @JacksonXmlProperty(localName = "选课信息C")
    public List<StatisticStudent> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StatisticStudent> studentList) {
        this.studentList = studentList;
    }
}
