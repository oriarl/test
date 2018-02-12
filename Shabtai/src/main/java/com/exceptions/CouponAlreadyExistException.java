package com.exceptions;

public class CouponAlreadyExistException extends RuntimeException {

	public CouponAlreadyExistException(String message) {

		super(message);
	}

}
