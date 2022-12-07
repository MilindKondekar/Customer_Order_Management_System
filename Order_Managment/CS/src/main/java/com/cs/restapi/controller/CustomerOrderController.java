package com.cs.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.restapi.entity.Customer;
import com.cs.restapi.entity.Orders;
import com.cs.restapi.repository.CustomerRepo;
import com.cs.restapi.repository.OrderRepo;

@RestController
@RequestMapping("/customer/order")
public class CustomerOrderController {


	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private CustomerRepo customerRepo;
	
	
	public CustomerOrderController(OrderRepo orderRepo, CustomerRepo customerRepo) {		
		this.orderRepo = orderRepo;
		this.customerRepo = customerRepo;
	}

	@PostMapping("/new")
	public Customer createOrderByCustomer(@RequestBody Customer customer)
	{
		return customerRepo.save(customer);
		
	}
}
