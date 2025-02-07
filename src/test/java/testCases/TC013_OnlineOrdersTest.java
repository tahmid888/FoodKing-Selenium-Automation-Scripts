package testCases;

import org.testng.annotations.Test;

import pageObjects.DeletePOSOrdersPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OnlineOrdersPage;
import pageObjects.POSOrdersPage;
import testBase.BaseClass;

public class TC013_OnlineOrdersTest extends BaseClass{
	
	@Test()
	public void onlineOrders() throws InterruptedException {

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

		// Online Orders
		OnlineOrdersPage onlineOrdersPage = new OnlineOrdersPage(driver);
		onlineOrdersPage.clickOnlineOrders();
		Thread.sleep(5000);
		onlineOrdersPage.clickView();
		
		// Accept Order will be First Time Only
		//onlineOrdersPage.clickAcceptOrders();
		//onlineOrdersPage.clickYesAcceptOrders();
		
		// POS Orders Page
		POSOrdersPage posOrdersPage = new POSOrdersPage(driver);
		
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
