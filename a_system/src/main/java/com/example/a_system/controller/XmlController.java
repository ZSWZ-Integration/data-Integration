package com.example.a_system.controller;

import com.example.a_system.service.CourseService;
import com.example.a_system.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class XmlController {  //Todo:完善接收xml的controller
    @Autowired
    CourseService courseService;

    @RequestMapping("/getSharedCourses")
    public Response getSharedCourses(){ //获取本院系的共享课程，在service层发送xml文件
        return Response.ResponseSuccess(courseService.shareCourses());
    }

    @RequestMapping(value = "/othersAddCourse",method = RequestMethod.POST, consumes = "application/xml")
    public Response othersAddCourse(){    //外院系学生的选课，获取选课和学生的xml文件
        //Todo
        return Response.ResponseSuccess(courseService.othersAddCourse());
    }

    @RequestMapping(value = "/othersDropCourse",method = RequestMethod.POST, consumes = "application/xml")
    public Response othersDropCourse(){    //外院系学生的退课，获取选课的xml文件
        //Todo
        return Response.ResponseSuccess(courseService.othersDeleteCourse());

    }

}
