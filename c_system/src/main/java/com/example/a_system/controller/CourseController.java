package com.example.a_system.controller;

import com.example.a_system.service.CourseService;
import com.example.a_system.vo.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping("/addCourse")
    public Response addCourse(@RequestParam(value = "cname",required = true) String cname,@RequestParam(value = "ctime",required = true) String ctime,@RequestParam(value = "teacher",required = true) String teacher,@RequestParam(value = "credit",required = true) String credit,@RequestParam(value = "type",required = true) String type,@RequestParam(value = "share",required = true) String share){
        return Response.ResponseSuccess(courseService.addCourse(cname,ctime,teacher,credit,type,share));
    }

    @RequestMapping("/deleteCourse")
    public Response deleteCourse(@RequestParam(value = "cno",required = true) String cno){
        return Response.ResponseSuccess(courseService.deleteCourse(cno));
    }

    @RequestMapping("/updateCourse")
    public Response updateCourse(@RequestParam(value = "cno",required = true) String cno,@RequestParam(value = "cname",required = true) String cname,@RequestParam(value = "ctime",required = true) String ctime,@RequestParam(value = "teacher",required = true) String teacher,@RequestParam(value = "credit",required = true) String credit,@RequestParam(value = "type",required = true) String type,@RequestParam(value = "share",required = true) String share){
        return Response.ResponseSuccess(courseService.updateCourse(cno,cname,ctime,teacher,credit,type,share));
    }

    @RequestMapping("/chooseCourse")
    public Response chooseCourse(@RequestParam(value = "cno",required = true) String cno,@RequestParam(value = "sno",required = true) String sno){
        return Response.ResponseSuccess(courseService.chooseCourse(sno,cno));
    }

    @RequestMapping("/dropCourse")
    public Response dropCourse(@RequestParam(value = "cno",required = true) String cno,@RequestParam(value = "sno",required = true) String sno){
        try {
            return Response.ResponseSuccess(courseService.dropCourse(sno,cno));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Response.ResponseFail("dropCourse Fail...");
        }
    }

    @RequestMapping("/GetStudentCourses")
    public Response GetStudentCourse(@RequestParam(value = "sno",required = true) String sno){
        return Response.ResponseSuccess(courseService.getStudentCourse(sno));
    }

    @RequestMapping("/getAllCourses")
    public Response getAllCourse(){
        return Response.ResponseSuccess(courseService.getAllCourse());
    }

    /**
     * 将某院课程设置为对A院共享
     */
    @RequestMapping("/getOtherCourses")
    public Response getOtherCourses(@RequestParam(value = "type",required = true) String type){
        return Response.ResponseSuccess(courseService.getOtherCourses(type));
    }
}