package pageObjects;

import java.io.File;
import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	@FindBy(xpath = "//input[@id=\"minimum_order\"]")
	WebElement txtMinimumOrder;
	@FindBy(xpath = "//input[@id=\"maximum_discount\"]")
	WebElement txtMaximumDiscount;
	@FindBy(xpath = "//input[@id=\"limit_per_user\"]")
	WebElement txtLimitUser;
	@FindBy(xpath = "//textarea[@id=\"description\"]")
	WebElement txtDescription;

	// File Uploading Xpath
	@FindBy(xpath = "//input[@type='file' and contains(@accept, 'image/')]")
	WebElement fileUpload;

	// Dates
	// Only Click Start Date
	@FindBy(xpath = "(//input[contains(@class, 'dp__input')])[1]")
	WebElement selectStartDate;

	// Only Click End Date
	@FindBy(xpath = "(//input[contains(@class, 'dp__input')])[2]")
	WebElement selectEndDate;

	// Only Start Date Select
	@FindBy(xpath = "//div[contains(@class, 'dp__cell') and text()='15']")
	WebElement selectSDate;

	// Only End Date Select
	@FindBy(xpath = "//div[contains(@class, 'dp__cell') and text()='25']")
	WebElement selectEDate;

	// Save button
	@FindBy(xpath = "//span[normalize-space()=\"Save\"]")
	WebElement btnSave;
	
	// Wait object for explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	
	public void clickCoupon() {
		wait.until(ExpectedConditions.elementToBeClickable(lnkCoupon)).click();
	}

	public void clickAddCoupon() {
		wait.until(ExpectedConditions.visibilityOf(btnAddCoupon)).click();
		//btnAddCoupon.click();
	}

	public void setName(String name) {
		txtName.sendKeys(name);
	}

	public void setCode(String code) {
		txtCode.sendKeys(code);
	}

	public void setDiscount(String discount) {
		txtDiscount.sendKeys(discount);
	}

	public void setMinimumOrder(String minOrder) {
		txtMinimumOrder.sendKeys(minOrder);
	}

	public void setMaximumDiscount(String maxDiscount) {
		txtMaximumDiscount.sendKeys(maxDiscount);
	}

	public void setLimitUser(String limitUser) {
		txtLimitUser.sendKeys(limitUser);
	}

	  public void selectFileUpload() {
	        // Provide the correct file path (use double backslashes for Windows paths)
	        String imagePath = "C:\\Users\\tahmi\\Downloads\\selenium\\demopngtest.png";

	        wait.until(ExpectedConditions.elementToBeClickable(fileUpload));

	        fileUpload.sendKeys(imagePath);
	    }

	public void setDescription(String description) {
		txtDescription.sendKeys(description);
	}

	// Dates
	public void clickStartDate() {
		selectStartDate.click();
	}

	public void clickSDate() {
		selectSDate.click();
	}

	public void clickEndDate() {
		selectEndDate.click();
	}

	public void clickEDate() {
		selectEDate.click();
	}
	public void clickSaveBtn() {
		btnSave.click();
	}

}
