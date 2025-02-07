package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TableOrdersPage extends BasePage {

	
	public TableOrdersPage(WebDriver driver) {
		super(driver);
	}
	//span[normalize-space()="Table Orders"]
	@FindBy(xpath = "//span[normalize-space(text())='Table Orders']")
	WebElement lnkTableOrders;
	
	@FindBy(xpath = "//span[normalize-space()=\"Add Token\"]")
	WebElement btnAddToken;
	
	@FindBy(xpath = "//input[@id=\"name\"]")
	WebElement setTokenNameTxt;
	
	@FindBy(xpath = "//span[normalize-space()=\"Save\"]")
	WebElement btnSaveToken;

	public void clickTableOrders() {
		lnkTableOrders.click();
	}
	public void clickAddToken() {
		btnAddToken.click();
	}
	public void clickTokenName(String tokenName) {
		setTokenNameTxt.sendKeys(tokenName);
	}
	public void clickTokenSave() {
		btnSaveToken.click();
	}
}
