package com.exceptions;

public class CompanyAlreadyExistException extends Exception{
	
	public CompanyAlreadyExistException (String message) {
		super(message);
	}
}
