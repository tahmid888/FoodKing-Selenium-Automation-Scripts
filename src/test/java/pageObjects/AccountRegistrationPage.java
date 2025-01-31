package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Signup']")
	WebElement lnkSignup;

	@FindBy(xpath = "//input[@id='phone']")
	WebElement textMobileNumber;

	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement btnNext;

	// Wait for the toast notification to appear
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement toast = wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//div[@class='Vue-Toastification__container bottom-center']")

			));
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement txtFirstName;
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement txtLastName;
	@FindBy(xpath="(//input[@type='email'])[1]")
	WebElement txtEmail;
	@FindBy(xpath="(//input[@type='password'])[1]")
	WebElement txtPassword;
	@FindBy(xpath="//button[normalize-space()='Sign Up']")
	WebElement btnSignup;
	
	
	

	public void clickSignupLink() {
		lnkSignup.click();
	}

	public void setMobileNumber(String mobileNumber) {
		textMobileNumber.sendKeys(mobileNumber);
	}

	public void clickNext() {
		btnNext.click();
	}

	public String getToastNotification() {
		return toast.getText();

	}
	public void setFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}
	public void setLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void clickSignupBtn() {
		btnSignup.click();
	}
	

	

}
