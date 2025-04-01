package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DinningTableQRScanPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;


public class TC034_DinningTableQRScanTest extends BaseClass {

	@Test()
	public void dinningTableQRScan() {

		logger.info("***** Starting TC034_DinningTableQRScanTest *****");

		try {
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

			// Dinning Table QRScan Page
			DinningTableQRScanPage dinningTableQRScan = new DinningTableQRScanPage(driver);
			dinningTableQRScan.clickDinningTable();
			dinningTableQRScan.clickAddTable();
			dinningTableQRScan.setName(p.getProperty("tableName"));
			dinningTableQRScan.setSize(p.getProperty("tableSize"));
			
			//dinningTableQRScan.clickActiveBtn();
			
			dinningTableQRScan.clickSaveBtn();
			Thread.sleep(3000);
			//dinningTableQRScan.clickViewBtn();
			dinningTableQRScan.chooseNameToView(p.getProperty("tableName"));
			Thread.sleep(3000);
			dinningTableQRScan.qrCodeElement();
			dinningTableQRScan.qrCode();
			

		} catch (Exception e) {

			logger.error("Test failed due to an exception", e);
			Assert.fail("Test assertion failed due to an exception: " + e.getMessage());

		}

		logger.info("***** Finished TC034_DinningTableQRScanTest *****");

	}
}