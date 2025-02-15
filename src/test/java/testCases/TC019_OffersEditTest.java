package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CouponsAddPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OffersAddPage;
import pageObjects.OffersEditPage;
import testBase.BaseClass;

public class TC019_OffersEditTest extends BaseClass {

	@Test()
public void addOffers() throws InterruptedException {

		
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
			
			// Offer Edit Page
			OffersEditPage offersEditPage = new OffersEditPage(driver);
			offersEditPage.chooseNameToUpdate();
			offersEditPage.setName(p.getProperty("updateOfferName"));
			offersEditPage.setDiscountPercentage(p.getProperty("updateOfferDiscountPercentage"));
			
			// Coupons Add Page
			CouponsAddPage couponsPage = new CouponsAddPage(driver);
			couponsPage.clickSaveBtn();
			
			Thread.sleep(5000);
			// Assert
			String expectedName = offersEditPage.getNameTxt();
			System.out.println("Extracted Text: " + expectedName);

			Assert.assertTrue(expectedName.toLowerCase().contains("offer-2026"));

			
			
			
		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace(); 
            Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
	}

}
