package com.example.center_system.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
public class XmlController {

    @PostMapping(path = "/post_test", consumes = "application/xml")
    public String postTest(@RequestBody String string) throws JsonProcessingException {
        System.out.println("postTest...");
        System.out.println(string);
        return "success";
    }

    @GetMapping(path = "/get_test")
    public String getTest(){
        System.out.println("getTest...");
        return "<A系统学生选课信息><课程编号A>12</课程编号A><学生信息A 学号=\"1\"><姓名>邵轶凡syf</姓名><性别>female</性别></学生信息A><学生成绩A>100</学生成绩A></A系统学生选课信息>";
    }

    @PostMapping(path = "/A_choose_B", consumes = "application/xml")
    public String AChooseB(@RequestBody String string) throws JsonProcessingException {
        try {
            System.out.println(string);
            return "success";
        }catch (Exception e) {
            return "fail";
        }
    }

    @PostMapping(path = "/A_choose_C", consumes = "application/xml")
    public String AChooseC(@RequestBody String string) throws JsonProcessingException {
        try {
            System.out.println(string);
            return "success";
        }catch (Exception e) {
            return "fail";
        }
    }

    @PostMapping(path = "/B_choose_A", consumes = "application/xml")
    public String BChooseA(@RequestBody String string) throws JsonProcessingException {
        try {
            System.out.println(string);
            return "success";
        }catch (Exception e) {
            return "fail";
        }
    }

    @PostMapping(path = "/B_choose_C", consumes = "application/xml")
    public String BChooseC(@RequestBody String string) throws JsonProcessingException {
        try {
            System.out.println(string);
            return "success";
        }catch (Exception e) {
            return "fail";
        }
    }

    @PostMapping(path = "/C_choose_A", consumes = "application/xml")
    public String CChooseA(@RequestBody String string) throws JsonProcessingException {
        try {
            System.out.println(string);
            return "success";
        }catch (Exception e) {
            return "fail";
        }
    }

    @PostMapping(path = "/C_choose_B", consumes = "application/xml")
    public String CChooseB(@RequestBody String string) throws JsonProcessingException {
        try {
            System.out.println(string);
            return "success";
        }catch (Exception e) {
            return "fail";
        }
    }

    @PostMapping(path = "/A_drop_B", consumes = "application/xml")
    public String ADropB(@RequestBody String string) throws JsonProcessingException {
        try {
            System.out.println(string);
            return "success";
        }catch (Exception e) {
            return "fail";
        }
    }

    @PostMapping(path = "/A_drop_C", consumes = "application/xml")
    public String ADropC(@RequestBody String string) throws JsonProcessingException {
        try {
            System.out.println(string);
            return "success";
        }catch (Exception e) {
            return "fail";
        }
    }
    @PostMapping(path = "/B_drop_A", consumes = "application/xml")
    public String BDropA(@RequestBody String string) throws JsonProcessingException {
        try {
            System.out.println(string);
            return "success";
        }catch (Exception e) {
            return "fail";
        }
    }
    @PostMapping(path = "/B_drop_C", consumes = "application/xml")
    public String BDropC(@RequestBody String string) throws JsonProcessingException {
        try {
            System.out.println(string);
            return "success";
        }catch (Exception e) {
            return "fail";
        }
    }
    @PostMapping(path = "/C_drop_A", consumes = "application/xml")
    public String CDropA(@RequestBody String string) throws JsonProcessingException {
        try {
            System.out.println(string);
            return "success";
        }catch (Exception e) {
            return "fail";
        }
    }
    @PostMapping(path = "/C_drop_B", consumes = "application/xml")
    public String CDropB(@RequestBody String string) throws JsonProcessingException {
        try {
            System.out.println(string);
            return "success";
        }catch (Exception e) {
            return "fail";
        }
    }

    @GetMapping(path = "/get_A_courses")
    public String getACourses(){
        return "<A系统学生选课信息><课程编号A>12</课程编号A><学生信息A 学号=\"1\"><姓名>邵轶凡syf</姓名><性别>female</性别></学生信息A><学生成绩A>100</学生成绩A></A系统学生选课信息>";
    }

    @GetMapping(path = "/get_B_courses")
    public String getBCourses(){
        return "<A系统学生选课信息><课程编号A>12</课程编号A><学生信息A 学号=\"1\"><姓名>邵轶凡syf</姓名><性别>female</性别></学生信息A><学生成绩A>100</学生成绩A></A系统学生选课信息>";
    }

    @GetMapping(path = "/get_C_courses")
    public String getCCourses(){
        return "<A系统学生选课信息><课程编号A>12</课程编号A><学生信息A 学号=\"1\"><姓名>邵轶凡syf</姓名><性别>female</性别></学生信息A><学生成绩A>100</学生成绩A></A系统学生选课信息>";
    }


}
