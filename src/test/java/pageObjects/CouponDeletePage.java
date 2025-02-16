package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CouponDeletePage extends BasePage {

	public CouponDeletePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[normalize-space()=\"Yes, Delete it!\"]")
	WebElement btnDelete;

	// Wait object for explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void chooseNameToDelete() {

		String couponName = "Auth-2026"; // Coupon to search for
		boolean couponFound = false;

		// Locate all rows in the table
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

		for (WebElement row : rows) {
			// Find the coupon name in each row
			WebElement nameCell = row.findElement(By.xpath(".//td[1]")); // Adjust column index
			if (nameCell.getText().equals(couponName)) {
				couponFound = true;

				// Click the "Delete" button in the same row
				WebElement deleteButton = row.findElement(By.xpath(".//td[7]//button[2]"));
				deleteButton.click();
				// Exit loop after finding and editing the coupon
				break;
			}
		}

		if (!couponFound) {
			System.out.println("Coupon not found!");
		}

	}

	public String getNameTxt() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(normalize-space(), \"Auth-\")]")))
				.getText();

	}

	public void deleteBtn() {
		wait.until(ExpectedConditions.visibilityOf(btnDelete)).click();
	}

}
