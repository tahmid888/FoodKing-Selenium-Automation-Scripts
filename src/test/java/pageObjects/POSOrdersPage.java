package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POSOrdersPage extends BasePage{

	
	public POSOrdersPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath ="//span[normalize-space()=\"POS Orders\"]")
	WebElement lnkPosOrders;
	

	@FindBy(xpath ="//table/tbody/tr[1]/td[1]")
	WebElement getOrderIdRowTxt;
	
	@FindBy(xpath ="//table//tr[1]/td[6]//a/i")
	WebElement btnViewPosOrders;
	
	//Payment Status-> Paid, Unpaid
	@FindBy(xpath ="//option[@value=\"5\" and contains(normalize-space(), \"Paid\")]")
	WebElement selectPaidPaymentStatusDropDown;
	
	@FindBy(xpath ="//option[@value=\"10\" and contains(normalize-space(), \"Unpaid\")]")
	WebElement selectUnPaidPaymentStatusDropDown;

	// Order Status -> Accept, Processing, Delivered
	@FindBy(xpath ="//option[@value=\"4\" and contains(normalize-space(), \"Accept\")]")
	WebElement selectAcceptOrderStatusDropDown;
	
	@FindBy(xpath ="//option[@value=\"7\" and contains(normalize-space(), \"Processing\")]")
	WebElement selectProcessingOrderStatusDropDown;
	
	@FindBy(xpath ="//option[@value=\"13\" and contains(normalize-space(), \"Delivered\")]")
	WebElement selectDeliveredOrderStatusDropDown;
	
	// Delivery Information
	@FindBy(xpath ="//h4[contains(normalize-space(), \"Dipon Das\")]")
	WebElement getNameTxt;
	@FindBy(xpath ="//span[contains(normalize-space(), \"das@gmail.com\")]")
	WebElement getEmailTxt;
	@FindBy(xpath ="//span[contains(normalize-space(), \"+8801790319999\")]")
	WebElement getPhoneTxt;
	
	
	public void clickPOSOrders() {
		lnkPosOrders.click();
	}
	
	public String getOrderIdTxt() {
		return getOrderIdRowTxt.getText();
	}
	
	public void clickViewPosOrdersBtn() {
		btnViewPosOrders.click();
	}
	// Payment Status
	public void selectPaidPaymentDropDown() {
		selectPaidPaymentStatusDropDown.click();
	}
	public void selectUnpaidPaymentDropDown() {
		selectUnPaidPaymentStatusDropDown.click();
	}
	// Order Status
	public void selectAcceptOrderDropDown() {
		selectAcceptOrderStatusDropDown.click();
	}
	public void selectProcessingOrderDropDown() {
		selectProcessingOrderStatusDropDown.click();
	}
	public void selectDeliveredOrderDropDown() {
		selectDeliveredOrderStatusDropDown.click();
	}
	
	// Delivery Information
	
	public String getPosOrdersNameTxt() {
		return getNameTxt.getText();
	}
	public String getPosOrdersEmailTxt() {
		return getEmailTxt.getText();
	}
	public String getPosOrdersPhoneTxt() {
		return getPhoneTxt.getText();
	}
	
}
