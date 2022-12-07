package com.cs.restapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.restapi.entity.Customer;
import com.cs.restapi.repository.CustomerRepo;
import com.springboot.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepo customerRepo;
	
	@GetMapping("/get")
	public List<Customer> getCustomer()
	{
		return customerRepo.findAll();
	}
	
	
	
	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer)
	{
		return customerRepo.save(customer);
		
	}
	
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customerDetails)
	{
		Customer customer = customerRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Customer not exist with id"+id));
		customer.setFirstName(customerDetails.getFirstName());
		customer.setLastName(customerDetails.getLastName());
		customer.setEmail(customerDetails.getEmail());
		
		Customer updatedCostumer = customerRepo.save(customer);
		return ResponseEntity.ok(customer);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable long id)
	{
		Customer customer = customerRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Customer not exist with id"+id));
		
		customerRepo.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	
}
