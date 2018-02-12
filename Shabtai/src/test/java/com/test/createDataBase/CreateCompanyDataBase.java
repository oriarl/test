package com.test.createDataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.common.ClientType;
import com.entities.Company;
import com.entrance.CouponSystem;
import com.facade.AdminFacade;

@Component
public class CreateCompanyDataBase {

	@Autowired
	CouponSystem couponSystem;

	public void createDataBase() {

		/*
		 * Login to CouponSystem with admin , create Companies and add them DB
		 */
		AdminFacade adminFacade = (AdminFacade) couponSystem.login("admin", "1234", ClientType.ADMIN);

		/*
		 * create RESTURANTS
		 */
		Company coffeeCoffee = new Company("CoffeCoffe", "123123", "coffeecoffee@gmail.com");
		adminFacade.createCompany(coffeeCoffee);

		Company aroma = new Company("Aroma", "456456", "aroma@gmail.com");
		adminFacade.createCompany(aroma);

		Company bistro56 = new Company("Bistro56", "789789", "Bistro56@gmail.com");
		adminFacade.createCompany(bistro56);

		/*
		 * create FOOD
		 */
		Company mega = new Company("mega", "mg1245", "mega@gamil.com");
		adminFacade.createCompany(mega);

		Company shufersal = new Company("shufersal", "sf876", "shufersal@gamil.com");
		adminFacade.createCompany(shufersal);

		Company hatsiHinam = new Company("hatsiHinam", "9865df", "hatsiHinam@gamil.com");
		adminFacade.createCompany(hatsiHinam);

		Company ramiLevi = new Company("ramiLevi", "rl876", "ramiLevi@gamil.com");
		adminFacade.createCompany(ramiLevi);

		Company market = new Company("market", "mark109", "market@gamil.com");
		adminFacade.createCompany(market);

		/*
		 * create ELECTRICITY
		 */

		Company alam = new Company("alam", "alam145", "alam@gamil.com");
		adminFacade.createCompany(alam);

		Company shekemelectric = new Company("shekemelectric", "sf876", "shufersal@gamil.com");
		adminFacade.createCompany(shekemelectric);

		Company sofer = new Company("sofer", "98sf5df", "sofer@gamil.com");
		adminFacade.createCompany(sofer);

		Company elect = new Company("elect", "rt5876", "elect@gamil.com");
		adminFacade.createCompany(elect);

		Company mediamarket = new Company("mediamarket", "marketrk109", "mediamarket@gamil.com");
		adminFacade.createCompany(mediamarket);

		/*
		 * HEALTH
		 */

		Company spa = new Company("spa", "spa1256", "spa@gamil.com");
		adminFacade.createCompany(spa);

		Company spahilton = new Company("spahilton", "sf876", "spahilton@gamil.com");
		adminFacade.createCompany(spahilton);

		Company spadavidcontinental = new Company("spadavidcontinental", "91235df", "spadavidcontinental@gamil.com");
		adminFacade.createCompany(spadavidcontinental);

		Company tsimer = new Company("tsimer", "rgt6776", "tsimer@gamil.com");
		adminFacade.createCompany(tsimer);

		Company hoteldan = new Company("hoteldan", "dan109", "hoteldan@gamil.com");
		adminFacade.createCompany(hoteldan);

		/*
		 * SPORTS
		 */
		Company megaSport = new Company("megaSport", "mgs777", "megaSport@gamil.com");
		adminFacade.createCompany(megaSport);

		Company alufHaport = new Company("alufHaport", "alf876", "alufHaport@gamil.com");
		adminFacade.createCompany(alufHaport);

		Company adidas = new Company("adidas", "91ju8df", "adidas@gamil.com");
		adminFacade.createCompany(adidas);

		Company nike = new Company("nike", "rgnike986", "nike@gamil.com");
		adminFacade.createCompany(nike);

		Company diadora = new Company("diadora", "dia0909", "diadora@gamil.com");
		adminFacade.createCompany(diadora);

		/*
		 * TRAVELLING
		 */

		Company ista = new Company("ista", "ista777", "ista@gamil.com");
		adminFacade.createCompany(ista);

		Company elal = new Company("elal", "elal876", "elal@gamil.com");
		adminFacade.createCompany(elal);

		Company israir = new Company("israir", "9000u8df", "israir@gamil.com");
		adminFacade.createCompany(israir);

	}

}
