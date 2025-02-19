package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CouponDeletePage;
import pageObjects.CouponsAddPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OffersAddPage;
import pageObjects.OffersDeletePage;
import pageObjects.UsersPage;
import testBase.BaseClass;

public class TC021_AdministratorsAddTest extends BaseClass {

	@Test()
	public void administratorsAdd() {

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
			usersPage.clickaddAdministratorBtn();
			usersPage.setName(p.getProperty("administratorsName"));
			usersPage.setEmail(p.getProperty("administratorsEmail"));
			usersPage.setPhone(p.getProperty("administratorsPhone"));
			usersPage.activeBtn();
			usersPage.setPassword(p.getProperty("administratorsPassword"));
			usersPage.setPasswordConfirmation(p.getProperty("administratorsConfirmPassword"));
			usersPage.allBranchBtn();

			// Coupons Page
			CouponsAddPage couponsPage = new CouponsAddPage(driver);
			couponsPage.clickSaveBtn();

			// Assert
			String expectedName = usersPage.getNameTxt();
			String originalItemName = "Elon Musk";
			System.out.println("Extracted Text: " + expectedName);

			Assert.assertEquals(expectedName, originalItemName, "Administrators wasn't found successfully");

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
	}

}
