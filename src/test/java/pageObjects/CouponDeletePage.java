package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CouponDeletePage extends BasePage {

	public CouponDeletePage(WebDriver driver) {
		super(driver);
	}

	//@FindBy(xpath = ".//td[7]//button[2]")
	//WebElement btnDelete;

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

				// Click the "Edit" button in the same row
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
	
	
}
