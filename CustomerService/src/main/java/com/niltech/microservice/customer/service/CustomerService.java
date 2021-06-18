package com.niltech.microservice.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niltech.microservice.customer.entity.Customer;
import com.niltech.microservice.customer.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer) {
		log.info("Inside CustomerService :: saveCustomer " + customer);
		return customerRepository.save(customer);
	}

	public Optional<Customer> findCustomerById(long custId) {
		log.info("Inside CustomerService :: findOrderById " + custId);
		return customerRepository.findById(custId);
	}

	public Optional<List<Customer>> findAllCustomers() {
		log.info("Inside CustomerService :: findAllCustomers");
		return Optional.of(customerRepository.findAll());
	}

}
