package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.CouponsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UsersPage;
import testBase.BaseClass;

public class TC027_CustomerAddTest extends BaseClass {
	
	@Test(groups = {"Master", "Customer" })
	public void customerAdd() {
		
		logger.info("***** Starting TC027_CustomerAddTest *****");
		
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
			usersPage.clickCustomerBtn();
			usersPage.setName(p.getProperty("customerName"));
			usersPage.setEmail(p.getProperty("customerEmail"));
			usersPage.setPhone(p.getProperty("customerPhone"));
			usersPage.activeBtn();
			usersPage.setPassword(p.getProperty("password"));
			usersPage.setPasswordConfirmation(p.getProperty("confirmPassword"));

			// Coupons Page
			CouponsPage couponsPage = new CouponsPage(driver);
			couponsPage.clickSaveBtn();

			// Assert
			String expectedName = usersPage.getNameTxt();
			String originalItemName = "Elon Musk";
			System.out.println("Extracted Text: " + expectedName);

			Assert.assertEquals(expectedName, originalItemName, "Customers wasn't found successfully");

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
		
		logger.info("***** Finished TC027_CustomerAddTest *****");
	}

}