package com.test;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.common.*;
import com.entities.Coupon;
import com.entrance.CouponSystem;
import com.facade.CompanyFacade;

@Component
public class CreateCouponsToCompanies {

	@Autowired
	CouponSystem couponSystem;	
	

	public void createCoupons() {
		
		/*
		 *  CoffeeCoffee  coupons
		 */
		CompanyFacade companyFacade = (CompanyFacade) couponSystem.login("CoffeCoffe", "123123", ClientType.COMPANY);

		Date d1 = new Date(2018 - 1900, 0, 27);
		Date d2 = new Date(2018 - 1900, 2, 1);
		Date d3 = new Date(2018 - 1900, 2, 5);

		CouponType couponType = null;

		Coupon cfcfBreakfastforOne = new Coupon("Breakfast", d1, null, 50, couponType.RESTURANTS,
				"Breakfast for one person", 65, null, null);
		companyFacade.createCoupon(cfcfBreakfastforOne);
		Coupon cfcfBreakfastForTwo = new Coupon("lunch", d2, null, 20, couponType.RESTURANTS, "lunch for two persons",
				105, null, null);
		companyFacade.createCoupon(cfcfBreakfastForTwo);
		Coupon cfcfDinner = new Coupon("dinner", d3, null, 20, couponType.RESTURANTS, "Dinner for two", 125, null,
				null);
		companyFacade.createCoupon(cfcfDinner);
		
		
		/*
		 *  AROMA  coupons
		 */

		CompanyFacade companyFacade1 = (CompanyFacade) couponSystem.login("Aroma", "456456", ClientType.COMPANY);
		
		Coupon aromaBreakfastforOne = new Coupon("aroma", null, null, 30, CouponType.RESTURANTS,
				"Aroma Brekfast for one person", 69, null, null);
		companyFacade1.createCoupon(aromaBreakfastforOne);
		Coupon aromaBreakfastForTwo = new Coupon("Aroma breakfast for 2", null, null, 75, CouponType.RESTURANTS,
				"Aroma Brekfast for two ", 129, null, null);
		companyFacade1.createCoupon(aromaBreakfastForTwo);
		Coupon aromaDinner = new Coupon("Aroma Dinner", null, null, 75, CouponType.RESTURANTS, "Aroma dinner", 229,
				null, null);
		companyFacade1.createCoupon(aromaDinner);
		Coupon aromafamilyDinner = new Coupon("Aroma Family", null, null, 85, CouponType.RESTURANTS,
				"Aroma dinner for family", 399, null, null);
		companyFacade1.createCoupon(aromafamilyDinner);
		Coupon aromaExpress = new Coupon("Aroma express", null, null, 95, CouponType.RESTURANTS, "Aroma express", 159,
				null, null);
		companyFacade1.createCoupon(aromaExpress);


		
		
		
		
	}

}
