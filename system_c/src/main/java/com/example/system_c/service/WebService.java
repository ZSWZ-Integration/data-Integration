package com.example.system_c.service;


import javax.jws.WebMethod;


@javax.jws.WebService
public class WebService {

    public WebService(){}

    @WebMethod
    public String CWebService(){
        System.out.println("This is the public method SystemC offers...");
        return "This is C WebService...";
    }

}
