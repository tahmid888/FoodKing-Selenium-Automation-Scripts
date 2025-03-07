package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC033_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class) // Inherited DataProvider

	public void verify_loginDDT(String email, String pwd, String exp) {

		logger.info("***** Starting TC033_LoginDDT *****");

		try {
			// Home Page
			HomePage homePage = new HomePage(driver);
			homePage.clickLogin();

			// Login Page
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(email);
			loginPage.setPassword(pwd);
			loginPage.clickLogin();

			String toasterNoti = loginPage.toaster();
			System.out.println("Notification Is: " + toasterNoti);

			// Assert that the toaster notification contains the expected text
			Assert.assertTrue(toasterNoti.contains("Login Successfully"),
					"Toaster notification text mismatch. Expected: 'Login Successfully', Actual: " + toasterNoti);

			
		} catch (Exception e) {

			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());
		}
		logger.info("***** Finished TC033_LoginDDT *****");

	}

}
