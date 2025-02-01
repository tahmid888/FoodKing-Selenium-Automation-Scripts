package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.AddItemsToCartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyOrdersPage;
import pageObjects.ProceedToCheckoutPage;
import pageObjects.SearchItemsPage;
import testBase.BaseClass;

public class TC006_MyOrdersTest extends BaseClass {

	
	@Test()
	public void myOrders() throws InterruptedException {

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
		op.clickMyOrders();
		op.clickSeeDetails();
		Thread.sleep(5000);
		 String orderId = op.getOrderId();
		 System.out.println("Order ID: "+orderId);
		 String orderType = op.getOrderType();
		 System.out.println("Order Type: "+orderType);
		
		Thread.sleep(5000);
		

		

	}

	
	
}
