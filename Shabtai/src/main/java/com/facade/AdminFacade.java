package com.facade;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DBDAO.CompanyDBDAO;
import com.DBDAO.CustomerDBDAO;
import com.common.ClientType;
import com.entities.Company;
import com.entities.Customer;
import com.exceptions.CompanyAlreadyExistException;
import com.exceptions.CustomerAlreadyExistException;
import com.exceptions.WrongPasswordOrUserNameOrClientType;

@Component
public class AdminFacade implements CouponClientFacade {

	@Autowired
	CompanyDBDAO companyDBDAO;

	@Autowired
	CustomerDBDAO customerDBDAO;

	public AdminFacade() {

	}

	@Override
	public CouponClientFacade login(String name, String password, ClientType clientType) {

		if ((password.equals("1234")) && (name.equals("admin"))) {
			return this;
		}
		throw new WrongPasswordOrUserNameOrClientType(
				" .......  wrong Admin  UserName/Password/ClientType entered ......");
	}

	/*
	 * ========================================================= 
	 * Company methods
	 * =========================================================
	 */

	public void createCompany(Company newCompany) {
		// check if Company already exist
		try {
			checkIfCompanyExistBeforeCreate(newCompany);
			companyDBDAO.createCompany(newCompany);
		} catch (CompanyAlreadyExistException e) {
			e.printStackTrace();
			System.out.println(" \n company " + "\"" + newCompany.getCompName() + "\"" + " .................. already exists.....\n");
		}
	}

	public void removeCompany(Company company) {
		companyDBDAO.removeCompany(company);
	}

	public void updateCompany(Company company) {

		companyDBDAO.updateCompany(company);
	}

	public Company getCompany(long id) {
		return companyDBDAO.getCompany(id);
	}

	public Collection<Company> getAllCompanies() {
		return companyDBDAO.getAllCompanies();
	}

	/*
	 * ========================================================= 
	 * Customer methods
	 * =========================================================
	 */
	public void createCustomer(Customer newCustomer) {

		// check if Customer already exist
		try {
			checkIfCustomerExistBeforeCreate(newCustomer);
			customerDBDAO.createCustomer(newCustomer);
		} catch (CustomerAlreadyExistException e) {
			e.printStackTrace();
			System.out.println("\n customer " + "\"" + newCustomer.getCustName() + "\"" + "  ............... already exists.....\n");
		}
	}

	public void removeCustomer(Customer customer) {
		customerDBDAO.removeCustomer(customer);
	}

	public void updateCustomer(Customer customer) {
		customerDBDAO.updateCustomer(customer);
	}

	public Customer getCustomer(long id) {
		return customerDBDAO.getCustomerId(id);
	}

	public Collection<Customer> getAllCustomer() {
		return customerDBDAO.getAllCustomer();
	}

	/*
	 * ============================================================================
	 * Help methods (non Overriden methods for this class only)
	 * ============================================================================
	 */

	private void checkIfCompanyExistBeforeCreate(Company newCompany) throws CompanyAlreadyExistException {

		Collection<Company> allCompanies = getAllCompanies();
		for (Company companyFromDB : allCompanies) {
			if (companyFromDB.getCompName().equals(newCompany.getCompName())) {
				throw new CompanyAlreadyExistException(
						" company " + "\"" + newCompany.getCompName() + "\"" + " ......... already exist ..... \n");
			}
		}
	}

	private void checkIfCustomerExistBeforeCreate(Customer newCustomer) throws CustomerAlreadyExistException {

		Collection<Customer> allCustomers = getAllCustomer();
		for (Customer customerFromDB : allCustomers) {
			if (customerFromDB.getCustName().equals(newCustomer.getCustName())) {
				throw new CustomerAlreadyExistException(
						" customer " + "\"" + newCustomer.getCustName() + "\"" + " .......... already exist ......... \n");
			}
		}
	}

}
