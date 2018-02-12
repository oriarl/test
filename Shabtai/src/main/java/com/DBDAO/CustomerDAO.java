package com.DBDAO;

import java.util.Collection;

import com.entities.Coupon;
import com.entities.Customer;

public interface CustomerDAO {

	void createCustomer(Customer customer);

	void removeCustomer(Customer customer);

	void updateCustomer(Customer customer);

	Customer getCustomerId(long id);

	Collection<Customer> getAllCustomer();

	Collection<Coupon> getCoupons();

	boolean login(String custName, String password);

}
