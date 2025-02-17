package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage extends BasePage {
	
	public UsersPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="(//span[normalize-space()='Administrators'])[1]")
	WebElement linkAdministrator;
	@FindBy(xpath="//span[normalize-space()='Add Administrator']")
	WebElement addAdministratorBtn;
	@FindBy(xpath="//input[@id='name']")
	WebElement txtName;
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	@FindBy(xpath="//input[@id='phone']")
	WebElement txtPhone;
	@FindBy(xpath="//input[@id='active']")
	WebElement radioActiveBtn;
	@FindBy(xpath="//input[@id='inactive']")
	WebElement radioInActiveBtn;
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	@FindBy(xpath="//input[@id='password_confirmation']")
	WebElement txtPasswordConfirmation;
	@FindBy(xpath="//input[@id='current_branch']")
	WebElement radioCurrentBranch;
	@FindBy(xpath="//input[@id='all_branch']")
	WebElement radioAllBranch;


	// Wait object for explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	
	
	public void clickAdministrator() {
		wait.until(ExpectedConditions.elementToBeClickable(linkAdministrator)).click();
	}
	public void clickaddAdministratorBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(addAdministratorBtn)).click();
	}
	public void setName(String name) {
		txtName.sendKeys(name);
	}
	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	public void setPhone(String phone) {
		txtPhone.sendKeys(phone);
	}
	public void activeBtn() {
		radioActiveBtn.click();
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void setPasswordConfirmation(String confirmPassword) {
		txtPasswordConfirmation.sendKeys(confirmPassword);
	}
	public void allBranchBtn() {
		//wait.until(ExpectedConditions.elementToBeClickable(addAdministratorBtn)).click();
		radioAllBranch.click();
	}
	
	
	
}
