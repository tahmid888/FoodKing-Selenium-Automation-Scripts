package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProceedToCheckoutPage extends BasePage {

	public ProceedToCheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[2]/button[1]")
	WebElement btnMyCart;

	@FindBy(xpath = "//input[@id='takeaway']")
	WebElement btnTakeaway;

	@FindBy(xpath = "//a[normalize-space()='Proceed to Checkout']")
	WebElement btnProceedToCheckout;

	@FindBy(xpath = "//button[normalize-space()='Place Order']")
	WebElement btnPlaceOrder;

	public void clickMyCart() {
		btnMyCart.click();
	}

	public void clickTakeaway() {
		btnTakeaway.click();
	}

	public void clickProceedToCheckout() {
		btnProceedToCheckout.click();
	}

	public void clickPlaceOrder() {
		btnPlaceOrder.click();
	}

}
