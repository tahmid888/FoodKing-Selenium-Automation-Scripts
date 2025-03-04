package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CouponsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UsersPage;
import testBase.BaseClass;

public class TC024_DeliveryBoyAddTest extends BaseClass {

	@Test(groups = { "DeliveryBoy" })
	public void deliveryBoyAdd() {

		logger.info("***** Starting TC024_DeliveryBoyAddTest *****");

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
			usersPage.clickDeliveryBoy();
			usersPage.clickaddDeliveryBoyBtn();
			usersPage.setName(p.getProperty("deliveryBoyName"));
			usersPage.setEmail(p.getProperty("deliveryBoyEmail"));
			usersPage.setPhone(p.getProperty("deliveryBoyPhone"));
			usersPage.activeBtn();
			usersPage.setPassword(p.getProperty("password"));
			usersPage.setPasswordConfirmation(p.getProperty("confirmPassword"));
			usersPage.allBranchBtn();

			// Coupons Page
			CouponsPage couponsPage = new CouponsPage(driver);
			couponsPage.clickSaveBtn();

			// Assert
			String expectedName = usersPage.getNameTxt();
			String originalItemName = "Elon Musk";
			System.out.println("Extracted Text: " + expectedName);

			Assert.assertEquals(expectedName, originalItemName, "Delivery Boys wasn't found successfully");

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}

		logger.info("***** Finished TC024_DeliveryBoyAddTest *****");
	}

}