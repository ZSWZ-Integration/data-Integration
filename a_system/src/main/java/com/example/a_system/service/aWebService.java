package com.example.a_system.service;


import org.springframework.stereotype.Service;


import javax.jws.WebMethod;
import javax.xml.ws.Endpoint;

@Service
@javax.jws.WebService
public class aWebService {

    public aWebService(){}

    @WebMethod
    public String AWebService(){
        System.out.println("This is the public method SystemA offers...");
        return "A学院的共享课程数量是6门";
    }

    @WebMethod(exclude = true)
    public String getBWebService(){
        //调用B的webService
//        WebServiceService wss = new WebServiceService();
//        WebService ws=wss.getPort(WebService.class);
//        String result = ws.cWebService();
        return "B学院的共享课程数量是"+"8"+"门";
    }

    @WebMethod(exclude = true)
    public String getCWebService(){
        //调用C的webService
        com.example.system_c.service.CWebServiceService wss = new com.example.system_c.service.CWebServiceService();
        com.example.system_c.service.CWebService ws=wss.getPort(com.example.system_c.service.CWebService.class);
        String result = ws.cWebService();
        return result;
    }


}
