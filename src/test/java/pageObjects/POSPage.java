package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POSPage extends BasePage{

	public POSPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//body//div//header//div//div//nav//a[1]")
	WebElement lnkDashboard;
	
	@FindBy(xpath = "//span[normalize-space()='POS']")
	WebElement lnkPOS;
	
	// Dynamic xpaths for handle "Add"  products in the Add to the product list
	@FindBy(xpath = "(//button[@data-modal='#item-variation-modal'])[3]")
	WebElement btnAddItems;
	
	@FindBy(xpath = "//textarea[@placeholder='Add note (extra mayo, cheese, etc.)']")
	WebElement txtSpecialInstructions;
	
	// Dynamic xpaths for handle "Add to Cart" products in the list
	@FindBy(xpath = "//span[contains(normalize-space(), 'Add to Cart')]")
	WebElement btnAddToCart;
	

	public void clickDashboard() {
		lnkDashboard.click();
	}
	
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
	// Text token no
	
	
	
	
}
