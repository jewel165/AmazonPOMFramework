package com.Tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.PageOBject.AmazonLoginPage;
import com.base.BaseClass;

public class AmazonLoginTest extends BaseClass {
	//WebDriver driver;
	// public AmazonLoginPage azl = new AmazonLoginPage(driver);
	
	@Test(priority=1)
	public void LoginwithValidINFO() throws Exception {
		test=report.createTest("LoginwithValidINFO");

		AmazonLoginPage azl = PageFactory.initElements(driver,AmazonLoginPage.class );
		azl.ClickonAccount();
		azl.TypeEmail("juie165@yahoo.com");
		azl.ClickOnContinue();
		azl.TypePassword("bk11208bk");
		azl.ClickOnSignInBTN();
		azl.VerifyUserName(true);
		azl.ClickOnHamburgerBTN();
		azl.ClickOnSinOutBTN();

	}
	@Test(priority=3)
	public void LogIn_ValidEmail_invalidPass() {
		test=report.createTest("LogIn_ValidEmail_invalidPass");
		
		//AmazonLoginPage azl = new AmazonLoginPage(driver);
		AmazonLoginPage azl = PageFactory.initElements(driver,AmazonLoginPage.class );

		azl.ClickonAccount();
		azl.TypeEmail("juie165@yahoo.com");
		azl.ClickOnContinue();
		azl.TypePassword("bk11208");
		azl.ClickOnSignInBTN();
		azl.VerifyLogInError("Your password is incorrect");

	}

	@Test(priority=2)
	public void LogIn_Invlid_Email() {
		test=report.createTest("LogIn_Invlid_Email");
		//AmazonLoginPage azl = new AmazonLoginPage(driver);
		AmazonLoginPage azl = PageFactory.initElements(driver,AmazonLoginPage.class );

		azl.ClickonAccount();
		azl.TypeEmail("juie165@yahoo.com");
		azl.ClickOnContinue();
		azl.VerifyLogInError("cannot find an account");
	}


}
