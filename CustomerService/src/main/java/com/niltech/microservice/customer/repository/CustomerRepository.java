package com.niltech.microservice.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niltech.microservice.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
