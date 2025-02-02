package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends BasePage{

	public EditProfilePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//body//div//header//div//div//a[2]")
	WebElement lnkEditProfile;
	
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='last_name']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='phone']")
	WebElement txtPhone;
	
	@FindBy(xpath = "//button[normalize-space()='Update Profile']")
	WebElement btnUpdateProfile;
	
	public void clickEditProfile() {
		lnkEditProfile.click();
	}
	public void setFirstName(String fname ) {
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String lname) {
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	public void setPhone(String phone) {
		txtPhone.clear();
		txtPhone.sendKeys(phone);
	}
	public void clickUpdateProfileBtn() {
		
		btnUpdateProfile.click();
	}
	
}
