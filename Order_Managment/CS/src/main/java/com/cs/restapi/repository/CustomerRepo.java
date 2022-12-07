package com.cs.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.restapi.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
