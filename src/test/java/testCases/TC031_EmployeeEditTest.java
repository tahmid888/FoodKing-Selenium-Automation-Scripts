package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CouponsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UsersPage;
import testBase.BaseClass;

public class TC031_EmployeeEditTest extends BaseClass {

	@Test(groups = {"Master", "Employee" }, dependsOnMethods = { "testCases.TC030_EmployeeAddTest.employeeAdd" })
	public void employeeEdit() {

		logger.info("***** Starting TC031_EmployeeEditTest *****");

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
			usersPage.chooseNameToEdit();
			usersPage.setName(p.getProperty("updateEmployeeName"));
			Thread.sleep(5000);

			// Coupons Page
			CouponsPage couponsPage = new CouponsPage(driver);
			couponsPage.clickSaveBtn();

			// Assert
			String expectedName = usersPage.getNameTxt();
			String originalItemName = "Elon Musk";
			System.out.println("Extracted Text: " + expectedName);

			Assert.assertEquals(expectedName, originalItemName, "Employee wasn't found successfully");

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
		logger.info("***** Finished TC031_EmployeeEditTest *****");
	}
}
