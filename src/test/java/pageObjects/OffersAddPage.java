package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OffersAddPage extends BasePage {

	public OffersAddPage(WebDriver driver) {
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
	@FindBy(xpath = "//div[contains(@class, 'dp__cell') and text()='15']")
	WebElement selectSDate;

	// Only End Date Select
	@FindBy(xpath = "//div[contains(@class, 'dp__cell') and text()='25']")
	WebElement selectEDate;
	
	@FindBy(xpath = "//div[contains(normalize-space(), \"Offer-\")]")
	WebElement getTxtName;

	// *************************************************************************//

	// Wait object for explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void clickOffers() {
		wait.until(ExpectedConditions.elementToBeClickable(lnkOffers)).click();
	}

	public void addOffersBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(addOfferBtn)).click();
	}

	public void setName(String name) {
		txtName.sendKeys(name);
	}

	public void setDiscountPercentage(String amount) {
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
	
	public String getNameTxt() {
		return 	getTxtName.getText();
		}
}
