package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CouponsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OffersPage;
import testBase.BaseClass;

public class TC019_OffersEditTest extends BaseClass {

	@Test()
	public void addOffers() {

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
			offersPage.chooseNameToUpdate();
			offersPage.setName(p.getProperty("updateOfferName"));
			offersPage.setDiscountPercentage(p.getProperty("updateOfferDiscountPercentage"));

			// Coupons Add Page
			CouponsPage couponsPage = new CouponsPage(driver);
			couponsPage.clickSaveBtn();

			// Assert
			String expectedName = offersPage.getNameTxt();
			System.out.println("Extracted Text: " + expectedName);

			Assert.assertTrue(expectedName.toLowerCase().contains("offer-"));

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
	}

}
