package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POSPage extends BasePage {

	public POSPage(WebDriver driver) {
		super(driver);
	}

	

	@FindBy(xpath = "//span[normalize-space()='POS']")
	WebElement lnkPOS;

	// Dynamic xpaths for handle "Add" products in the Add to the product list
	@FindBy(xpath = "(//button[@data-modal='#item-variation-modal'])[3]")
	WebElement btnAddItems;

	@FindBy(xpath = "//textarea[@placeholder='Add note (extra mayo, cheese, etc.)']")
	WebElement txtSpecialInstructions;

	// Dynamic xpaths for handle "Add to Cart" products in the list
	@FindBy(xpath = "//span[contains(normalize-space(), 'Add to Cart')]")
	WebElement btnAddToCart;

	@FindBy(xpath = "//span[@class='icon arrow-downward']")
	WebElement selectDropDown;

	// Change Customer according to their Name
	@FindBy(xpath = "//span[normalize-space()='Dipon Das']")
	WebElement selectCustomerDropDown;

	@FindBy(xpath = "//input[@id='token']")
	WebElement txtToken;

	// Dynamic xpaths for handle items name
	@FindBy(xpath = "//table//tr[1]//td[2]//h3")
	WebElement getItemsTxt;

	// Dynamic xpaths for handle size
	@FindBy(xpath = "//table//tbody//tr[1]//td[2]//p//span//span[2]")
	WebElement getSizeTxt;

	@FindBy(xpath = "//option[@value='2']")
	WebElement selectCardDropdown;

	@FindBy(xpath = "//input[@placeholder=\"Enter last 4 digits of card\"]")
	WebElement txtLastDigitCard;

	@FindBy(xpath = "//button[normalize-space()=\"Order\"]")
	WebElement btnOrder;

	// Get Order ID from print(Dynamic xpath)
	@FindBy(xpath = "//td[contains(normalize-space(text()), 'Order')]")
	WebElement getOrderIdTxt;

	// Get Order Payment Type: from print(Dynamic xpath)
	@FindBy(xpath = "//p[normalize-space(text())='Payment Type: Card']")
	WebElement getPaymentTypeTxt;

//	@FindBy(xpath = "//input[@type='number']")
//	WebElement getQuantityTxt;

	
	
	
	

	public void clickPOS() {
		lnkPOS.click();
	}

	public void clickAddItemsBtn() {
		btnAddItems.click();
	}

	public void setSpecialInstruction(String specialInstructions) {
		txtSpecialInstructions.sendKeys(specialInstructions);
	}

	public void clickAddToCartBtn() {
		btnAddToCart.click();
	}

	// Select customer dropdown
	public void clickDropDown() {
		selectDropDown.click();
	}

	public void clickCustomerDropDown() {
		selectCustomerDropDown.click();
	}

	private static int counter = 1;

	public void setToken() {
		txtToken.sendKeys(String.valueOf(counter));
		counter++; // Increment for the next run
	}

	public String getItemsText() {
		return getItemsTxt.getText();
	}

	public String getSizeText() {
		return getSizeTxt.getText();
	}

	public void selectPaymentMethodDropdown() {
		selectCardDropdown.click();
	}

	public void setLastDigitCard(String lastdigit) {
		txtLastDigitCard.sendKeys(lastdigit);
	}

	public void clickOrderBtn() {
		btnOrder.click();
	}

	public String getPrintOrderIDTxt() {
		return getOrderIdTxt.getText();
	}

	public String getPrintPaymentTypeTxt() {
		return getPaymentTypeTxt.getText();
	}

	
	
//	public Integer getQuantityText() { 
//	    String text = getQuantityTxt.getText(); // Get text from the element
//
//	    if (text == null || text.trim().isEmpty()) { 
//	        System.out.println("Warning: Quantity text is empty or null.");
//	        return 0; // Return a default value (0) to prevent NumberFormatException
//	    }
//
//	    try {
//	        return Integer.parseInt(text.trim()); // Convert the cleaned text to an integer
//	    } catch (NumberFormatException e) {
//	        System.out.println("Error: Unable to parse quantity '" + text + "' as an integer.");
//	        return 0; // Return default value if parsing fails
//	    }
//	}

}
