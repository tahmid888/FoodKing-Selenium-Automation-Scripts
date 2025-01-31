package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//span[@class='whitespace-nowrap'][normalize-space()='Log in']")
	WebElement btnLogin;
	
	
	public void clickLogin() {
		btnLogin.click();
	}
}
