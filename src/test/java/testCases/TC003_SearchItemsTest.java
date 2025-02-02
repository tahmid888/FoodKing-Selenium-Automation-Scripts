package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchItemsPage;
import testBase.BaseClass;

public class TC003_SearchItemsTest extends BaseClass {

	@Test()
	public void search() throws InterruptedException {

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

		// Search Page
		SearchItemsPage sp = new SearchItemsPage(driver);

		String getSearchText = p.getProperty("searchItems");
		sp.setSearch(getSearchText);

		System.out.println("Searching Text :" + getSearchText);

		Assert.assertEquals("Burger", getSearchText);

		Thread.sleep(5000);

	}
}
