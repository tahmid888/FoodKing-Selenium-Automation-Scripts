package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CouponsEditPage extends BasePage {

	public CouponsEditPage(WebDriver driver) {
		super(driver);
	}

	// Coupon Menu
	@FindBy(xpath = "//span[normalize-space()=\"Coupons\"]")
	WebElement lnkCoupon;
	// Add Coupon
	@FindBy(xpath = "//span[normalize-space()=\"Add Coupon\"]")
	WebElement btnAddCoupon;
	// Coupon Form Update
	@FindBy(xpath = "//input[@id=\"name\"]")
	WebElement txtName;
	@FindBy(xpath = "//input[@id=\"code\"]")
	WebElement txtCode;

	@FindBy(xpath = "//div[contains(normalize-space(), \"Auth-\")]")
	WebElement getTxtName;

	// ****************************************************************************//

	// Wait object for explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void clickCoupon() {
		wait.until(ExpectedConditions.elementToBeClickable(lnkCoupon)).click();
	}

	public void setName(String name) {
		txtName.clear();
		txtName.sendKeys(name);
	}

	public void setCode(String code) {
		txtCode.clear();
		txtCode.sendKeys(code);
	}

	public String getNameTxt() {
		return wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(normalize-space(), \"Auth-\")]")))
				.getText();

	}

	public void chooseNameToUpdate() {

		String couponName = "Auth-2025"; // Coupon to search for
		boolean couponFound = false;

		// Locate all rows in the table
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

		for (WebElement row : rows) {
			// Find the coupon name in each row
			WebElement nameCell = row.findElement(By.xpath(".//td[1]")); // Adjust column index
			if (nameCell.getText().equals(couponName)) {
				couponFound = true;

				// Click the "Edit" button in the same row
				WebElement editButton = row.findElement(By.xpath(".//td[7]//button"));
				editButton.click();
				// Exit loop after finding and editing the coupon
				break;
			}
		}

		if (!couponFound) {
			System.out.println("Coupon not found!");
		}

	}

}
