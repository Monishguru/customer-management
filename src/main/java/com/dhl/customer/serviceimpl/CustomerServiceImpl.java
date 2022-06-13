package com.dhl.customer.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dhl.customer.entity.Customer;
import com.dhl.customer.exception.InvalidInputException;
import com.dhl.customer.repository.CustomerRepository;
import com.dhl.customer.service.CustomerService;
import com.dhl.customer.util.CustomerConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;

	@Override
	public Customer saveCustomer(Customer customer) {
		log.info("Saving customer");
		return customerRepo.save(customer);
	}
	
	@Override
	public Customer getCustomerById(Long id) {
		log.info("Finding customer by Id");
		Optional <Customer> customer = customerRepo.findById(id);
		if(customer.get()!=null) {
			return customer.get();
		}
		else {
			throw new EmptyResultDataAccessException(CustomerConstants.CUSTOMER_NOT_FOUND, 1);
		}
	}

	@Override
	public Customer getCustomerByName(String name) {
		log.info("Finding Customer by First Name or Last name");
		return customerRepo.findByFirstNameOrLastName(name,name);
	}
	
	@Override
	public void deleteCustomer(Long id) {
		log.info("Deleting Customer");
	    customerRepo.deleteById(id);
	}

	@Override
	public Customer updateCustomer(Customer customer) throws InvalidInputException {
		
		if(customer.getId()!=null) {
			return customerRepo.save(customer);
		}
		else {
			throw new InvalidInputException("Invalid Input. ID Mandatory");
		}
		
		
	}

}
