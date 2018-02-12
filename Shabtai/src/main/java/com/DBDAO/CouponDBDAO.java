package com.DBDAO;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.common.CouponType;
import com.entities.Coupon;
import com.repository.CouponRepository;

@Component
public class CouponDBDAO implements CouponDAO {
	
	@Autowired
	CouponRepository couponRepo;

	@Override
	public void createCoupon(Coupon coupon) {		
		couponRepo.save(coupon);
	}

	@Override
	public void removeCoupon(Coupon coupon) {
		couponRepo.delete(coupon);
	}

	@Override
	public void updateCoupon(Coupon coupon) {
		couponRepo.save(coupon);
	}

	@Override
	public Coupon getCoupon(long id) {
		return couponRepo.findOne(id);		
	}

	@Override
	public Collection<Coupon> getAllCoupon() {
		return (Collection<Coupon>) couponRepo.findAll();
	}

	@Override
	public Collection<Coupon> getCouponByType(CouponType couponType) {		
//		Collection<Coupon> coupons = couponRepo.findByType(couponType);
//		for (Coupon coupon : coupons) {
//			System.out.println(coupon.getTitle());		 	
//		}		
		return couponRepo.findByType(couponType);			
	}
	
}
