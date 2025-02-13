package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CouponDeletePage;
import pageObjects.CouponsAddPage;
import pageObjects.CouponsEditPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC017_CouponDeleteTest extends BaseClass {
	@Test()
	public void deleteCoupons() throws InterruptedException {

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

			// Coupons Add Page
			CouponsAddPage couponsPage = new CouponsAddPage(driver);
			couponsPage.clickCoupon();

			// Coupons Edit Page
			CouponDeletePage couponDeletePage = new CouponDeletePage(driver);
			Thread.sleep(5000);
			couponDeletePage.chooseNameToDelete();
			Thread.sleep(5000);
			
			// Assert
			//String expectedName = couponsEditPage.getNameTxt();
			//Assert.assertNotEquals(expectedName.contains("Auth-2026"),
			//		"Coupon name 'Auth-2026' is NOT found in the extracted text!");

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
	}

}
