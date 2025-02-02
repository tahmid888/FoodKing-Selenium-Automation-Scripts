package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentGatewayPage extends BasePage {

	public PaymentGatewayPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Pay Now']")
	WebElement btnPayNow;

	@FindBy(xpath = "//input[@id='stripe']")
	WebElement selectStripe;

	// Locate card number input field (inside the iframe)
	//@FindBy(xpath = "//input[@placeholder='Card number']")
	//WebElement inputCardNumber;

	// Locate expiry date field (inside the iframe)
	//@FindBy(xpath = "//input[@placeholder='MM / YY']")
	//WebElement inputExpiryDate;

	// Locate CVC field (inside the iframe)
	//@FindBy(xpath = "//input[@placeholder='CVC']")
	//WebElement inputCVC;

	@FindBy(xpath="//button[@id='confirmBtn']")
	WebElement btnConfirm;
	
	
	
	public void clickPayNow() {
		btnPayNow.click();
	}

	public void clickStripe() {
		selectStripe.click();	
	}
	public void clickConfirm() {
	    wait.until(ExpectedConditions.elementToBeClickable(btnConfirm)).click();
	}

	// Wait object for explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
	
	// Method to dynamically switch to the Stripe iframe with Explicit Wait
	public void switchToStripeIframe() {
		WebElement stripeIframe = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//iframe[contains(@name, 'privateStripeFrame')]")));
		driver.switchTo().frame(stripeIframe);
	}

	// Method to switch back to the main page
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}


	// Enter card details (inside the iframe) with Explicit Wait
//	public void enterCardDetails(String cardNumber, String expiryDate, String cvc) {
//		switchToStripeIframe(); // Switch to iframe first
//
//		wait.until(ExpectedConditions.visibilityOf(inputCardNumber)).sendKeys(cardNumber);
//		wait.until(ExpectedConditions.visibilityOf(inputExpiryDate)).sendKeys(expiryDate);
//		wait.until(ExpectedConditions.visibilityOf(inputCVC)).sendKeys(cvc);
//
//		switchToDefaultContent(); // Switch back to main content
//	}
	public void enterCardDetails(String cardNumber, String expiryDate, String cvc) {
	    switchToStripeIframe(); // Switch to iframe first

	    WebElement cardInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Card number']")));
	    WebElement expiryInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='MM / YY']")));
	    WebElement cvcInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='CVC']")));

	    cardInput.sendKeys(cardNumber);
	    expiryInput.sendKeys(expiryDate);
	    cvcInput.sendKeys(cvc);

	    switchToDefaultContent(); // Switch back to main content
	}
	
	
	
	
}
