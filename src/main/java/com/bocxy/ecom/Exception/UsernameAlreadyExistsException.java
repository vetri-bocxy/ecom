package com.bocxy.ecom.Exception;


public class UsernameAlreadyExistsException extends RuntimeException {

	public UsernameAlreadyExistsException(String message) {
		super(message);
	}
}