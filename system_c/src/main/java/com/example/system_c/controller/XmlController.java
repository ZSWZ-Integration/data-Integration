package com.example.system_c.controller;

import com.example.system_c.service.CourseService;
import com.example.system_c.service.StatisticService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XmlController {  //Todo:完善接收xml的controller
    @Autowired
    CourseService courseService;
    @Autowired
    StatisticService statisticService;

    @GetMapping(path="/getSharedCourses")
    public String  getSharedCourses(){ //获取本院系的共享课程，返回xml的字符串
        String result=courseService.shareCourses();
        System.out.println("In getSharedCourses Controller...");
        System.out.println(result);
        return result;
    }

    @PostMapping(path = "/othersAddCourse", consumes = "application/xml")
    public String othersAddCourse(@RequestBody String string)throws JsonProcessingException {    //外院系学生的选课，获取选课和学生的xml文件
        System.out.println("othersAddCourse...");
        System.out.println(string);
        return courseService.othersAddCourse(string);
    }

    @PostMapping(path = "/othersDropCourse", consumes = "application/xml")
    public String othersDropCourse(@RequestBody String string)throws JsonProcessingException{    //外院系学生的退课，获取选课的xml文件
        return courseService.othersDeleteCourse(string);

    }

    @GetMapping("/getAllCourseStatistic")
    public String  getAllCourseStatistic(){ //获取本院系的共享课程，返回xml的字符串
        return statisticService.getAllCourseStatistic();
    }

    @GetMapping("/getAllStudentStatistic")
    public String  getAllStudentStatistic(){ //获取本院系的共享课程，返回xml的字符串
        return statisticService.getAllStudentStatistic();
    }



}
