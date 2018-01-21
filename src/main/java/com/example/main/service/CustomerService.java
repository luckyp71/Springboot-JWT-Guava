package com.example.main.service;

import com.example.main.model.Customer;

import java.util.Collection;

public interface CustomerService {

	// Return list of customers data
	Collection <Customer> getCustomers() throws InterruptedException;
	
	// Return a single object of customer data
	Customer getCustomer(Long id) throws InterruptedException;
	
	// Create new customer data
	String createCustomer(Customer customer) throws InterruptedException;
	
	// Update customer data
	String updateCustomer(Customer customer) throws InterruptedException;
	
	// Delete customer data
	String deleteCustomer(Long id) throws InterruptedException;
	
}
