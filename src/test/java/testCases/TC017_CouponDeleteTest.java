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

			// Coupons Delete Page
			CouponDeletePage couponDeletePage = new CouponDeletePage(driver);
			couponDeletePage.chooseNameToDelete();
			couponDeletePage.deleteBtn();
			
			// Assert
			String expectedName = couponDeletePage.getNameTxt();
			Assert.assertFalse(expectedName.contains("Auth-2026"),
				    "Coupon name 'Auth-2026' is still found in the extracted text after deletion!");


		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
	}

}
