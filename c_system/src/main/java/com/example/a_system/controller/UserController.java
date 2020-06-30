package com.example.a_system.controller;

import com.example.a_system.service.UserService;
import com.example.a_system.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public Response login(@RequestParam(value = "username",required = true) String username, @RequestParam(value = "password",required = true) String password){
        return Response.ResponseSuccess(userService.login(username,password));
    }

}
