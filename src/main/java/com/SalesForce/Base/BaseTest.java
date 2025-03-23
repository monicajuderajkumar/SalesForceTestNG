package com.SalesForce.Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.saslesForce.Utilities.ReadPropertiesFile;
import com.saslesForce.Utilities.ScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class BaseTest {

	public static WebDriver driver;
	ReadPropertiesFile readPropFile;
	ScreenShot ss; 
	String browserName;
	String URL; 
	String projDir = System.getProperty("user.dir");
	String pathToDownload = projDir +"\\Downloads";
	public Logger log;
	public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
	
	//Launch browser - feature code- DAy1
	
	public WebDriver lauchApplication() {
	
	 log= LogManager.getLogger(BaseTest.class.getClass());
		log.info("Launch application - Reads Properties file");
		System.out.println("Step 2:Base Test Java class is called with the browser from the test class");
		readPropFile = new ReadPropertiesFile();
        browserName = readPropFile.readFromPropFile("browser");
        System.out.println(browserName + " - browserName");
        URL = readPropFile.readFromPropFile("URL");
       
		if(browserName.equalsIgnoreCase(browserName)) {
			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> chromePref = new HashMap<String, Object>();
			chromePref.put("profile.default_content_settings.popups" , 0);
			chromePref.put("download.default_directory" , pathToDownload);
			options.setExperimentalOption("prefs", chromePref);
			
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		//threadDriver.set(new ChromeDriver(options));
	//threadDriver.get().get(URL);
		//threadDriver.get().manage().deleteAllCookies();
		//threadDriver.get().manage().window().maximize();
		driver.get(URL);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		} 
		else if (browserName.equalsIgnoreCase(browserName)) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			 driver.get(URL);
			 driver.manage().deleteAllCookies();
			 driver.manage().window().maximize();
			 
		}
		return driver;
		//return threadDriver.get();
}
	public String getLoginCredential(String key) {
		readPropFile = new ReadPropertiesFile();
		String value = readPropFile.readFromPropFile(key);
		return value;
	}
	
	public String quickphoto(WebDriver driver, String TestCaseName) {
	  ss = new ScreenShot();
	  String filePath = ss.takequickScreenShot(driver , TestCaseName);
	  return filePath;
	}
	
	public void getJsonData() {
		
	}
	public void closeBrowser() {
		//threadDriver.get().close();
		driver.close();
	}
}