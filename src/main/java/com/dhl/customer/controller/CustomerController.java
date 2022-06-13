package com.dhl.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhl.customer.entity.Customer;
import com.dhl.customer.exception.InvalidInputException;
import com.dhl.customer.serviceimpl.CustomerServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerServiceImpl;

	@RequestMapping(method = RequestMethod.POST, value = "/save")
	@Operation (summary ="This service is used to Create customer information for DHL")
	public Customer saveCustomer(@RequestBody Customer customer) {
		log.info("Saving customer information");
		return customerServiceImpl.saveCustomer(customer);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getById")
	@Operation (summary ="This service is used to get customer information for DHL By id")
	public Customer getCustomerById(@RequestParam(value = "id") Long id) {
		log.info("Requesting customer information by Id");
		return customerServiceImpl.getCustomerById(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getByName")
	@Operation (summary ="This service is used to get customer information for DHL By name")
	public Customer getCustomerById(@RequestParam(value = "name") String name) {
		log.info("Requesting customer information by Name");
		return customerServiceImpl.getCustomerByName(name);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
	@Operation (summary ="This service is used to delete customer information for DHL By id")
	public String deletCustomer(@PathVariable(value = "id") Long id) {
		log.info("Deleting customer by id : {}", id);
		customerServiceImpl.deleteCustomer(id);
		return "Deleted Successfully";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	@Operation (summary ="This service is used to update customer information for DHL")
	public String updateCustomer(@RequestBody Customer customer) throws InvalidInputException {
		log.info("updating customer by id");
		customerServiceImpl.updateCustomer(customer);
		return "Updated Successfully";
	}

}
