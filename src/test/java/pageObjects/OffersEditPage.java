package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OffersEditPage extends BasePage {

	public OffersEditPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id=\"name\"]")
	WebElement txtName;
	@FindBy(xpath = "//input[@id=\"amount\"]")
	WebElement txtAmount;

	// Wait object for explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void setName(String name) {
		txtName.clear();
		txtName.sendKeys(name);
	}

	public void setDiscountPercentage(String amount) {
		txtAmount.clear();
		txtAmount.sendKeys(amount);
	}

	public void chooseNameToUpdate() {

		String offerName = "Offer-2025"; // Offer to search for
		boolean offerFound = false;

		// Locate all rows in the table
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

		for (WebElement row : rows) {
			// Find the offer name in each row
			WebElement nameCell = row.findElement(By.xpath(".//td[1]")); // Adjust column index
			if (nameCell.getText().equals(offerName)) {
				offerFound = true;

				// Click the "Edit" button in the same row //tbody/tr[1]/td[6]/div[1]/button[1]
				WebElement editButton = row.findElement(By.xpath("//tbody/tr[1]/td[6]/div[1]/button[1]/i[1]"));
				editButton.click();
				// Exit loop after finding and editing the offer
				break;
			}
		}

		if (!offerFound) {
			System.out.println("Offers not found!");
		}

	}


	public String getNameTxt() {
		return wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(normalize-space(), \"Offer-2026\")]")))
				.getText();

	}

}
