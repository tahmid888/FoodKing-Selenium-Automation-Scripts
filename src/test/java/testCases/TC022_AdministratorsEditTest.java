package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CouponsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UsersPage;
import testBase.BaseClass;

public class TC022_AdministratorsEditTest extends BaseClass {

	@Test(groups = { "Admin" }, dependsOnMethods = { "testCases.TC021_AdministratorsAddTest.administratorsAdd" })
	public void administratorsEdit() {

		logger.info("***** Starting TC022_AdministratorsEditTest *****");

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
			usersPage.clickAdministrator();
			usersPage.chooseNameToEdit();
			usersPage.setName(p.getProperty("updateAdministratorsName"));
			Thread.sleep(5000);
			// Coupons Page
			CouponsPage couponsPage = new CouponsPage(driver);
			couponsPage.clickSaveBtn();

			// Assert
			String expectedName = usersPage.getNameTxt();
			String originalItemName = "Jensen";
			System.out.println("Extracted Text: " + expectedName);

			Assert.assertNotEquals(expectedName, originalItemName, "Administrators found successfully");

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}

		logger.info("***** Finished TC022_AdministratorsEditTest *****");
	}

}
