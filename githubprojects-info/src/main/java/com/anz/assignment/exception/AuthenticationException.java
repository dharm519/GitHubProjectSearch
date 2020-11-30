package com.anz.assignment.exception;

public class AuthenticationException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public AuthenticationException(String errorMessage) {
        super(errorMessage);
    }

}
