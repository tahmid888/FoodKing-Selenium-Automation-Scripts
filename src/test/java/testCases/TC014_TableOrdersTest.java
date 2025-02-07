package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OnlineOrdersPage;
import pageObjects.POSOrdersPage;
import pageObjects.TableOrdersPage;
import testBase.BaseClass;

public class TC014_TableOrdersTest extends BaseClass{

	@Test()
	public void tableOrders() throws InterruptedException {

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
		
		// Table Orders Page(This order will happen based on Dining Table "QR" code )
		TableOrdersPage tableOrdersPage = new TableOrdersPage(driver);
		tableOrdersPage.clickTableOrders();

		// Online Orders
		OnlineOrdersPage onlineOrdersPage = new OnlineOrdersPage(driver);
		//onlineOrdersPage.clickOnlineOrders();
		onlineOrdersPage.clickView();
		//Accept Order will be First Time Only
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
		
		tableOrdersPage.clickAddToken();
		tableOrdersPage.clickTokenName(p.getProperty("tableTokenName"));
		tableOrdersPage.clickTokenSave();
		
		

	}
}
