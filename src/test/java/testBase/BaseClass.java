package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass()
	
	public void setup() throws IOException {
		
	// Loading config.properties file
	FileReader file = new FileReader("./src//test//resources//config.properties");
	p = new Properties();
	p.load(file);
	
	
	//logger = LogManager.getLogger(this.getClass()); //For showing log4j2.xml
	
	
		
	driver  = new ChromeDriver();
	//driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(p.getProperty("Url")); // Reading URL from properties file
	driver.manage().window().maximize();
	
	}
	
	
	@AfterClass()
	public void tearDown() {
		driver.quit();
	}
}
		
		