package com.example.center_system.controller;

import com.example.center_system.initializer.StatisticCache;
import com.example.center_system.vo.Response;
import com.example.center_system.vo.StatisticData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping("/")
public class StatisticShowController {

    @GetMapping("/showStatisticData")
    public Response showStatisticData(){
        System.out.println("showStatisticData");
        return Response.ResponseSuccess(new StatisticData(StatisticCache.courseCache,StatisticCache.studentCache));
    }
}
