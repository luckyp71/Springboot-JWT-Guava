package com.example.main.config;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;

import com.google.common.cache.CacheBuilder;

@Configuration
@EnableCaching
public class CacheConfig implements CachingConfigurer {

	@Bean
	@Override
	public CacheManager cacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager();
		
		// Single Object of Customer 
		GuavaCache customerCache = new GuavaCache("customer", CacheBuilder.newBuilder()
				.expireAfterWrite(3,TimeUnit.MINUTES)
				.build());
				
				
		// List of Customers
		GuavaCache customersCache = new GuavaCache("customers", CacheBuilder.newBuilder()
				.expireAfterWrite(3, TimeUnit.MINUTES)
				.build());
		
		// New Customer
		GuavaCache newCustomerCache = new GuavaCache("newCustomer", CacheBuilder.newBuilder()
				.expireAfterWrite(3, TimeUnit.MINUTES)
				.build());
		
		// Update Customer
		GuavaCache updateCustomerCache = new GuavaCache("updateCustomer", CacheBuilder.newBuilder()
				.expireAfterWrite(3, TimeUnit.MINUTES)
				.build());
		
		// Delete Customer
		GuavaCache deleteCustomerCache = new GuavaCache("deleteCustomer", CacheBuilder.newBuilder()
				.expireAfterWrite(3, TimeUnit.MINUTES)
				.build());
		
		cacheManager.setCaches(Arrays.asList(customerCache, customersCache, newCustomerCache, updateCustomerCache, deleteCustomerCache));
		
		return cacheManager;

	}

	@Override
	public CacheResolver cacheResolver() {
		// This body code intentionally left blank
		return null;
	}

	@Override
	public CacheErrorHandler errorHandler() {
		// This body code intentionally left blank
		return null;
	}

	@Override
	public KeyGenerator keyGenerator() {
		return new SimpleKeyGenerator();
	}

}
