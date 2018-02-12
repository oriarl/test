package com.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DBDAO.CompanyDBDAO;
import com.DBDAO.CouponDBDAO;
import com.DBDAO.CustomerDBDAO;
import com.common.ClientType;
import com.common.CouponType;
import com.entities.Coupon;
import com.entities.Customer;

@Component
public class CustomerFacade implements CouponClientFacade {

	@Autowired
	CouponDBDAO couponDBDAO;

	@Autowired
	CustomerDBDAO customerDBDAO;
	
	@Autowired
	CompanyDBDAO companyDBDAO;

	private long id;

	public CustomerFacade() {

	}

	@Override
	public CouponClientFacade login(String name, String password, ClientType clientType) {

		Collection<Customer> customers = customerDBDAO.getAllCustomer();

		if (clientType == ClientType.CUSTOMER) {
			if (customerDBDAO.login(name, password) == true) {
				for (Customer customer : customers) {
					if ((name.equals(customer.getCustName()))) {
						id = customer.getId();
						return this;
					}
				}
			}
		}
		// should make here an exception
		return null;
	}

	public void purchaseCoupon(Coupon coupon) {
				
		Customer customerPurchasingCouping = customerDBDAO.getCustomerId(id);
		Collection<Coupon> coupons = new ArrayList<>();
		coupons.add(coupon);				
		customerPurchasingCouping.setCoupons(coupons);
		customerDBDAO.updateCustomer(customerDBDAO.getCustomerId(id));
		System.out.println(customerPurchasingCouping);		
		
	}

	public void getAllPurchasedCoupons() {

	}

	public void getAllPurchasedCouponsByType(CouponType couponType) {

	}

	public void getAllPurchasedCouponsByPrice(double price) {

	}

}
