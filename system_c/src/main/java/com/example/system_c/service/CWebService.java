package com.example.system_c.service;


import com.example.system_c.dao.CourseDao;
import com.example.system_c.dao.Repository.CourseRepository;
import com.example.system_c.vo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;



//import com.example.a_system.service.WebServiceService;
//import com.example.a_system.service.WebService;

import javax.jws.WebMethod;
//import javax.jws.WebService;
import java.util.List;


@javax.jws.WebService
@Service
public class CWebService extends SpringBeanAutowiringSupport {
    @Autowired
    CourseRepository courseRepository;



    public CWebService(){}

    @WebMethod
    public String CWebService(){
        System.out.println("This is the public method SystemC offers...");

        List<Course> courses=courseRepository.getSharedCourse();
        return "C学院的共享课程数量是"+courses.size()+"人";
    }

    @WebMethod(exclude = true)
    public String getAWebService(){
        //调用A的webService
        com.example.a_system.service.AWebServiceService wss = new com.example.a_system.service.AWebServiceService();
        com.example.a_system.service.AWebService ws=wss.getPort(com.example.a_system.service.AWebService.class);
        String result = ws.aWebService();
        return result;
    }

    @WebMethod(exclude = true)
    public String getBWebService(){
        //调用B的webService
//        WebServiceService wss = new WebServiceService();
//        WebService ws=wss.getPort(WebService.class);
//        String result = ws.cWebService();
        return "";
    }

}
