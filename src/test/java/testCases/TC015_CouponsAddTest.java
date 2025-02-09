package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CouponsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OnlineOrdersPage;
import pageObjects.POSOrdersPage;
import pageObjects.TableOrdersPage;
import testBase.BaseClass;

public class TC015_CouponsAddTest extends BaseClass {

	@Test()
	public void addCoupons() throws InterruptedException {

		
		try {

			// Home Page
			HomePage homePage = new HomePage(driver);
			homePage.clickLogin();

			// Login Page
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(p.getProperty("adminEmail"));
			loginPage.setPassword(p.getProperty("adminPassword"));
			loginPage.clickLogin();
			homePage.clickAccount();
			homePage.clickDashboard();

			// Coupons Page
			CouponsPage couponsPage = new CouponsPage(driver);
			couponsPage.clickCoupon();
			couponsPage.clickAddCoupon();
			Thread.sleep(5000);
			couponsPage.setStartDate();
			Thread.sleep(5000);
			
			
			
		} catch (Exception e) {
			Assert.fail();

		}
	}

}
