package com.salesForce.Pages;

import org.openqa.selenium.WebDriver;

import com.SalesForce.Base.BasePage;

public class DeveloperConsolePage extends BasePage{

	public DeveloperConsolePage(WebDriver driver) {
		super(driver);	
	}
	
	 public boolean verifyDevConsoleChildWindow() {
		  Boolean childWindowDisplayed = false;
		  explicitWaitforChildWindow(2);
		  int windowsize = verifyChildWindowisDisplayed();
		  if(windowsize>1) {
			  childWindowDisplayed = true;
		  }
		  return childWindowDisplayed;
	  }
}
