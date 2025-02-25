package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CouponsAddPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UsersPage;
import testBase.BaseClass;

public class TC030_EmployeeAddTest extends BaseClass{

	@Test()
	public void employeeAdd() {

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
			usersPage.clickEmployeeBtn();
			usersPage.setName(p.getProperty("employeeName"));
			usersPage.setEmail(p.getProperty("employeeEmail"));
			usersPage.setPhone(p.getProperty("employeePhone"));
			usersPage.activeBtn();
			usersPage.setPassword(p.getProperty("password"));
			usersPage.setPasswordConfirmation(p.getProperty("confirmPassword"));
			usersPage.allBranchBtn();
			usersPage.clickEmployeeDropDown();
			usersPage.clickEmployeeSelect();

			// Coupons Page
			CouponsAddPage couponsPage = new CouponsAddPage(driver);
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
	}
}