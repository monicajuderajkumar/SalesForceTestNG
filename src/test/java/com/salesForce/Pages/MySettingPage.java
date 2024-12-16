package com.salesForce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SalesForce.Base.BasePage;

public class MySettingPage extends BasePage{

	  public MySettingPage(WebDriver driver) {
		  super(driver);
	  }
	  
	  @FindBy(css="a[title='My Settings']")
	  WebElement MySettingsLink;
	  
	  @FindBy(css="span#PersonalInfo_font")
	  WebElement personalLink;
	  
	  @FindBy(css="span#LoginHistory_font")
	  WebElement loginHistory;
	  
	  @FindBy(css="div.pShowMore a")
	  WebElement downloadHistory;
	  
	  public void clickonMySettingLink(){
			explicitWait(MySettingsLink);
			MySettingsLink.click();
		}
	  
	  public void clickonpersonalLink(){
			explicitWait(personalLink);
			personalLink.click();
		}
	  
	  public void clickonLoginHistoryLink(){
			explicitWait(loginHistory);
			loginHistory.click();
		}
	  
	  public void clickonDownLoadFileLink(){
			explicitWait(downloadHistory);
			downloadHistory.click();
		}
	  
	  
}
