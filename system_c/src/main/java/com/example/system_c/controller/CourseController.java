package com.example.system_c.controller;

import com.example.system_c.service.CourseService;
import com.example.system_c.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("/")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/addCourse")
    public Response addCourse(@RequestParam(value = "cname",required = true) String cname,@RequestParam(value = "teacher",required = true) String teacher,@RequestParam(value = "credit",required = true) String credit,@RequestParam(value = "share",required = true) String share){
        return Response.ResponseSuccess(courseService.addCourse("",cname,teacher,credit,share));
    }

    @GetMapping("/deleteCourse")
    public Response deleteCourse(@RequestParam(value = "cno",required = true) String cno){
        return Response.ResponseSuccess(courseService.deleteCourse(cno));
    }

    @GetMapping("/updateCourse")
    public Response updateCourse(@RequestParam(value = "cno",required = true) String cno,@RequestParam(value = "cname",required = true) String cname,@RequestParam(value = "teacher",required = true) String teacher,@RequestParam(value = "credit",required = true) String credit,@RequestParam(value = "share",required = true) String share){
        return Response.ResponseSuccess(courseService.updateCourse(cno,cname,teacher,credit,share));
    }

    @GetMapping("/chooseCourse")
    public Response chooseCourse(@RequestParam(value = "cno",required = true) String cno,@RequestParam(value = "sno",required = true) String sno){
        Boolean result=courseService.chooseCourse(sno,cno);
        System.out.println(result);
        return Response.ResponseSuccess(result);
    }

    @GetMapping("/dropCourse")
    public Response dropCourse(@RequestParam(value = "cno",required = true) String cno,@RequestParam(value = "sno",required = true) String sno){
      //  try {
            return Response.ResponseSuccess(courseService.dropCourse(sno,cno));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return Response.ResponseFail("dropCourse Fail...");
//        }
    }

    @GetMapping("/GetStudentCourses")
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
    @GetMapping("/getOtherCourses")
    public Response getOtherCourses(@RequestParam(value = "type",required = true) String type){
        return Response.ResponseSuccess(courseService.getOtherCourses(type));
    }
}
