package com.Tests;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageOBject.AmazonHomepage;
import com.base.BaseClass;


public class AmazonHomepageTest extends BaseClass {
	;
	AmazonHomepage azHome = PageFactory.initElements(driver, AmazonHomepage.class);

	
	@Test
	public  void homepageTitle() {
		test=report.createTest("homepageTitle");

		
		String Tittle = driver.getTitle();
		System.out.println(Tittle);

	}
	@Test
	public void checkAmazonLogo() {
		test=report.createTest("checkAmazonLogo");

		//AmazonHomepage azh =PageFactory.initElements(driver, AmazonHomepage.class);
		//azh.VerifyLogo();
		WebElement amazonLogo = driver.findElement(By.xpath("//*[@id='nav-logo']/a[1]/span[1]"));
		amazonLogo.isEnabled();
		Boolean ACTcondition =  amazonLogo.isEnabled();
		Boolean EXPcondition = true;
		Assert.assertEquals(EXPcondition,ACTcondition);

	}

	@Test
	public void TotalHomePageLinks() {
		test=report.createTest("TotalHomePageLinks");	
	List<WebElement> linkList=	driver.findElements(By.tagName("a"));
	int LinkListSize = linkList.size();
	System.out.println("Total Count of link in Homepage is: "+LinkListSize);
	
		
	}


}
