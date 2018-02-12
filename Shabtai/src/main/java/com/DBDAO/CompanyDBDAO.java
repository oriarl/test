package com.DBDAO;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Company;
import com.entities.Coupon;
import com.exceptions.WrongPasswordOrUserNameOrClientType;
import com.repository.CompanyRepository;
import com.repository.CouponRepository;

@Component
public class CompanyDBDAO implements CompanyDAO {

	@Autowired
	CompanyRepository companyRepo;

	@Autowired
	CouponRepository couponRepo;

	@Override
	public boolean login(String compName, String password) {
				
		for (Company company : getAllCompanies()) 
		{
			if(company.getCompName().equals(compName) && (company.getPassword().equals(password)) ) {				
				return true;
			}
		}
		throw new WrongPasswordOrUserNameOrClientType(" *********   worng UserName / Password / ClientType  .........");
	}

	@Override
	public void createCompany(Company company) {
		companyRepo.save(company);
	}

	@Override
	public void removeCompany(Company company) {
		companyRepo.delete(company);
	}

	@Override
	public void updateCompany(Company company) {
		companyRepo.save(company);
	}

	@Override
	public Company getCompany(long id) {
		return companyRepo.findOne(id);
	}

	@Override
	public Collection<Company> getAllCompanies() {
		return (Collection<Company>) companyRepo.findAll();
	}

	@Override
	public Collection<Coupon> getCoupons() {
		return (Collection<Coupon>) couponRepo.findAll();
	}

}
