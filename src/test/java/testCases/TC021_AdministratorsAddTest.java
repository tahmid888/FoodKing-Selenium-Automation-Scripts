package testCases;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageObjects.CouponsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UsersPage;
import testBase.BaseClass;

public class TC021_AdministratorsAddTest extends BaseClass {
	
	@Test(groups= {"Master","Admin" })
	public void administratorsAdd() {
		
		logger.info("***** Starting TC021_AdministratorsAddTest *****");
		

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

			Assert.assertEquals(expectedName, originalItemName, "Administrators wasn't found successfully");

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			//logger.error("Test failed due to an exception: " + e.getMessage(), e);
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
		
		logger.info("***** Finished TC021_AdministratorsAddTest *****");
	}

}
