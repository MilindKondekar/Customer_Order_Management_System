package com.cs.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.restapi.entity.Orders;

public interface OrderRepo extends JpaRepository<Orders, Long> {

}
