package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CouponsAddPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OffersAddPage;
import testBase.BaseClass;

public class TC018_OffersAddTest extends BaseClass{
	
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


			// Offers Page
			OffersAddPage offersAddPage = new OffersAddPage(driver);
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
			CouponsAddPage couponsPage = new CouponsAddPage(driver);
			couponsPage.clickSaveBtn();
			
			
			// Assert
			String expectedName = offersAddPage.getNameTxt();
			Assert.assertTrue(expectedName.contains("Offer-2025"), "Offer name 'Offer-2025' is not found in the extracted text!");

			
			
			
		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace(); 
            Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
	}

}
