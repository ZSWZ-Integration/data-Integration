package com.example.a_system;

import com.example.a_system.service.XmlService;
import com.example.a_system.vo.ChoiceVO;
import com.example.a_system.vo.Course;
import com.example.a_system.vo.CourseListVO;
import com.example.a_system.vo.Student;
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
        List<Course> courses = new ArrayList<Course>();
        Course course1 = new Course("1", "1", "1", "1", "1", "1", "1");
        Course course2 = new Course("2", "2", "2", "2", "2", "2", "2");
        courses.add(course1);
        courses.add(course2);
        CourseListVO courseListVO = new CourseListVO(courses);
        System.out.println(object2Xml(courseListVO));
        //ChoiceVO choiceVO1 = (ChoiceVO) xml2Object("<A系统学生选课信息><课程编号A>cno</课程编号A><学生信息A><学生账号A>acc</学生账号A><学生密码A>password</学生密码A><创建日期A>date</创建日期A><学生编号A>sno</学生编号A><学生姓名A>sname</学生姓名A><学生性别A>no</学生性别A></学生信息A><学生成绩A>grade</学生成绩A></A系统学生选课信息>", ChoiceVO.class);
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
