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
		HomePage homePage = new HomePage(driver);
		homePage.clickLogin();

		// Login Page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(p.getProperty("email"));
		loginPage.setPassword(p.getProperty("password"));
		loginPage.clickLogin();

		// Search Page
		SearchItemsPage searchPage = new SearchItemsPage(driver);
		String getSearchText = p.getProperty("searchItems");
		searchPage.setSearch(getSearchText);
		
		// AddItemsToCartPage
		AddItemsToCartPage addCartPage = new AddItemsToCartPage(driver);
		addCartPage.setSearch();
		addCartPage.setInstructions(p.getProperty("addInstructions"));
		addCartPage.clickAddToCart();
		
		
		
	}
}
