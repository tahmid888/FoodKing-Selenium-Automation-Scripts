package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CouponsPage extends BasePage {

	public CouponsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()=\"Coupons\"]")
	WebElement lnkCoupon;
	
	@FindBy(xpath = "//span[normalize-space()=\"Add Coupon\"]")
	WebElement btnAddCoupon;
	
	@FindBy(xpath = "//input[@id=\"name\"]")
	WebElement txtName;
	@FindBy(xpath = "//input[@id=\"code\"]")
	WebElement txtCode;
	@FindBy(xpath = "//input[@id=\"discount\"]")
	WebElement txtDiscount;
	
	@FindBy(xpath = "(//div[@aria-label='Datepicker input'])[1]")
	WebElement txtStartDate;

			

	

	// Wait object for explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void clickCoupon() {
		wait.until(ExpectedConditions.elementToBeClickable(lnkCoupon)).click();
	}
	
	public void clickAddCoupon() {
		btnAddCoupon.click();
	}
	
	
	public void setStartDate() {
	    txtStartDate.click();  // Open date picker if required
	    txtStartDate.sendKeys("02/01/2025, 09:04 PM");
	}

}
