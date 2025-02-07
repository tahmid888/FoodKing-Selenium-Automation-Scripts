package testCases;

import org.testng.annotations.Test;

import pageObjects.DeletePOSOrdersPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.POSOrdersPage;
import testBase.BaseClass;

public class TC012_DeletePOSOrdersTest extends BaseClass{

	@Test()
	public void deletePosOrders() throws InterruptedException {

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
	
		// Delete POS Oder Page
		DeletePOSOrdersPage deletePosOrdersPage = new DeletePOSOrdersPage(driver);
		deletePosOrdersPage.clickDeletePOSOrders();
		deletePosOrdersPage.clickDeleteYesPOSOrders();
		
		
		
		

	}
	
	
}
