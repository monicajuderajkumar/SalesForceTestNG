package com.salesForce.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelRun {
WebDriver driver;

@Test
	public void chromelaunch() {
	System.out.println("Thread ID for Chrome: "+ Thread.currentThread().getId());
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	
@Test
public void loginSalesForce() {
	System.out.println("Thread ID for LoginSales: "+ Thread.currentThread().getId());
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://login.salesforce.com/");
}

@Test
	public void firefoxlaunch() {
	System.out.println("Thread ID for firefox: "+ Thread.currentThread().getId());
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/");
	}
}
