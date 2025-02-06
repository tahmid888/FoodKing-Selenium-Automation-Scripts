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
		HomePage homePage = new HomePage(driver);
		homePage.clickLogin();

		// Login Page
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(p.getProperty("adminEmail"));
		loginPage.setPassword(p.getProperty("adminPassword"));
		loginPage.clickLogin();
		homePage.clickAccount();
		
		// POS Page
		POSPage posPage = new POSPage(driver);
		
		homePage.clickDashboard();
		posPage.clickPOS();
		posPage.clickAddItemsBtn();
		posPage.setSpecialInstruction(p.getProperty("addInstructions"));
		posPage.clickAddToCartBtn();
		posPage.clickDropDown();
		posPage.clickCustomerDropDown();
		posPage.setToken();
		
		String itemsName = posPage.getItemsText();
		System.out.print("Item Name Is: " +itemsName+"\n");
		
		String itemsSize = posPage.getSizeText();
		System.out.print("Item Size Name Is: " +itemsSize+"\n");
		
		posPage.selectPaymentMethodDropdown();
		posPage.setLastDigitCard(p.getProperty("lastFourDigit"));
		posPage.clickOrderBtn();

		String printOrderId = posPage.getPrintOrderIDTxt();
		System.out.print("Print OrderID: " +printOrderId+"\n");
		
		String printPaymentType = posPage.getPrintPaymentTypeTxt();
		System.out.print("Print PaymentType: " +printPaymentType+"\n");
		
		
//		Thread.sleep(5000);
//		Integer itemsQuantity = pos.getQuantityText();
//		System.out.print("Item Quantity Is: " +itemsQuantity);
		
		
		

	}
}
