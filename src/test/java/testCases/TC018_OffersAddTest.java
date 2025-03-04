package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CouponsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OffersPage;
import testBase.BaseClass;

public class TC018_OffersAddTest extends BaseClass {

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

			// Offers Add Page
			OffersPage offersAddPage = new OffersPage(driver);
			offersAddPage.clickOffers();
			offersAddPage.addOffersBtn();
			offersAddPage.setName(p.getProperty("offerName"));
			offersAddPage.setDiscountPercentage(p.getProperty("offerDiscountPercentage"));
			offersAddPage.clickStartDate();
			offersAddPage.clickSDate();
			offersAddPage.clickEndDate();
			offersAddPage.clickEDate();
			offersAddPage.selectFileUpload();

			// Coupons Add Page
			CouponsPage couponsPage = new CouponsPage(driver);
			couponsPage.clickSaveBtn();

			// Assert
			String expectedName = offersAddPage.getNameTxt();
			Assert.assertTrue(expectedName.toLowerCase().contains("offer-2025"));

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
	}

}
