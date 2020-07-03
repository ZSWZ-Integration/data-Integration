package com.example.a_system;

import com.example.a_system.service.aWebService;
import com.example.system_c.service.WebService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.system_c.service.WebServiceService;
import com.example.system_c.service.WebService;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class ASystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ASystemApplication.class, args);
        //System.out.println("发布webservice");
        //Endpoint.publish("http://localhost:8099/Service/getAWebService", new WebService());
        WebServiceService wss = new WebServiceService();
        WebService ws=wss.getPort(WebService.class);
        String output = ws.cWebService();
        System.out.println(output);
    }

}
