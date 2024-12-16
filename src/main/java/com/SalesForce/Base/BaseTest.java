package com.SalesForce.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.saslesForce.Utilities.ReadPropertiesFile;
import com.saslesForce.Utilities.ScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	ReadPropertiesFile readPropFile;
	ScreenShot ss; 
	String browserName;
	String URL; 
	
	public WebDriver getDriver() {
		System.out.println("Step 2:Base Test Java class is called with the browser from the test class");
		readPropFile = new ReadPropertiesFile();
        browserName = readPropFile.readFromPropFile("browser");
        System.out.println(browserName + " - browserName");
        URL = readPropFile.readFromPropFile("URL");
        
		if(browserName.equalsIgnoreCase(browserName)) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
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
}
	public String getLoginCredential(String key) {
		readPropFile = new ReadPropertiesFile();
		String value = readPropFile.readFromPropFile(key);
		return value;
	}
	public void closeBrowser() {
		//ss = new ScreenShot();
		//ss.takequickScreenShot(driver);
		driver.close();
	}
}