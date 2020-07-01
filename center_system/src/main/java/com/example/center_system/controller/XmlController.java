package com.example.center_system.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
public class XmlController {

    @PostMapping(path = "/post_test", consumes = "application/xml")
    public String postTest(@RequestBody String string) throws JsonProcessingException {
        System.out.println(string);
        return "success";
    }

    @GetMapping(path = "/get_test")
    public String getTest(){
        return "<A系统学生选课信息><课程编号A>12</课程编号A><学生信息A 学号=\"1\"><姓名>邵轶凡syf</姓名><性别>female</性别></学生信息A><学生成绩A>100</学生成绩A></A系统学生选课信息>";
    }


    @GetMapping(path = "/get_A_courses")
    public String getACourses(){
        return "<A系统学生选课信息><课程编号A>12</课程编号A><学生信息A 学号=\"1\"><姓名>邵轶凡syf</姓名><性别>female</性别></学生信息A><学生成绩A>100</学生成绩A></A系统学生选课信息>";
    }

    @GetMapping(path = "/get_B_courses")
    public String getBCourses(){
        return "<A系统学生选课信息><课程编号A>12</课程编号A><学生信息A 学号=\"1\"><姓名>邵轶凡syf</姓名><性别>female</性别></学生信息A><学生成绩A>100</学生成绩A></A系统学生选课信息>";
    }

    @GetMapping(path = "/get_C_courses")
    public String getCCourses(){
        return "<A系统学生选课信息><课程编号A>12</课程编号A><学生信息A 学号=\"1\"><姓名>邵轶凡syf</姓名><性别>female</性别></学生信息A><学生成绩A>100</学生成绩A></A系统学生选课信息>";
    }


}
