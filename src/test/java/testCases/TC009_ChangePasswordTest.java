package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.ChangePasswordPage;
import pageObjects.EditProfilePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyOrdersPage;
import testBase.BaseClass;

public class TC009_ChangePasswordTest extends BaseClass{

	
	
	@Test()
	public void changePassword() throws InterruptedException {

		// Home Page
		HomePage homePage = new HomePage(driver);
		homePage.clickLogin();

		// Login Page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(p.getProperty("email"));
		loginPage.setPassword(p.getProperty("password"));
		loginPage.clickLogin();
		homePage.clickAccount();
		
		// Change Password Page
		ChangePasswordPage changePassword = new ChangePasswordPage(driver);
		changePassword.clickChangePassword();
		changePassword.setChangePassword(p.getProperty("oldPassword"));
		changePassword.setNewPassword(p.getProperty("newPassword"));
		changePassword.setTypeNewPassword(p.getProperty("retypeNewPassword"));
		//changePassword.clickChangePasswordbtn();

		

	}
}
