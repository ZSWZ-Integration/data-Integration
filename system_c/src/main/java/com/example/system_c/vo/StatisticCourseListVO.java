package com.example.system_c.vo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "C系统全部课程信息")
public class StatisticCourseListVO {

    private List<StatisticCourse> statisticCourseList;

    public StatisticCourseListVO() {
        super();
    }

    public StatisticCourseListVO(List<StatisticCourse> statisticCourseList) {
        this.statisticCourseList = statisticCourseList;
    }

    @JacksonXmlElementWrapper(localName = "课程列表C")
    @JacksonXmlProperty(localName = "课程信息C")
    public List<StatisticCourse> getStatisticCourseList() {
        return statisticCourseList;
    }

    public void setStatisticCourseList(List<StatisticCourse> statisticCourseList) {
        this.statisticCourseList = statisticCourseList;
    }


}
