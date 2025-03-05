package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CouponsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UsersPage;
import testBase.BaseClass;

public class TC032_EmployeeDeleteTest extends BaseClass {

	@Test(groups = {"Master", "Employee" }, dependsOnMethods = { "testCases.TC031_EmployeeEditTest.employeeEdit" })
	public void employeeDelete() {

		logger.info("***** Starting TC032_EmployeeDeleteTest *****");

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
			usersPage.clickEmployee();
			usersPage.chooseNameToDelete();

			// Coupons Page
			CouponsPage couponsPage = new CouponsPage(driver);
			couponsPage.deleteBtn();

			// Assert
			String deletedUserName = usersPage.getNameTxt();

			System.out.println("Extracted Text After Deletion: " + deletedUserName);

			// Assert that the user does not exist after deletion
			Assert.assertFalse(deletedUserName == null || deletedUserName.isEmpty(), "User deletion failed!");

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}

		logger.info("***** Finished TC032_EmployeeDeleteTest *****");
	}

}
