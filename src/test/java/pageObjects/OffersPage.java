package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OffersPage extends BasePage {

	public OffersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//span[normalize-space()='Offers'])[1]")
	WebElement lnkOffers;
	@FindBy(xpath = "//span[normalize-space()=\"Add Offer\"]")
	WebElement addOfferBtn;
	@FindBy(xpath = "//input[@id=\"name\"]")
	WebElement txtName;
	@FindBy(xpath = "//input[@id=\"amount\"]")
	WebElement txtAmount;
	@FindBy(xpath = "//input[@id=\"active\"]")
	WebElement radioActiveBtn;

	// Dates
	// Only Click Start Date
	@FindBy(xpath = "(//input[contains(@class, 'dp__input')])[1]")
	WebElement selectStartDate;

	// Only Click End Date
	@FindBy(xpath = "(//input[contains(@class, 'dp__input')])[2]")
	WebElement selectEndDate;

	// Only Start Date Select
	@FindBy(xpath = "//div[contains(@class, 'dp__cell') and text()='2']")
	WebElement selectSDate;

	// Only End Date Select
	@FindBy(xpath = "//div[contains(@class, 'dp__cell') and text()='15']")
	WebElement selectEDate;

	@FindBy(xpath = "//div[contains(normalize-space(), \"Offer-\")]")
	WebElement getTxtName;

	
	
	// Explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void clickOffers() {
		wait.until(ExpectedConditions.elementToBeClickable(lnkOffers)).click();
	}

	public void addOffersBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(addOfferBtn)).click();
	}

	public void setName(String name) {
		txtName.clear();
		txtName.sendKeys(name);
	}

	public void setDiscountPercentage(String amount) {
		txtAmount.clear();
		txtAmount.sendKeys(amount);
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

	public void selectFileUpload() {

		WebElement fileInput = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='file' and @id='image']")));

		String imagePath = "C:\\Users\\tahmi\\Downloads\\selenium\\demopngtest.png";
		fileInput.sendKeys(imagePath);

	}

	public void clickActiveBtn() {
		radioActiveBtn.click();
	}


	// Offer Edit
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
				ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(normalize-space(), \"Offer-\")]")))
				.getText();

	}
	
	
	// Offers Delete
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
				
				break;
			}
		}

		if (!offerFound) {
			System.out.println("Offers not found!");
		}

	}

}
