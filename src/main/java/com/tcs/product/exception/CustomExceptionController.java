package com.tcs.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionController {
	
	@ExceptionHandler(value=NoProductsFoundException.class)
	public ResponseEntity<Object> NoProductsFoundException(NoProductsFoundException exception){
		return new ResponseEntity<>("No product matched the search", HttpStatus.NOT_FOUND);
	}
}
