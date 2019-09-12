package com.niltech.service.rest.consumer.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication(scanBasePackages="com.niltech.service.rest.consumer.springboot")
@SpringBootApplication
//@SpringBootConfiguration
//@ComponentScan
public class ServiceConsumer {
	
//	private static final String baseURL = "http://localhost:8080/JavaRestTemplate/";

	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumer.class);
	}
	
	@Bean
	public RestTemplateBuilder builder() {
		return new RestTemplateBuilder();
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
		
	@Bean
	public CommandLineRunner demo(RestTemplate restTemplate) {
		return (args) -> {
			String baseURL = "http://localhost:8080/";
			
//			System.out.println(restTemplate.getForObject(baseURL+"greeting", String.class));
			
			// save a couple of customers
//			restTemplate.postForObject(baseURL+"pushdata", new MyData(1, "11111 - test content",78.0), MyData.class);
			
			/*restTemplate.postForObject(baseURL+"pushdata", new ServiceData(2, "22222 - test content",8.0), ServiceData.class);
			restTemplate.postForObject(baseURL+"pushdata", new ServiceData(3, "33333 - test content",98.9), ServiceData.class);
			*/
			//System.out.println(restTemplate.getForObject(baseURL+"getdata?id=2", ServiceData.class));
		};
	}

}
