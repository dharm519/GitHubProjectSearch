package com.anz.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ServiceException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ServiceException(String errorMessage) {
        super(errorMessage);
    }

}
