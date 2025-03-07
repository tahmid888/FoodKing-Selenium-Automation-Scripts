package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='formEmail']")
	WebElement txtLoginEmail;

	@FindBy(xpath = "(//input[@type='password'])[1]")
	WebElement txtPassword;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement btnLogin;

	@FindBy(className = "Vue-Toastification__toast-body")
	WebElement toasterNotification;
	
	@FindBy(xpath = "//button[normalize-space()='Logout']")
	WebElement logOut;

	// Explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void setEmail(String email) {
		txtLoginEmail.clear();
		txtLoginEmail.sendKeys(email);
	}

	public void setPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}

	public String toaster() {
		try {
			wait.until(ExpectedConditions.visibilityOf(toasterNotification));
			return toasterNotification.getText();
		} catch (Exception e) {
			return "Toaster notification not found or text not visible";
		}
	}

	public void clickLogin() {
		btnLogin.click();
	}
	public void clickLogout() {
		logOut.click();
	}
}
