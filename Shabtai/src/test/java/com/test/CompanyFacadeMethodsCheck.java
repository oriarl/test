package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.common.ClientType;
import com.entities.Coupon;
import com.entrance.CouponSystem;
import com.facade.CompanyFacade;

@Component
public class CompanyFacadeMethodsCheck {

	@Autowired
	CouponSystem couponSystem;

	public void createCoupon() {

		CompanyFacade companyFacde = (CompanyFacade) couponSystem.login("Aroma", "456456", ClientType.COMPANY);

		Coupon testCoupon = new Coupon("test", null, null, 777, null, "testing create coupon", 0, null, null);
		companyFacde.createCoupon(testCoupon);

	}

	public void removeCoupon() {

		CompanyFacade companyFacde = (CompanyFacade) couponSystem.login("Aroma", "456456", ClientType.COMPANY);

		System.out.println(companyFacde.getAllCoupon());
		Coupon coupon = companyFacde.getCoupon(6);
		companyFacde.removeCoupon(coupon);
		System.out.println(companyFacde.getAllCoupon());

	}

	public void updateCoupon() {

		CompanyFacade companyFacde = (CompanyFacade) couponSystem.login("Aroma", "456456", ClientType.COMPANY);

		System.out.println(companyFacde.getAllCoupon());
		Coupon coupon = companyFacde.getCoupon(6);
		coupon.setAmount(777);
		companyFacde.updateCoupon(coupon);
		System.out.println(companyFacde.getAllCoupon());
	}

	public void getCouponById() {

		CompanyFacade companyFacde = (CompanyFacade) couponSystem.login("Aroma", "456456", ClientType.COMPANY);
		Coupon coupon = companyFacde.getCoupon(6);
		System.out.println(coupon);
	}

	public void getAllCoupon() {

		CompanyFacade companyFacde = (CompanyFacade) couponSystem.login("Aroma", "456456", ClientType.COMPANY);
		System.out.println(companyFacde.getAllCoupon());

	}
	
	// need to finish implementation
	public void getCouponByType() {
		CompanyFacade companyFacde = (CompanyFacade) couponSystem.login("Aroma", "456456", ClientType.COMPANY);
		
	}

}
