package com.Util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtilities {
	
	public WebDriver driver;
	public String Filepath;
	
	public void TakeScreenShott(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		Filepath = System.getProperty("user.dir")+"/ScreenShots"+"/System.currentTimeMillis()"+".png";// File name format
		File src = ts.getScreenshotAs(OutputType.FILE);// Souce of the screenShot
		File dsc = new File(Filepath);
		FileUtils.copyFile(src, dsc);
	}

}
