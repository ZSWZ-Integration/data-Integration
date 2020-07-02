package com.example.center_system.controller;

import com.example.center_system.Service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.TransformerException;
import java.io.IOException;

@RestController
@RequestMapping("/share")
public class ShareController {

    @Autowired
    ShareService shareService;

    @GetMapping(path = "/getSharedCourseForA")
    public String getSharedCourseForA() throws IOException, TransformerException {
        return shareService.AGetSharedCourse();
    }

    @GetMapping(path = "/getSharedCourseForB")
    public String getSharedCourseForB() throws IOException, TransformerException {
        return shareService.BGetSharedCourse();
    }

    @GetMapping(path = "/getSharedCourseForC")
    public String getSharedCourseForC() throws IOException, TransformerException {
        return shareService.CGetSharedCourse();
    }

}
