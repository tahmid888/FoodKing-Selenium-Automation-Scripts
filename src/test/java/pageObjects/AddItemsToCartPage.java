package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddItemsToCartPage extends BasePage  {

	
	
	 public AddItemsToCartPage(WebDriver driver) {
		super(driver);
	}

	 // Need to do Dynamic xpath - check Needed
	@FindBy(xpath = "(//button[@class='product-card-list-cart-btn add-btn'])[1]")
	WebElement btnAddItems;
	
	@FindBy(xpath = "//textarea[@placeholder='Add note (extra mayo, cheese, etc.)']")
	WebElement txtInstructions;
	
	// Dynamic xpath for the 'Add to Cart" button
	@FindBy(xpath = "//span[starts-with(normalize-space(), 'Add to Cart')]")
	WebElement btnAddToCart;
	
	//span[starts-with(normalize-space(), 'Add to Cart')]
	

	public void setSearch() {
		btnAddItems.click();
	}
	
	public void setInstructions(String instructions) {
		txtInstructions.sendKeys(instructions);
	}
	
	public void clickAddToCart() {
		btnAddToCart.click();
	}
	
	
	
	
	
	
}
