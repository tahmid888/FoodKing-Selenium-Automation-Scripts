package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test()
	public void registrationOnAccount() throws InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.clickLogin();

		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);

		regPage.clickSignupLink();
		regPage.setMobileNumber(p.getProperty("mobileNumber"));
		regPage.clickNext();
		Thread.sleep(5000);
		String toastText = regPage.getToastNotification();
		System.out.println("Toast Message: " + toastText);
		// Assert.assertTrue(toastText.contains("Please check your phone for the code.")
		// || toastText.contains("Please check your phone for the code."), "Toast
		// message validation failed!");

		regPage.setFirstName(p.getProperty("firstName"));
		regPage.setLastName(p.getProperty("lastName"));
		regPage.setEmail(p.getProperty("email"));
		regPage.setPassword(p.getProperty("password"));
		regPage.clickSignupBtn();
		Thread.sleep(3000);
	}
}
