package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyOrdersPage extends BasePage {

	public MyOrdersPage(WebDriver driver) {
		super(driver);
	}

	

	@FindBy(xpath = "//body//div//header//div//div//nav//a[1]")
	WebElement lnkMyOrders;

	@FindBy(xpath = "//a[normalize-space()='See Details']")
	WebElement lnkSeeDetails;

	// Dynamic xpath for get the OrderID
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/h3[1]/span[1]")
	WebElement getOrderId;
	
	// Dynamic xpath for get the OrderType
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]")
	WebElement getOrderType;


	public void clickMyOrders() {
		lnkMyOrders.click();
	}

	public void clickSeeDetails() {
		lnkSeeDetails.click();
	}

	public String getOrderId() {
		return getOrderId.getText();
	}

	public String getOrderType() {
		return getOrderType.getText();
	}

}
