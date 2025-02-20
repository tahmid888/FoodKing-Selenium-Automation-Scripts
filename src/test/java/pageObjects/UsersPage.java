package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage extends BasePage {

	public UsersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//span[normalize-space()='Administrators'])[1]")
	WebElement linkAdministrator;
	@FindBy(xpath = "//span[normalize-space()='Add Administrator']")
	WebElement addAdministratorBtn;
	@FindBy(xpath = "//input[@id='name']")
	WebElement txtName;
	@FindBy(xpath = "//input[@id='email']")
	WebElement txtEmail;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement txtPhone;
	@FindBy(xpath = "//input[@id='active']")
	WebElement radioActiveBtn;
	@FindBy(xpath = "//input[@id='inactive']")
	WebElement radioInActiveBtn;
	@FindBy(xpath = "//input[@id='password']")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@id='password_confirmation']")
	WebElement txtPasswordConfirmation;
	@FindBy(xpath = "//input[@id='current_branch']")
	WebElement radioCurrentBranch;
	@FindBy(xpath = "//input[@id='all_branch']")
	WebElement radioAllBranch;

	// Explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Administrators Add
	public void clickAdministrator() {
		wait.until(ExpectedConditions.elementToBeClickable(linkAdministrator)).click();
	}

	public void clickaddAdministratorBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(addAdministratorBtn)).click();
	}

	public void setName(String name) {
		txtName.clear();
		txtName.sendKeys(name);
	}

	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setPhone(String phone) {
		txtPhone.sendKeys(phone);
	}

	public void activeBtn() {
		radioActiveBtn.click();
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void setPasswordConfirmation(String confirmPassword) {
		txtPasswordConfirmation.sendKeys(confirmPassword);
	}

	public void allBranchBtn() {
		// wait.until(ExpectedConditions.elementToBeClickable(addAdministratorBtn)).click();
		radioAllBranch.click();
	}

	public String getNameTxt() {
		return wait
				.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//td[contains(normalize-space(), \"Elon Musk\")]")))
				.getText();

	}

	// Administrators Edit

	public void chooseNameToEdit() {

		String administratorsName = "Elon Musk";
		boolean administratorsFound = false;

		// Locate all rows in the table
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

		for (WebElement row : rows) {
			// Find the name in each row
			WebElement nameCell = row.findElement(By.xpath(".//td[1]")); // Adjust column index
			if (nameCell.getText().equals(administratorsName)) {
				administratorsFound = true;

				// Click the "Edit" button in the same row
				WebElement editButton = row.findElement(By.xpath("//td/div[1]/button[1]"));

				wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
				
				break;
			}
		}

		if (!administratorsFound) {
			System.out.println("Administrators not found!");
		}

	}

}
