package com.DBDAO;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Coupon;
import com.entities.Customer;
import com.exceptions.WrongPasswordOrUserNameOrClientType;
import com.repository.CouponRepository;
import com.repository.CustomerRepository;

@Component
public class CustomerDBDAO implements CustomerDAO {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	CouponRepository couponRepo;

	@Override
	public boolean login(String custName, String password) {

		for (Customer customer : getAllCustomer()) {
			if (customer.getCustName().equals(custName) && (customer.getPassword().equals(password))) {
				return true;
			}
		}
		throw new WrongPasswordOrUserNameOrClientType(" *********   worng UserName / Password / ClientType  .........");
	}

	@Override
	public void createCustomer(Customer customer) {
		customerRepo.save(customer);
	}

	@Override
	public void removeCustomer(Customer customer) {
		customerRepo.delete(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerRepo.save(customer);
	}

	@Override
	public Customer getCustomerId(long id) {
		return customerRepo.findOne(id);
	}

	@Override
	public Collection<Customer> getAllCustomer() {
		return (Collection<Customer>) customerRepo.findAll();
	}

	@Override
	public Collection<Coupon> getCoupons() {
		return (Collection<Coupon>) couponRepo.findAll();
	}

}
