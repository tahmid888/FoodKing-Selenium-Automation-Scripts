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
		HomePage hp = new HomePage(driver);
		hp.clickLogin();

		// Login Page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));

		// Sign Up Page
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		regPage.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//My Orders Page
		MyOrdersPage op = new MyOrdersPage(driver);
		op.clickAccount();
		
		// Change Password Page
		ChangePasswordPage changePassword = new ChangePasswordPage(driver);
		changePassword.clickChangePassword();
		changePassword.setChangePassword(p.getProperty("oldPassword"));
		changePassword.setNewPassword(p.getProperty("newPassword"));
		changePassword.setTypeNewPassword(p.getProperty("retypeNewPassword"));
		//changePassword.clickChangePasswordbtn();

		

	}
}
