package tester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.niltech.template.service.rest.operation.RestTemplateApplication;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.niltech.template.service.rest.operation"})
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);	
	}

}
