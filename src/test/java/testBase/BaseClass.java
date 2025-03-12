package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	//public  WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups = { "Master", "Admin", "DeliveryBoy", "Customer", "Employee" })
	// @Parameters({ "os", "browser" })
	// String os, String br
	public void setup() throws IOException {

		// Loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass()); // For showing log4j2.xml

//		switch (br.toLowerCase()) {
//		 case "chrome"  : driver = new ChromeDriver(); break;
//		 case "edge"    : driver = new EdgeDriver(); break;
//		 case "firefox" : driver = new FirefoxDriver(); break;
//		default:
//			System.out.println("Invalid Browser Name!") ; return;
//		}

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("Url"));
		driver.manage().window().maximize();

	}

	@AfterClass(groups = { "Master", "Admin", "DeliveryBoy", "Customer", "Employee" })
	public void tearDown() {
		driver.quit();
	}
	
	// To Capture Failure Cases ScreenShots
	
	  public String captureScreen(String tname) throws IOException {
	    	
	    	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	   
	        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	        
	        String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png"; 
	        File targetFile = new File(targetFilePath);
	        
	        sourceFile.renameTo(targetFile);
	        
	        return targetFilePath;
	    }
}
