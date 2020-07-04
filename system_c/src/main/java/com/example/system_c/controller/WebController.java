package com.example.system_c.controller;

import com.example.system_c.service.CWebService;
import com.example.system_c.vo.Response;
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
    CWebService webService;

    @GetMapping("/getShareCoursesNum1")
    public Response getAShareCoursesNum(){  //获取A学院的共享课程数量
        return Response.ResponseSuccess(webService.getAWebService());
    }

    @GetMapping("/getShareCoursesNum2")
    public Response getBShareCoursesNum(){    //获取B学院的共享课程数量
        return Response.ResponseSuccess(webService.getBWebService());
    }




}
