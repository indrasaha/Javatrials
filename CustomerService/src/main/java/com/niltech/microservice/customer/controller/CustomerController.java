package com.niltech.microservice.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niltech.microservice.customer.entity.Customer;
import com.niltech.microservice.customer.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/")
	public Customer saveCustomer(@RequestBody Customer Customer) {
		log.info("Inside CustomerController :: saveCustomer" + Customer);
		return customerService.saveCustomer(Customer);
	}
	
	@GetMapping("/{id}")
	public Optional<Customer> findCustomerById(@PathVariable("id") long CustomerId) {
		log.info("Inside CustomerController :: findCustomerById " + CustomerId);
		return customerService.findCustomerById(CustomerId);
	}
	
	@GetMapping("/all")
	public Optional<List<Customer>> findAllCustomers() {
		log.info("Inside CustomerController :: findAllCustomers");
		return customerService.findAllCustomers();
	}
}
