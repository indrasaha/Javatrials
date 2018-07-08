package com.niltech.template.service.rest.operation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.niltech.template.service.rest.operation"})
public class RestTemplateApplication extends SpringBootServletInitializer	{

/*	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GreetingApplication.class);
    }	
*/	
	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);	
	}

}
