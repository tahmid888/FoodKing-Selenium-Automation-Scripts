package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OffersDeletePage extends BasePage {

	public OffersDeletePage(WebDriver driver) {
		super(driver);
	}

	// Explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void chooseNameToDelete() {

		String offerName = "Offer-2026"; // Offers to search for
		boolean offerFound = false;

		// Locate all rows in the table
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

		for (WebElement row : rows) {
			// Find the offer name in each row
			WebElement nameCell = row.findElement(By.xpath(".//td[1]")); // Adjust column index
			if (nameCell.getText().equals(offerName)) {
				offerFound = true;

				// Click the "Delete" button in the same row
				WebElement deleteButton = row.findElement(By.xpath("//tbody/tr/td[6]/div[1]/button[2]"));

				wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
				// Exit loop after finding and editing the offers
				break;
			}
		}

		if (!offerFound) {
			System.out.println("Offers not found!");
		}

	}

	public String getNameTxt() {
		return wait
				.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//td[contains(normalize-space(), \"Offer-2026\")]")))
				.getText();

	}

}
