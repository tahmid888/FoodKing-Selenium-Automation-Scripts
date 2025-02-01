package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyOrdersPage;
import pageObjects.PaymentGatewayPage;
import testBase.BaseClass;

public class TC007_PaymentGatewayTest extends BaseClass{

	
	
	@Test()
	public void payNow() throws InterruptedException {

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
		
		
		//Payment Gateway Page
		PaymentGatewayPage paymentpage = new PaymentGatewayPage(driver);
		
		paymentpage.clickPayNow();
		paymentpage.clickStripe();
		Thread.sleep(5000);
		paymentpage.enterCardDetails("4242424242424242", "12/25", "12312312");  // Enter test card details
		//paymentpage.clickConfirm(); // Confirm the payment
		
		
		

		

	}
}
