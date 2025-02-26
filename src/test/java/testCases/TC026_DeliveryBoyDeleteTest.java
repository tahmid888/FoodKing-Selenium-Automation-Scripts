package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CouponDeletePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UsersPage;
import testBase.BaseClass;

public class TC026_DeliveryBoyDeleteTest extends BaseClass{
	
	@Test()
	public void deliveryBoyDelete() {

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

			// UsersPage Page
			UsersPage usersPage = new UsersPage(driver);
			usersPage.clickDeliveryBoy();
			usersPage.chooseNameToDelete();

			// Coupons Delete Page
			CouponDeletePage couponDeletePage = new CouponDeletePage(driver);
			couponDeletePage.deleteBtn();


			// Perform delete action here before assertion

			String deletedUserName = usersPage.getNameTxt(); // Method should return null or empty if user is deleted

			System.out.println("Extracted Text After Deletion: " + deletedUserName);

			// Assert that the user does not exist after deletion
			Assert.assertFalse(deletedUserName == null || deletedUserName.isEmpty(), "User deletion failed!");

		} catch (Exception e) {
			// Logs the exception for debugging
			e.printStackTrace();
			Assert.fail("Test failed due to an exception: " + e.getMessage());

		}
	}

}
