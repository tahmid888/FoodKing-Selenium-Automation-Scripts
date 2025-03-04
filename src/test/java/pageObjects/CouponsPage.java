package pageObjects;
import java.time.Duration;
import java.util.List;
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

	// Coupon Menu
	@FindBy(xpath = "//span[normalize-space()=\"Coupons\"]")
	WebElement lnkCoupon;
	// Add Coupon
	@FindBy(xpath = "//span[normalize-space()=\"Add Coupon\"]")
	WebElement btnAddCoupon;
	// Coupon Form
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
	

	// Dates
	// Only Click Start Date
	@FindBy(xpath = "(//input[contains(@class, 'dp__input')])[1]")
	WebElement selectStartDate;

	// Only Click End Date
	@FindBy(xpath = "(//input[contains(@class, 'dp__input')])[2]")
	WebElement selectEndDate;

	// Only Start Date Select
	@FindBy(xpath = "//div[contains(@class, 'dp__cell') and text()='1']")
	WebElement selectSDate;

	// Only End Date Select
	@FindBy(xpath = "//div[contains(@class, 'dp__cell') and text()='15']")
	WebElement selectEDate;

	// Save button
	@FindBy(xpath = "//span[normalize-space()=\"Save\"]")
	WebElement btnSave;
	
	@FindBy(xpath = "//button[normalize-space()=\"Yes, Delete it!\"]")
	WebElement btnDelete;

	@FindBy(xpath = "//div[contains(normalize-space(), \"Auth-\")]")
	WebElement getTxtName;

	

	// Explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void clickCoupon() {
		wait.until(ExpectedConditions.elementToBeClickable(lnkCoupon)).click();
	}

	public void clickAddCoupon() {
		wait.until(ExpectedConditions.elementToBeClickable(btnAddCoupon)).click();
	}

	public void setName(String name) {
		txtName.clear();
		txtName.sendKeys(name);
	}

	public void setCode(String code) {
		txtName.clear();
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

	// To Upload Files
	public void selectFileUpload() {

		WebElement fileInput = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='file' and @id='image']")));
		// Provide the full path to the image you wish to upload (use double backslashes
		// on Windows)
		String imagePath = "C:\\Users\\tahmi\\Downloads\\selenium\\demopngtest.png";
		fileInput.sendKeys(imagePath);

	}

	public void setDescription(String description) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id=\"description\"]")))
				.sendKeys(description);
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
	
	
	public String getNameTxt() {
		return wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//td[contains(normalize-space(), \"Auth-\")]")))
				.getText();

	}
	
	// Edit Coupon
	public void chooseNameToUpdate() {

		String couponName = "Auth-2025"; // Coupon to search for
		boolean couponFound = false;

		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

		for (WebElement row : rows) {
			// Find the coupon name in each row
			WebElement nameCell = row.findElement(By.xpath(".//td[1]")); // Adjust column index
			if (nameCell.getText().equals(couponName)) {
				couponFound = true;

				// Click the "Edit" button in the same row
				WebElement editButton = row.findElement(By.xpath(".//td[7]//button"));
				editButton.click();
			
				break;
			}
		}

		if (!couponFound) {
			System.out.println("Coupon not found!");
		}

	}

	// Save button
	public void clickSaveBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(btnSave)).click();

	}

	
	// Coupons Delete
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
	
	public void deleteBtn() {
		wait.until(ExpectedConditions.visibilityOf(btnDelete)).click();
	}

}
