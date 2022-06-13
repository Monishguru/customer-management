
package com.dhl.customer.controlleradvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dhl.customer.exception.InvalidInputException;

@ControllerAdvice
public class CustomerControllerAdvice {

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> handleEmptyData(EmptyResultDataAccessException exception) {
		Map<String,Object> response = new HashMap();
		response.put("message", exception.getMessage());
		response.put("Time",LocalDate.now());
		response.put ("Expected number of Records",exception.getExpectedSize());
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleEmptyData(NoSuchElementException exception) {
		Map<String,Object> response = new HashMap();
		response.put("message", exception.getMessage());
		response.put("Time",LocalDate.now());
		//response.put ("Expected number of Records",exception.getExpectedSize());
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> handleEmptyData(NullPointerException exception) {
		Map<String,Object> response = new HashMap();
		response.put("message", "Not coded properly");
		response.put("Time",LocalDate.now());
		//response.put ("Expected number of Records",exception.getExpectedSize());
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<Object> handleEmptyData(InvalidInputException exception) {
		Map<String,Object> response = new HashMap();
		response.put("message", "Incorrect Input.");
		response.put("Time",LocalDate.now());
		//response.put ("Expected number of Records",exception.getExpectedSize());
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}

}
