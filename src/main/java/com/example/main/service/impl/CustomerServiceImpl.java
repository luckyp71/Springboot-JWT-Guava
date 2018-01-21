package com.example.main.service.impl;

import java.util.Collection;

import com.example.main.model.Customer;
import com.example.main.repository.CustomerRepository;
import com.example.main.service.CustomerService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository cusRepo;

	private final String responseSuccess = "{\"responseDesc\":\"success\"}";
	private final String objNotFound = "{\"responseDesc\":\"object not found\"}";
	private final String dataAlreadyExists = "{\"responseDesc\":\"data with given id already exists\"}";

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	@Cacheable("customers")
	public Collection<Customer> getCustomers() throws InterruptedException {
		log.info("Start getting list of customers data");
		Thread.sleep(5000);
		Collection<Customer> customers = cusRepo.findAll();
		log.info("Return list of customers data");
		return customers;
	}

	@Override
	@Cacheable("customer")
	public Customer getCustomer(Long id) throws InterruptedException {
		log.info("Start getting a single object of customer data");
		Thread.sleep(5000);
			Customer customer = cusRepo.findOne(id);
			log.info("Return single object of customer data");
			return customer;
	}

	@Override
	@Cacheable("newCustomer")
	public String createCustomer(Customer customer) throws InterruptedException {
		Customer customerPersisted = getCustomer(customer.getId());
		log.info("Start creating a new customer data");
		Thread.sleep(5000);
		if (customerPersisted != null) {
			log.warn("Data already exists");
			return dataAlreadyExists;
		} else {
			cusRepo.save(customer);
			log.info("New customer recorded");
			return responseSuccess;
		}
	}

	@Override
	@Cacheable("updateCustomer")
	public String updateCustomer(Customer customer) throws InterruptedException {
		Customer customerPersisted = getCustomer(customer.getId());
		log.info("Start updating a customer data");
		Thread.sleep(5000);
		if (customerPersisted != null) {
			cusRepo.save(customer);
			log.info("Customer data updated successfully");
			return responseSuccess;
		} else {
			log.warn("Customer data with given id not found");
			return objNotFound;
		}
	}

	@Override
	@Cacheable("deleteCustomer")
	public String deleteCustomer(Long id) throws InterruptedException {
		Customer customerPersisted = cusRepo.findOne(id);
		log.info("Start deleting a customer data");
		Thread.sleep(5000);
		if (customerPersisted != null) {
			cusRepo.delete(id);
			log.info("Customer data deleted successfully");
			return responseSuccess;
		} else {
			log.warn("Customer data with given id not found");
			return objNotFound;
		}
	}

}
