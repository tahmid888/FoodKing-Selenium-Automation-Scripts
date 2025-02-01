package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.AddItemsToCartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProceedToCheckoutPage;
import pageObjects.SearchItemsPage;
import testBase.BaseClass;

public class TC005_ProceedToCheckoutTest extends BaseClass {

	@Test()
	public void checkOut() throws InterruptedException {

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

		// Search Page
		SearchItemsPage sp = new SearchItemsPage(driver);
		String getSearchText = p.getProperty("searchItems");
		sp.setSearch(getSearchText);
		Thread.sleep(5000);
		// AddItemsToCartPage
		AddItemsToCartPage acp = new AddItemsToCartPage(driver);
		acp.setSearch();
		acp.setInstructions(p.getProperty("addInstructions"));

		acp.clickAddToCart();

		Thread.sleep(5000);
		ProceedToCheckoutPage pcp = new ProceedToCheckoutPage(driver);
		pcp.clickMyCart();
		pcp.clickTakeaway();
		Thread.sleep(5000);
		pcp.clickProceedToCheckout();
		pcp.clickPlaceOrder();
		Thread.sleep(5000);

	}

}
