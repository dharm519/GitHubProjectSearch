package com.anz.assignment.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.anz.assignment.model.ErrorResponse;

@ControllerAdvice
public class RestServiceExceptionHandler extends ResponseEntityExceptionHandler{
	
    @ExceptionHandler(ServiceException.class)
    public final ResponseEntity<Object> handleServiceException(ServiceException ex) {
    	List<String> details = new ArrayList<String>();
    	details.add(ex.getLocalizedMessage());
    	ErrorResponse error = new ErrorResponse("Validation failed, please input correct language/pageNo", details);
    	return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(AuthenticationException.class)
    public final ResponseEntity<Object> handleAuthenticationException(AuthenticationException ex) {
    	List<String> details = new ArrayList<String>();
    	details.add(ex.getLocalizedMessage());
    	ErrorResponse error = new ErrorResponse("Authentication Failure", details);
    	return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

}
