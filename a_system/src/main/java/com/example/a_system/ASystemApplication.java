package com.example.a_system;

import com.example.a_system.service.aWebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.xml.ws.Endpoint;

@SpringBootApplication
public class ASystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ASystemApplication.class, args);
        System.out.println("发布webservice");
        Endpoint.publish("http://localhost:8099/Service/getAWebService", new aWebService());

    }

}
