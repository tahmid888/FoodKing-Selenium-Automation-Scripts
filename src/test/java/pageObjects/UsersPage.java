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

	@FindBy(xpath = "(//span[normalize-space()='Delivery Boys'])[1]")
	WebElement linkDeliveryBoys;
	@FindBy(xpath = "//span[normalize-space()='Add Delivery Boy']")
	WebElement addDeliveryBoyBtn;

	@FindBy(xpath = "(//span[normalize-space()='Customers'])[1]")
	WebElement linkCustomer;
	@FindBy(xpath = "//span[normalize-space()='Add Customer']")
	WebElement addCustomerBtn;

	@FindBy(xpath = "(//span[normalize-space()='Employees'])[1]")
	WebElement linkEmployee;
	@FindBy(xpath = "//span[normalize-space()='Add Employee']")
	WebElement addEmployeeBtn;
	@FindBy(xpath = "(//*[@class='icon arrow-downward'])[1]")
	WebElement addEmployeeDropDown;

	@FindBy(xpath = "//span[text()='Stuff']")
	WebElement addEmployeeDropDownSelect;

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
			System.out.println("Users not found!");
		}

	}

	// Delivery Boy Add

	public void clickDeliveryBoy() {
		wait.until(ExpectedConditions.elementToBeClickable(linkDeliveryBoys)).click();
	}

	public void clickaddDeliveryBoyBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(addDeliveryBoyBtn)).click();
	}

	// Customer Add

	public void clickCustomer() {
		wait.until(ExpectedConditions.elementToBeClickable(linkCustomer)).click();
	}

	public void clickCustomerBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(addCustomerBtn)).click();
	}

	// Employee Add

	public void clickEmployee() {
		wait.until(ExpectedConditions.elementToBeClickable(linkEmployee)).click();
	}

	public void clickEmployeeBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(addEmployeeBtn)).click();
	}
	
	public void clickEmployeeDropDown() {
		wait.until(ExpectedConditions.elementToBeClickable(addEmployeeDropDown)).click();
		
	}
	public void clickEmployeeSelect() {
		addEmployeeDropDownSelect.click();
	}
	
	
	// Administrators/Delivery Boy/Customer/Employee Delete

		public void chooseNameToDelete() {

			String administratorsName = "Elon Musk";
			boolean administratorsFound = false;

			// Locate all rows in the table
			List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

			for (WebElement row : rows) {
				// Find the name in each row
				WebElement nameCell = row.findElement(By.xpath(".//td[1]")); // Adjust column index
				if (nameCell.getText().equals(administratorsName)) {
					administratorsFound = true;

					// Click the "Delete" button in the same row
					WebElement deleteButton = row.findElement(By.xpath("//td/div[1]/button[2]"));

					wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();

					break;
				}
			}

			if (!administratorsFound) {
				System.out.println("Users not found!");
			}

		}

}
