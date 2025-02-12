package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	@FindBy(xpath = "//button[@id='confirmBtn']")
	WebElement btnConfirm;
	
	
	public void clickPayNow() {
		btnPayNow.click();
	}

	public void clickStripe() {
		selectStripe.click();
	}
	// Wait object for explicit waits
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	//public void clickConfirm() {
		
	//	wait.until(ExpectedConditions.elementToBeClickable(btnConfirm)).click();
	//}
		
		//This isn't working as expected
		// Updated clickConfirm() method with JavaScript click
		public void clickConfirm() {
		    try {
		        System.out.println("Trying to click Confirm button...");

		        // Wait for the button to be present in the DOM
		        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmBtn")));

		        // Wait for the button to be visible and clickable
		        wait.until(ExpectedConditions.visibilityOf(btnConfirm));
		        wait.until(ExpectedConditions.elementToBeClickable(btnConfirm));

		        // Scroll into view
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", btnConfirm);
		        Thread.sleep(500);

		        // Click using JavaScript
		        js.executeScript("arguments[0].click();", btnConfirm);

		        System.out.println("Confirm button clicked successfully.");

		    } catch (Exception e) {
		        throw new RuntimeException("Failed to click Confirm button: " + e.getMessage());
		    }
		}

	

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

	
	public void enterCardDetails(String cardNumber, String expiryDate, String cvc) {
		switchToStripeIframe(); // Switch to iframe first

		WebElement cardInput = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Card number']")));
		WebElement expiryInput = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='MM / YY']")));
		WebElement cvcInput = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='CVC']")));

		cardInput.sendKeys(cardNumber);
		expiryInput.sendKeys(expiryDate);
		cvcInput.sendKeys(cvc);

		switchToDefaultContent(); // Switch back to main content
	}

}
