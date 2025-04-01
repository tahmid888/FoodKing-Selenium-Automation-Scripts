package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testBase.BaseClass;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;

public class DinningTableQRScanPage extends BasePage {

	public DinningTableQRScanPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='Dining Tables']")
	WebElement linkDinningTable;
	
	@FindBy(xpath = "//tbody/tr[1]/td[4]/div[1]/a[2]/i[1]")
	WebElement viewDinningTable;

	@FindBy(xpath = "//img[@alt='qrcode']")
	WebElement qrScanCode;

	@FindBy(xpath = "//span[normalize-space()='Add Tables']")
	WebElement addTableBtn;

	@FindBy(xpath = "//input[@id='name']")
	WebElement setTableName;

	@FindBy(xpath = "//input[@id='size']")
	WebElement setTableSize;
	
	@FindBy(xpath = "//input[@id=\"active\"]")
	WebElement checkActive;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement saveBtn;

	// Explicit waits
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void clickDinningTable() {
		wait.until(ExpectedConditions.elementToBeClickable(linkDinningTable)).click();
	}

	//public void clickViewBtn() {
	//	viewDinningTable.click();
	//}

	public void qrCodeElement() {
		wait.until(ExpectedConditions.elementToBeClickable(qrScanCode));
		// WebElement qrScanCode;
	}

	public void qrCode() throws Exception {
		// Take a screenshot of the QR code element
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File qrImage = new File("qrcode.png");
		FileHandler.copy(screenshot, qrImage);

		// Read the QR code from the image
		BufferedImage bufferedImage = ImageIO.read(qrImage);
		BinaryBitmap binaryBitmap = new BinaryBitmap(
				new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
		Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap);

		// Extract the QR code text
		String qrText = qrCodeResult.getText();
		System.out.println("QR Code Data: " + qrText);

		// Open the extracted URL in the browser
		driver.get(qrText);

        // Open the extracted URL in a new tab
       // ((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", qrText);
	}

	public void clickAddTable() {
		addTableBtn.click();
	}

	public void setName(String name) {
		setTableName.sendKeys(name);
	}

	public void setSize(String size) {
		setTableSize.sendKeys(size);
	}

	public void clickActiveBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(checkActive)).click();
		//checkActive.click();
	}

	public void clickSaveBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
		
	}

	
	// Search Name and View the specific QR Scan
	public void chooseNameToView(String QRScanName) {
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

		for (WebElement row : rows) {
			WebElement nameCell = row.findElement(By.xpath(".//td[1]"));
			if (nameCell.getText().trim().equalsIgnoreCase(QRScanName)) {
				WebElement viewButton = row.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/a[2]/i[1]"));

				wait.until(ExpectedConditions.elementToBeClickable(viewButton)).click();
				return;
			}
		}
		System.out.println("Table name not found: " + QRScanName);
	}

}