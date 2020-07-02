package com.example.a_system.service;


import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.xml.ws.Endpoint;


@javax.jws.WebService
public class WebService {

    public WebService(){}

    @WebMethod
    public String AWebService(){
        System.out.println("This is the public method SystemA offers...");
        return "This is A WebService...";
    }

}
