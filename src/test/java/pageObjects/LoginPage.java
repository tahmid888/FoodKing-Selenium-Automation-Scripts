package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	@FindBy(xpath="//input[@id='formEmail']")
	WebElement txtLoginEmail;
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	WebElement txtPassword;
	
	
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btnLogin;
	
	
	public void setEmail(String email) {
		txtLoginEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
}
