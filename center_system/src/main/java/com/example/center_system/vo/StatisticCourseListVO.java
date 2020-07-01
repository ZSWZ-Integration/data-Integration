package com.example.center_system.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "全部课程信息")
public class StatisticCourseListVO {

    private List<StatisticCourse> statisticCourseList;

    public StatisticCourseListVO() {
        super();
    }

    @JacksonXmlElementWrapper(localName = "课程列表")
    @JacksonXmlProperty(localName = "课程信息")
    public List<StatisticCourse> getStatisticCourseList() {
        return statisticCourseList;
    }

    public void setStatisticCourseList(List<StatisticCourse> statisticCourseList) {
        this.statisticCourseList = statisticCourseList;
    }


}
