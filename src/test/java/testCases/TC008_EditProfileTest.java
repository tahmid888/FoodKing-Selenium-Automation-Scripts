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
		HomePage homePage = new HomePage(driver);
		homePage.clickLogin();

		// Login Page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(p.getProperty("email"));
		loginPage.setPassword(p.getProperty("password"));
		loginPage.clickLogin();
		homePage.clickAccount();
		
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
