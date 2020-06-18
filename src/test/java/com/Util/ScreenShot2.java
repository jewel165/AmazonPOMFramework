package com.Util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class ScreenShot2 {
	
	WebDriver driver;
	
	public void TakeScreenShott(WebDriver driver) throws Exception {
		TakesScreenshot ts =   (TakesScreenshot)driver;
		String Filepath = "SeleniumScreenShot.png";
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(Filepath);
		FileUtils.copyDirectory(src, src);
			
			
		}
}
