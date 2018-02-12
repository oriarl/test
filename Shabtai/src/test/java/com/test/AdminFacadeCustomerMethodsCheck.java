package com.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.common.ClientType;
import com.entities.Customer;
import com.entrance.CouponSystem;
import com.facade.AdminFacade;

@Component
public class AdminFacadeCustomerMethodsCheck {

	@Autowired
	CouponSystem couponSystem;

	
	
	// this method verifies that the code can handle a duplicated Customer
	// if Admin will try to create a new Customer (which is already exist in DB)
	// an exception will be thrown says Customer already exist
	@Test
	public void DublicatedCustomerVerification() {
		AdminFacade adminFacade = (AdminFacade) couponSystem.login("admin", "1234", ClientType.ADMIN);
		Customer shabtay = new Customer("shabtay", "1268712");
		adminFacade.createCustomer(shabtay);
	}
	
	

}
