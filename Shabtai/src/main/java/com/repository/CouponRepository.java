package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.common.CouponType;
import com.entities.Coupon;

import java.util.List;

public interface CouponRepository extends CrudRepository<Coupon, Long>{

	List<Coupon> findByType(CouponType type);
	
	
	
}

