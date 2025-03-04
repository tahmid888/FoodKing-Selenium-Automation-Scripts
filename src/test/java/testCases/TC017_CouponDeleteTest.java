package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CouponsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC017_CouponDeleteTest extends BaseClass {
	@Test()
	public void deleteCoupons() {

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

			// Coupons Page
			CouponsPage couponsPage = new CouponsPage(driver);
			couponsPage.clickCoupon();
			couponsPage.chooseNameToDelete();
			couponsPage.deleteBtn();

			// Assert
			String expectedName = couponsPage.getNameTxt();
			Assert.assertTrue(expectedName.toLowerCase().contains("auth-2026"));

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
	}

}
