package com.example.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

import com.example.main.model.Customer;
import com.example.main.service.impl.CustomerServiceImpl;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerServiceImpl cuService;
	
	@GetMapping(value="/clearCache", produces = MediaType.APPLICATION_JSON_VALUE)
	@Caching(evict = {
			@CacheEvict(value="customer", allEntries = true),
			@CacheEvict(value="customers", allEntries = true),
			@CacheEvict(value="newCustomer", allEntries = true),
			@CacheEvict(value="updateCustomer", allEntries = true),
			@CacheEvict(value="deleteCustomer", allEntries = true)
	})
	public ResponseEntity<String> clearCache(){
		return ResponseEntity.accepted().body("{\"responseDesc\":\"cache is cleared successfully\"}");
	}
	
	@GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Customer>> getCustomers() throws InterruptedException{
		Collection<Customer> customers = cuService.getCustomers();
		return ResponseEntity.accepted().body(customers);
	}
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomer(@PathVariable("id")Long id) throws InterruptedException{
		Customer customer = cuService.getCustomer(id);
		return ResponseEntity.accepted().body(customer);
	}
	
	@PostMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) throws InterruptedException{
		String newCustomer = cuService.createCustomer(customer);
		return ResponseEntity.accepted().body(newCustomer);
	}
	
	@PutMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) throws InterruptedException{
		String updateCustomer = cuService.updateCustomer(customer);
		return ResponseEntity.accepted().body(updateCustomer);
	}
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteCustomer(@PathVariable("id")Long id) throws InterruptedException{
		String deleteCustomer = cuService.deleteCustomer(id);
		return ResponseEntity.accepted().body(deleteCustomer);
	}
}








