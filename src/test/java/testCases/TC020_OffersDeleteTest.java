package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CouponsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OffersPage;
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

			// Offers Page
			OffersPage offersPage = new OffersPage(driver);
			offersPage.clickOffers();
			offersPage.chooseNameToDelete();

			// Coupon Delete Page
			CouponsPage couponsPage = new CouponsPage(driver);
			couponsPage.deleteBtn();

			// Assert
			String expectedName = offersPage.getNameTxt();
			String originalItemName = "Offer-2026";
			System.out.println("Extracted Text: " + expectedName);

			Assert.assertEquals(expectedName, originalItemName, "Item was deleted successfully");

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
	}

}
