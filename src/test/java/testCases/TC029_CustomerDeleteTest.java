package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CouponsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UsersPage;
import testBase.BaseClass;

public class TC029_CustomerDeleteTest extends BaseClass {

	@Test(groups = { "Customer" }, dependsOnMethods = { "testCases.TC028_CustomerEditTest.customerEdit" })
	public void customerDelete() {

		logger.info("***** Starting TC029_CustomerDeleteTest *****");

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

			// UsersPage Page
			UsersPage usersPage = new UsersPage(driver);
			usersPage.clickCustomer();
			usersPage.chooseNameToDelete();

			// Coupons Delete Page
			CouponsPage couponDeletePage = new CouponsPage(driver);
			couponDeletePage.deleteBtn();

			String deletedUserName = usersPage.getNameTxt();

			System.out.println("Extracted Text After Deletion: " + deletedUserName);

			Assert.assertFalse(deletedUserName == null || deletedUserName.isEmpty(), "User deletion failed!");

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
		
		logger.info("***** Finished TC029_CustomerDeleteTest *****");
	}

}
