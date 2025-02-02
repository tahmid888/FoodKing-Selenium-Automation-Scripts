package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.EditProfilePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyOrdersPage;
import pageObjects.PaymentGatewayPage;
import testBase.BaseClass;

public class TC008_EditProfileTest extends BaseClass {

	@Test()
	public void editProfile() throws InterruptedException {

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
		
		// Edit Profile Page
		EditProfilePage editProfile = new EditProfilePage(driver);
		editProfile.clickEditProfile();
		editProfile.setFirstName(p.getProperty("updateFirstName"));
		editProfile.setLastName(p.getProperty("updateLastName"));
		editProfile.setEmail(p.getProperty("updateEmail"));
		Thread.sleep(5000);
		editProfile.setPhone(p.getProperty("updatePhone"));
		//editProfile.clickUpdateProfileBtn();
		
		

		

	}
	
	
	
}
