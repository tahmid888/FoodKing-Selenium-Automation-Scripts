package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CouponDeletePage;
import pageObjects.CouponsAddPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OffersAddPage;
import pageObjects.OffersDeletePage;
import pageObjects.OffersEditPage;
import testBase.BaseClass;

public class TC020_OffersDeleteTest extends BaseClass {

	
	@Test()
	public void offersDelete() {

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

			// Offers Add Page
			OffersAddPage offersAddPage = new OffersAddPage(driver);
			offersAddPage.clickOffers();

			// Offers Delete Page
			OffersDeletePage offersDeletePage = new OffersDeletePage(driver);
			offersDeletePage.chooseNameToDelete();
			
			// Coupon Delete Page
			CouponDeletePage couponDeletePage = new CouponDeletePage(driver);
			couponDeletePage.deleteBtn();
			
			
			// Assert
			String expectedName = offersDeletePage.getNameTxt();
			String originalItemName = "Offer-2026";
			System.out.println("Extracted Text: " + expectedName);

			
			Assert.assertEquals(expectedName, originalItemName,"Item was deleted successfully"); 
			

			
		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
	}

}
