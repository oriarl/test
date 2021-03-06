package com.DBDAO;

import java.util.Collection;

import com.common.CouponType;
import com.entities.Coupon;

public interface CouponDAO {

	void createCoupon(Coupon coupon);

	void removeCoupon(Coupon coupon);

	void updateCoupon(Coupon coupon);

	Coupon getCoupon(long id);

	Collection<Coupon> getAllCoupon();

	Collection<Coupon> getCouponByType(CouponType couponType);

}
