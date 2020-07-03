package com.example.system_c.controller;

import com.example.system_c.service.UserService;
import com.example.system_c.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/login")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public Response login(@RequestParam(value = "username",required = true) String username, @RequestParam(value = "password",required = true) String password){
        return Response.ResponseSuccess(userService.login(username,password));
    }

}
