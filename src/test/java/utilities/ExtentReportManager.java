package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter; // Spark Reporter
	public ExtentReports extent; // Extent Reports instance
	public ExtentTest test; // Individual test log
	String repName; // Report file name

	public void onStart(ITestContext testContext) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);

		// Configure the SparkReporter appearance
		sparkReporter.config().setDocumentTitle("FoodKing Automation Test Report");
		sparkReporter.config().setReportName("FoodKing DDT Testing");
		sparkReporter.config().setTheme(Theme.DARK);

		// Attach SparkReporter to ExtentReports
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		// Add system info to the report
		extent.setSystemInfo("Application", "FoodKing");
		extent.setSystemInfo("Module", "LoginDDT");
		extent.setSystemInfo("Sub Module", "Login");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");

		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);

		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);

		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
		}

	}

	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); // To display groups in report
		test.log(Status.PASS, result.getName() + "got successfully executed");

	}

	// Failed Test Cases Screenshots/Capture
	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() + " got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());

		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public void onFinish(ITestContext testContext) {

		extent.flush();

		String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
		File extentReport = new File(pathOfExtentReport);

		try {
			Desktop.getDesktop().browse(extentReport.toURI());

		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * try {
		 * 
		 * URL url = new
		 * URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
		 * 
		 * 
		 * // Create the email message ImageHtmlEmail email = new ImageHtmlEmail();
		 * email.setDataSourceResolver(new DataSourceUrlResolver(url));
		 * email.setHostName("smtp.googlemail.com"); email.setSmtpPort(465);
		 * email.setAuthenticator(new
		 * DefaultAuthenticator("tahamidul.simec@gmail.com","password"));
		 * email.setSSLOnConnect(true); email.setFrom("tahamidulhaque01@gmail.com"); //
		 * Sender email.setSubject("Test Results");
		 * email.setMsg("Please find the Attached Report...");
		 * email.addTo("tahamid.busyqa@gmail.com"); //Receiver
		 * email.attach(url,"extent report", "please check report..."); email.send(); //
		 * send the email
		 * 
		 * }catch(Exception e) { e.printStackTrace(); }
		 */

	}

}
