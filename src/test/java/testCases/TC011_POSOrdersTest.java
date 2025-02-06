package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyOrdersPage;
import pageObjects.POSOrdersPage;
import pageObjects.POSPage;
import testBase.BaseClass;

public class TC011_POSOrdersTest extends BaseClass {

	@Test()
	public void posOrders() throws InterruptedException {

		// Home Page
		HomePage homePage = new HomePage(driver);
		homePage.clickLogin();

		// Login Page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(p.getProperty("adminEmail"));
		loginPage.setPassword(p.getProperty("adminPassword"));
		loginPage.clickLogin();
		homePage.clickAccount();
		homePage.clickDashboard();

		// POS Order Page
		POSOrdersPage posOrdersPage = new POSOrdersPage(driver);
		posOrdersPage.clickPOSOrders();
		
		String rowOrderId = posOrdersPage.getOrderIdTxt();
		System.out.print("Order ID: "+rowOrderId+'\n');
		Thread.sleep(5000);
		posOrdersPage.clickViewPosOrdersBtn();
		
		// According to the Status
		posOrdersPage.selectPaidPaymentDropDown();
		//posOrdersPage.selectUnpaidPaymentDropDown();
		//posOrdersPage.selectAcceptOrderDropDown();
		//posOrdersPage.selectProcessingOrderDropDown();
		posOrdersPage.selectDeliveredOrderDropDown();
		
		System.out.print("***Delivery Information***" +"\n");
		
		String name  = posOrdersPage.getPosOrdersNameTxt();
		System.out.print("Name : "+name+'\n');
		String email = posOrdersPage.getPosOrdersEmailTxt();
		System.out.print("Email : "+email+'\n');
		String phone = posOrdersPage.getPosOrdersPhoneTxt();
		System.out.print("Phone : "+phone+'\n');
		
		Thread.sleep(5000);
		

	}
}
