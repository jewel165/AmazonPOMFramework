package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class BaseClass {



	WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentReports report;
	ExtentTest test;




	@Parameters("Browser")
	@BeforeMethod()

	public void setup(String Browser) {



		if(Browser.equalsIgnoreCase("MACchrome")) { //configure browser properties
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver-2");
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

	@BeforeTest
	public void setup() {

		reporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/Report.html");
		//reporter.loadConfig("/Users/jewel/eclipse-workspace/demo0000/extent-config.xml");
		//reporter.loadXMLConfig("/Users/jewel/eclipse-workspace/demo0000/jewel.xml");
		report= new ExtentReports();

		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Automation");
		reporter.config().setDocumentTitle("Google test");

		report.setSystemInfo("Tester", "md jewel");
		report.setSystemInfo("env", "QA");
		report.setSystemInfo("Platform", "Mac");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Sprint", "48");
		report.setSystemInfo("Test-Suite", "Regression");

		report.attachReporter(reporter);


	}

	@AfterTest
	public void Teardown() {
		report.flush();

	}



	@AfterMethod()
	public void Cleanup(ITestResult res)  {


		if(res.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "this test case paseed ");
		}
		else if(res.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "this test case failed");
			test.log(Status.FAIL, res.getThrowable());


		}
		else if(res.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "This test case was skipped, needs your attention");
			test.log(Status.SKIP, res.getThrowable());
		}

		driver.quit(); // CLOSING BROWSER AFTER EVERY TEST.
	}


}



