package com.example.system_c.service;


import javax.jws.WebMethod;


@javax.jws.WebService
public class WebService {

    public WebService(){}

    @WebMethod
    public String AWebService(){
        System.out.println("This is the public method SystemA offers...");
        return "This is A WebService...";
    }

}
