package com.facade;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DBDAO.CompanyDBDAO;
import com.DBDAO.CouponDBDAO;
import com.common.ClientType;
import com.common.CouponType;
import com.entities.Company;
import com.entities.Coupon;
import com.exceptions.CouponAlreadyExistException;

@Component
public class CompanyFacade implements CouponClientFacade {

	@Autowired
	CouponDBDAO couponDBDAO;

	@Autowired
	CompanyDBDAO companyDBDAO;

	private long companyId;	

	public CompanyFacade() {

	}

	@Override
	public CouponClientFacade login(String name, String password, ClientType clientType) {

		Collection<Company> companies = companyDBDAO.getAllCompanies();

		if (clientType == ClientType.COMPANY) {
			if (companyDBDAO.login(name, password) == true) {
				for (Company company : companies) {
					if ((name.equals(company.getCompName()))) {
						companyId = company.getId();
						return this;
					}
				}
			}
		}
		// should make here an exception
		return null;

	}

	public void createCoupon(Coupon newCoupon) {

		Company company = companyDBDAO.getCompany(companyId);
		Collection<Coupon> coupons = companyDBDAO.getCompany(companyId).getCoupons();

		for (Coupon couponDB : coupons) {
			if (couponDB.getTitle().equals(newCoupon.getTitle())) {
				throw new CouponAlreadyExistException(
						" Coupon " + "\"" + newCoupon.getTitle() + "\"" + " already exist ........... ");
			}
		}
		coupons.add(newCoupon);
		company.setCoupons(coupons);
		companyDBDAO.updateCompany(company);
	}

	public void removeCoupon(Coupon coupon) {
		
		Collection<Coupon> coupons = companyDBDAO.getCompany(companyId).getCoupons();

		for (Coupon couponDB : coupons) {
			if (couponDB.getTitle().equals(coupon.getTitle())) {
				couponDBDAO.removeCoupon(couponDB);
			}
		}
	}

	public void updateCoupon(Coupon coupon) {
		
		Collection<Coupon> coupons = companyDBDAO.getCompany(companyId).getCoupons();
		
		for (Coupon couponDB : coupons) {
			if (couponDB.getTitle().equals(coupon.getTitle())) {
				couponDBDAO.updateCoupon(coupon);				
			}
		}
	}

	public Coupon getCoupon(long id) {			
		return couponDBDAO.getCoupon(id);
	}

	public Collection<Coupon> getAllCoupon() {
		return companyDBDAO.getCompany(companyId).getCoupons();
	}

	public Collection<Coupon> getCouponByType(CouponType couponType) {
		return couponDBDAO.getCouponByType(couponType);
	}

}
