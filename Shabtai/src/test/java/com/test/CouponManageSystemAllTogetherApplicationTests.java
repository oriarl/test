package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.common.*;
import com.entities.*;
import com.facade.*;
import com.exceptions.*;
import com.entrance.CouponSystem;
import com.test.createDataBase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponManageSystemAllTogetherApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	CreateCouponsToCompanies createCouponsToCompanies;

	@Autowired
	CreateCompanyDataBase createCompanyDataBase;

	@Autowired
	CreateCustomerDataBase createCustomerDataBase;

	@Autowired
	CouponSystem couponSystem;

	@Test
	public void getEntranceToCouponSystem() {

		/*
		 * Ceating the DB checks with following methods of AdminFacade: 1)
		 * createCompany() 2) createCustomer()
		 */
		createCompanyDataBase.createDataBase();
		createCustomerDataBase.createDataBase();

		/*
		 * creating/adding/updaing Coupons to Companies
		 */
		createCouponsToCompanies.createCoupons();
		
		
		CompanyFacade companyFacde = (CompanyFacade) couponSystem.login("Aroma", "456456", ClientType.COMPANY);
		Coupon purchaseCoupon = companyFacde.getCoupon(7);
		
		CustomerFacade customerFacade = (CustomerFacade) couponSystem.login("shabtay", "12121212", ClientType.CUSTOMER);
		
		
		customerFacade.purchaseCoupon(purchaseCoupon);
		
		
		
		

//		CompanyFacade companyFacde = (CompanyFacade) couponSystem.login("Aroma", "456456", ClientType.COMPANY);
//
//		System.out.println(companyFacde.getAllCoupon());
//		Coupon coupon = companyFacde.getCoupon(6);
//		companyFacde.removeCoupon(coupon);
//		System.out.println(companyFacde.getAllCoupon());
		
		
//		CompanyFacade companyFacde = (CompanyFacade) couponSystem.login("Aroma", "456456", ClientType.COMPANY);
//
//		System.out.println(companyFacde.getAllCoupon());
//		Coupon coupon = companyFacde.getCoupon(6);
//		coupon.setAmount(777);
//		companyFacde.updateCoupon(coupon);
//		System.out.println(companyFacde.getAllCoupon());
		
		// Remove Company also remove all of its coupons from DB
//		AdminFacade adminFacade = (AdminFacade) couponSystem.login("admin", "1234", ClientType.ADMIN);
//		System.out.println(adminFacade.getCompany(2));
//		adminFacade.removeCompany(adminFacade.getCompany(2));
		
				

	}

}
