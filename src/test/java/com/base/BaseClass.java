package com.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class BaseClass {



	public WebDriver driver;
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest test;
	public String Filepath;





	@Parameters("Browser")
	@BeforeMethod()

	public void setupdriver(String Browser) {



		if(Browser.equalsIgnoreCase("MACchrome")) { //configure browser properties
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver");
			driver = new ChromeDriver();//initiate the chrome browser for mac
		}

		else if(Browser.equalsIgnoreCase("WINchrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver();//initiate the Chrome browser in WIndows
		}

		driver.get("https://www.amazon.com");// get to requested URL/DOMAIN
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



	}

	@BeforeSuite
	public void setup() {

		reporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/Report.html");
		//reporter.loadConfig("/Users/jewel/eclipse-workspace/demo0000/extent-config.xml");
		//reporter.loadXMLConfig("/Users/jewel/eclipse-workspace/demo0000/jewel.xml");
		report= new ExtentReports();

		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Automation");
		reporter.config().setDocumentTitle("Amazon Test");

		report.setSystemInfo("Tester", "md jewel");
		report.setSystemInfo("env", "QA");
		report.setSystemInfo("Platform", "Mac");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Sprint", "48");
		report.setSystemInfo("Test-Suite", "Regression");

		report.attachReporter(reporter);


	}

	@AfterSuite
	public void Teardown() {
		report.flush();

	}



	@AfterMethod()
	public void Cleanup(ITestResult res) throws Exception  {
		/*

		if(res.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "this test case paseed ");
		}
		else if(res.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "this test case failed");
			test.log(Status.FAIL, res.getThrowable());
			TakeScreenShott(driver);
			test.addScreenCaptureFromPath(Filepath);
			


		}
		else if(res.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "This test case was skipped, needs your attention");
			test.log(Status.SKIP, res.getThrowable());
		}
	*/
		driver.quit(); // CLOSING BROWSER AFTER EVERY TEST.
	}
	
	public void TakeScreenShott(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		Filepath = System.getProperty("user.dir")+"/ScreenShots"+"/System.currentTimeMillis()"+".png";// File name format
		File src = ts.getScreenshotAs(OutputType.FILE);// Souce of the screenShot
		File dsc = new File(Filepath);
		FileUtils.copyFile(src, dsc);
	}


}



