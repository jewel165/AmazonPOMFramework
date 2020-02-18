package com.PageOBject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AmazonHomepage {
	
	WebDriver driver;
	
	AmazonHomepage(WebDriver rdriver){
		this.driver=rdriver;
	}
	
	//@FindBy(how=How.TAG_NAME,using="a") List<WebElement> AllLinks;
	
	//WebElement amazonLogo = driver.findElement(By.xpath("//*[@id=\"nav-logo\"]/a[1]/span[1]"));
	@FindBy(how=How.XPATH,using="//*[@id=\\\"nav-logo\\\"]/a[1]/span[1]") WebElement amazonLogo;
	
	public void getAZtittle() {
		String HPT =driver.getTitle();
		System.out.println(HPT);
	}
	
	//public void HomepageLinks() {
	//int TotalLinks	= AllLinks.size();
	//System.out.println(TotalLinks);
		
		
	//}
	
	public void VerifyLogo() {
		amazonLogo.isEnabled();
		Boolean ACTcondition =  amazonLogo.isEnabled();
		Boolean EXPcondition = true;
		Assert.assertEquals(EXPcondition,ACTcondition);
	}

}
