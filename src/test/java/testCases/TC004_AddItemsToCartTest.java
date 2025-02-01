package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.AddItemsToCartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchItemsPage;
import testBase.BaseClass;

public class TC004_AddItemsToCartTest extends BaseClass {

	
	@Test()
	public void addItems() throws InterruptedException {

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

		
		Thread.sleep(5000);
		// Search Page
		SearchItemsPage sp = new SearchItemsPage(driver);
		String getSearchText = p.getProperty("searchItems");
		sp.setSearch(getSearchText);
		
		// AddItemsToCartPage
		AddItemsToCartPage acp = new AddItemsToCartPage(driver);
		acp.setSearch();
		Thread.sleep(5000);
		acp.setInstructions(p.getProperty("addInstructions"));
		Thread.sleep(5000);
		acp.clickAddToCart();
		
		
		
	}
}
