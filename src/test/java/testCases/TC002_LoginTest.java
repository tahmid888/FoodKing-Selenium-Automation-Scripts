package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test()
	public void login() throws InterruptedException {
		
		// Home Page
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
		
		// Login Page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		

		// Sign Up
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		regPage.setPassword(p.getProperty("password"));
		
		
		lp.clickLogin();
		Thread.sleep(5000);

	}

}
