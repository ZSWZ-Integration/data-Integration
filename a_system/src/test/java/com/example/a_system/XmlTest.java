package com.example.a_system;

import com.example.a_system.service.XmlService;
import com.example.a_system.vo.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class XmlTest {

    @Autowired
    XmlService xmlService;

    @Test
    public void test() throws JsonProcessingException {
        List<StatisticCourse> courses = new ArrayList<>();
        StatisticCourse course1 = new StatisticCourse("cno", "cname", "teacher", "credit", 100);
        StatisticCourse course2 = new StatisticCourse("1", "syf", "t", "4", 50);
        courses.add(course1);
        courses.add(course2);
        StatisticCourseListVO courseListVO = new StatisticCourseListVO(courses);
        System.out.println(object2Xml(courseListVO));

    }

    public String object2Xml(Object object) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.writeValueAsString(object);
    }

    public Object xml2Object(String xml, Class<?> cls) throws JsonProcessingException {
        ObjectMapper objectMapper = new XmlMapper();
        return objectMapper.readValue(xml, cls);
    }
}
