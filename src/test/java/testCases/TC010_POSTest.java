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
		Thread.sleep(5000);
		pos.clickAddItemsBtn();
		Thread.sleep(5000);
		pos.setSpecialInstruction(p.getProperty("addInstructions"));
		Thread.sleep(5000);
		pos.clickAddToCartBtn();
		Thread.sleep(5000);
		
		

	}
}
