package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnlineOrdersPage extends BasePage {

	public OnlineOrdersPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "(//span[normalize-space(text())='Online Orders'])[1]")
	WebElement lnkOnlineOrders;

	@FindBy(xpath = "(//table/tbody/tr/td[7]//a//i)[1]")
	WebElement btnView;

	@FindBy(xpath = "//span[normalize-space()=\"Accept\"]")
	WebElement btnAcceptOrders;

	@FindBy(xpath = "//button[normalize-space()=\"Yes, Accept it!\"]")
	WebElement btnYesAcceptOrders;

	public void clickOnlineOrders() {
		lnkOnlineOrders.click();
	}

	public void clickView() {
		btnView.click();
	}

	public void clickAcceptOrders() {
		btnAcceptOrders.click();
	}

	public void clickYesAcceptOrders() {
		btnYesAcceptOrders.click();
	}
}
