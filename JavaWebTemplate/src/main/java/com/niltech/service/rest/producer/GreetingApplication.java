package com.niltech.service.rest.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GreetingApplication extends SpringBootServletInitializer	{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GreetingApplication.class);
    }	
	
	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);	
	}

}
