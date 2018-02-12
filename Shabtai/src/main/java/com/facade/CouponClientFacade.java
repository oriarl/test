package com.facade;

import com.common.ClientType;

public interface CouponClientFacade {
	
	CouponClientFacade login(String name, String password, ClientType clientType);

}
