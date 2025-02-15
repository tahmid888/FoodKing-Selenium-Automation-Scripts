package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CouponsAddPage;
import pageObjects.CouponsEditPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC016_CouponsEditTest extends BaseClass {

	@Test()
	public void editCoupons() throws InterruptedException {

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
			CouponsEditPage couponsEditPage = new CouponsEditPage(driver);
			couponsEditPage.chooseNameToUpdate();
			couponsEditPage.setName(p.getProperty("updateCouponName"));
			couponsEditPage.setCode(p.getProperty("updateCouponCode"));
			couponsPage.clickSaveBtn();
			Thread.sleep(5000);
			
			// Assert
			String expectedName = couponsEditPage.getNameTxt();
			System.out.println("Extracted Text: " + expectedName);
			Assert.assertTrue(expectedName.toLowerCase().contains("auth-2026"));



		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
	}

}
