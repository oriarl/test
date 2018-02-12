package com.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.common.ClientType;
import com.entities.Company;
import com.entities.Customer;
import com.entrance.CouponSystem;
import com.facade.AdminFacade;
import com.facade.CompanyFacade;

@Component
public class AdminFacadeCompanyMethodsCheck {

	@Autowired
	CouponSystem couponSystem;
	
	/*
	 *   TestAdminFacadeMethods class checks all methods of AdminFacade.
	 * 	 1) createCompany() is checked in class "TestLoadDataBase"
	 * 	 2) getComapny() is checked here in method's removeCompany() & updateCompany()	  
	 * 
	 */
	
	
	
	// when company is removed , all its coupons are removed as well form Coupon DB
	@Test
	public void removeCompany() {
		AdminFacade adminFacade = (AdminFacade) couponSystem.login("admin", "1234", ClientType.ADMIN);
		System.out.println(adminFacade.getCompany(2));
		adminFacade.removeCompany(adminFacade.getCompany(2));		
	}
	
	// this method verifies that the code can handle a duplicated company 
	// if Admin will try to create a new company (which is already exist in DB) 
	// an exception will be thrown says company already exist
	@Test
	public void DublicatedCompanyVerification() {
		AdminFacade adminFacade = (AdminFacade) couponSystem.login("admin", "1234", ClientType.ADMIN);
		Company aroma1 = new Company("Aroma", "4564", "aroma@gmail.com");
		adminFacade.createCompany(aroma1);
	}

	
	@Test
	public void updateCompanyWithNewPassword() {	
		AdminFacade adminFacade = (AdminFacade) couponSystem.login("admin", "1234", ClientType.ADMIN);		
		Company tempComany = adminFacade.getCompany(14);
		System.out.println(tempComany);
		tempComany.setPassword("1977");
		adminFacade.updateCompany(tempComany);
		System.out.println(tempComany);		
	}
	
	@Test
	public void getAllCompanies() {
		AdminFacade adminFacade = (AdminFacade) couponSystem.login("admin", "1234", ClientType.ADMIN);
	}
	
	
	@Test
	public void getAllCoupon() {
		CompanyFacade compFacade = (CompanyFacade) couponSystem.login("Aroma", "456456", ClientType.COMPANY);
		System.out.println(compFacade.getAllCoupon());
	}
	
}
