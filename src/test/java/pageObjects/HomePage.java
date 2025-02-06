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
	
	@FindBy(xpath = "//span[normalize-space()='Account']")
	WebElement btnAccount;
	
	@FindBy(xpath = "//body//div//header//div//div//nav//a[1]")
	WebElement lnkDashboard;
	
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickAccount() {
		btnAccount.click();
	}
	
	public void clickDashboard() {
		lnkDashboard.click();
	}
}
