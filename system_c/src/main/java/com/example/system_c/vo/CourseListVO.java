package com.example.system_c.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "C院系共享课程信息")
public class CourseListVO {

    private List<Course> courseList;

    public CourseListVO() {
        super();
    }

    public CourseListVO(List<Course> courseList) {
        this.courseList = courseList;
    }

    @JacksonXmlElementWrapper(localName = "课程列表C")
    @JacksonXmlProperty(localName = "课程信息C")
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

}
