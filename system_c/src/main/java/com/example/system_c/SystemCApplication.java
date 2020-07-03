package com.example.system_c;

import com.example.system_c.service.WebService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.xml.ws.Endpoint;


@SpringBootApplication
public class SystemCApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemCApplication.class, args);
		System.out.println("发布webservice");
		Endpoint.publish("http://localhost:8101/Service/getAWebService", new WebService());
	}

}
