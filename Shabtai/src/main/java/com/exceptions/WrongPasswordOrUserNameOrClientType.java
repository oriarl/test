package com.exceptions;

public class WrongPasswordOrUserNameOrClientType extends RuntimeException{
	
	public WrongPasswordOrUserNameOrClientType (String message) {
		super(message);
	}

}
