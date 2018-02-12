package com.DBDAO;

import java.util.Collection;

import com.entities.Company;
import com.entities.Coupon;

public interface CompanyDAO {

	void createCompany(Company company);

	void removeCompany(Company company);

	void updateCompany(Company company);

	Company getCompany(long id);

	Collection<Company> getAllCompanies();

	Collection<Coupon> getCoupons();

	boolean login(String compName, String password);

}
