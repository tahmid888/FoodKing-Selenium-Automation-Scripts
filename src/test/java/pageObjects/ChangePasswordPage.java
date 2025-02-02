package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends BasePage {

	public ChangePasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//body//div//header//a[5]")
	WebElement lnkChangePassword;

	@FindBy(xpath = "//input[@id='old_password']")
	WebElement txtOldPassword;

	@FindBy(xpath = "//input[@id='password']")
	WebElement txtNewPassword;

	@FindBy(xpath = "//input[@id='password_confirmation']")
	WebElement txtTypeNewPassword;

	@FindBy(xpath = "//button[normalize-space()='Change Password']")
	WebElement btnChangePassword;

	
	
	
	public void clickChangePassword() {
		lnkChangePassword.click();
	}

	public void setChangePassword(String oldPassword) {
		txtOldPassword.sendKeys(oldPassword);
	}

	public void setNewPassword(String newPassword) {
		txtNewPassword.sendKeys(newPassword);
	}

	public void setTypeNewPassword(String typeNewPassword) {
		txtTypeNewPassword.sendKeys(typeNewPassword);
	}

	public void clickChangePasswordbtn() {
		btnChangePassword.click();
	}

}
