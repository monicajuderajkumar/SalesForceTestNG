package com.saslesForce.Utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {


	
	public void takequickScreenShot(WebDriver driver) {
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
		String ProjDir = System.getProperty("user.dir");
		Date currentDate = new Date();
		String date = new SimpleDateFormat("YYYY-MM-dd HH.mm.ss").format(currentDate);
		String filePath = ProjDir +"\\ScreenShot\\SS"+date+".png";
		System.out.println(filePath);
		File desFile = new File(filePath);
		try {
			FileUtils.copyFile(scrFile, desFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*public static void main(String[] args) {
		String ProjDir = System.getProperty("user.dir");
		System.out.println(ProjDir);
	   filePath =ProjDir+ "\\ScreenShot\\ScreenShot.png";
		Date currentDate = new Date();
		System.out.println(currentDate);
		String currentTimeStamp = new SimpleDateFormat("YYYY-MM-dd HH-mm-ss").format(currentDate);
		System.out.println(currentTimeStamp);
		filePath =ProjDir+ "\\ScreenShot\\ScreenShot"+currentTimeStamp+".png";
		System.out.println(filePath);
	}*/
}
