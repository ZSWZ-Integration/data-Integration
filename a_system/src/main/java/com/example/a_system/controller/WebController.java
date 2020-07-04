package com.example.a_system.controller;


import com.example.a_system.service.aWebService;
import com.example.a_system.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("/")
public class WebController {
    @Autowired
    aWebService webService;

    @GetMapping("/getShareCoursesNum1")
    public Response getBShareCoursesNum(){  //获取B学院的共享课程数量
        return Response.ResponseSuccess(webService.getBWebService());
    }

    @GetMapping("/getShareCoursesNum2")
    public Response getCShareCoursesNum(){    //获取C学院的共享课程数量
        return Response.ResponseSuccess(webService.getCWebService());
    }




}
