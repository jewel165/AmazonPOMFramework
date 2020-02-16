package com.PageOBject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class AmazonLoginPage {

	
	WebDriver driver;

	public AmazonLoginPage(WebDriver ldriver) {

		this.driver=ldriver;
		
		}
	
	
	
	// Stated SignIn Related Elemets/methods
	@FindBy(how=How.ID,using="nav-link-accountList")
	WebElement AccountList;
	

	@FindBy(how=How.ID,using="ap_email")
	WebElement EmailField;

	@FindBy(how=How.ID,using="continue")
	WebElement BTN_Continue1 ;

	@FindBy(how=How.ID,using="ap_password")
	WebElement PasswordField ;

	@FindBy(how=How.ID,using="signInSubmit")
	WebElement BTN_signInSubmit;

	@FindBy(how=How.ID,using="nav-hamburger-menu")
	WebElement HamburgerMenu ;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span")
	WebElement LogInErrorMessage ;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"auth-error-message-box\"]/div/div")
	WebElement EmailErrorMessageBox;

	@FindBy(how=How.XPATH,using="//*[@id=\"hmenu-content\"]/ul[35]/li[47]/a/div")
	WebElement BTN_SignOut;
	
	
	public void ClickonAccount() {
		AccountList.click();
	}

	public void TypeEmail(String Email) {
		EmailField.sendKeys(Email);
	}

	public void ClickOnContinue() {
		BTN_Continue1.click();
	}

	public void TypePassword(String Password) {
		PasswordField.sendKeys(Password);
	}
	public void ClickOnSignInBTN() {
		BTN_signInSubmit.click();
	}
	
	public boolean VerifyUserName(boolean userName) {
		userName=false;
		boolean expectedName=driver.getPageSource().contains("Mohammed");
		if(expectedName==true) {
			userName=expectedName;
		}
		return userName;
	}
	
	public void VerifyLogInError(String erMessage) {
		String message = LogInErrorMessage.getText();
		//erMessage=false;
		if(message==erMessage) {
			System.out.println("Error Message is valid");
		}
		
	}

	public void ClickOnHamburgerBTN() throws Exception {
		HamburgerMenu.click();
		Thread.sleep(4000);
	}

	public void ClickOnSinOutBTN() {
		BTN_SignOut.click();

	}
	
	public void VerifyInvalidPassword_Error(String PassErr_MSG) {
		String actualMSG = EmailErrorMessageBox.getText();
		System.out.println(actualMSG);
		if(actualMSG.contains(PassErr_MSG)) {
			System.out.println("Found expected Error Message");
		}
		
	}
	//<<<<< Ended SignIn related elements/methods>>>>>





}
