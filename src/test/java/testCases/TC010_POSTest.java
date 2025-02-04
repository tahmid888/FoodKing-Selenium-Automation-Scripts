package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyOrdersPage;
import pageObjects.POSPage;
import pageObjects.SearchItemsPage;
import testBase.BaseClass;

public class TC010_POSTest extends BaseClass {

	@Test()
	public void pos() throws InterruptedException {

		// Home Page
		HomePage hp = new HomePage(driver);
		hp.clickLogin();

		// Login Page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("adminEmail"));
		lp.setPassword(p.getProperty("adminPassword"));
		lp.clickLogin();

		// My Orders Page
		MyOrdersPage op = new MyOrdersPage(driver);
		op.clickAccount();
		
		// POS Page
		POSPage pos = new POSPage(driver);
		
		pos.clickDashboard();
		pos.clickPOS();
		pos.clickAddItemsBtn();
		pos.setSpecialInstruction(p.getProperty("addInstructions"));
		pos.clickAddToCartBtn();
		Thread.sleep(5000);
		pos.clickDropDown();
		pos.clickCustomerDropDown();
		pos.setToken();
		String ss = pos.getItemsText();
		System.out.print("Item Name Is: " +ss);
		Thread.sleep(5000);
		
		

	}
}
