package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeletePOSOrdersPage extends BasePage{

	public DeletePOSOrdersPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath ="//tbody/tr[1]/td[6]/div[1]/button[1]/i[1]")
	WebElement btnPosOrders;
	
	@FindBy(xpath ="//button[normalize-space()=\"Yes, Delete it!\"]")
	WebElement btnDeleteYes;
	
	
	public void clickDeletePOSOrders() {
		btnPosOrders.click();
	}
	
	public void clickDeleteYesPOSOrders() {
		btnDeleteYes.click();
	}
}
