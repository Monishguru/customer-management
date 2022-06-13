package com.dhl.customer.service;

import com.dhl.customer.entity.Customer;
import com.dhl.customer.exception.InvalidInputException;

public interface CustomerService {
	
	public Customer saveCustomer(Customer customer);

	public Customer getCustomerById(Long id);

	public Customer getCustomerByName(String name);

	public void deleteCustomer(Long id);

	public Customer updateCustomer(Customer customer) throws InvalidInputException;

}
