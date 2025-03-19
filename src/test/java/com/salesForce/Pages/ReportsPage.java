package com.salesForce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.SalesForce.Base.BasePage;

public class ReportsPage extends BasePage{

	public ReportsPage(WebDriver driver) {
		super(driver);
		
	}
	
	 @FindBy(xpath="//input[@name='duration']")
		WebElement RangeDropDown;
	 
	 public void clickonRangeDropDown(){
			explicitWait(RangeDropDown);
			RangeDropDown.click();
		}
	 
	 @FindBy(xpath="//div[@class='x-combo-list-inner']//div[text()='All Time']")
		WebElement SelectAllTime;
	 
	 public void moveToSelectAllTimeClick(){
		 moveToElementAndClick(SelectAllTime);
		}
	 @FindBy(xpath="//button[text()='Run Report']")
		WebElement runReportBtn;
	 
	 public void clickonRunReportBtn(){
			explicitWait(runReportBtn);
			runReportBtn.click();
		}
	 
	 @FindBy(xpath="//input[@title='Save As']")
		WebElement saveAsListReport;
	 
	 public void clickonsaveAsListReport(){
			explicitWait(saveAsListReport);
			saveAsListReport.click();
		}
	
	 @FindBy(id="report_name")
		WebElement reportNameTxt;
		
		public void enterreportNameTxt(String txt) {
			explicitWait(reportNameTxt);
			reportNameTxt.sendKeys(txt);
		}
		
		@FindBy(id="devName")
		WebElement reportUniqueNameTxt;
		
		public void enterreportUniqueNameTxt(String txt) {
			explicitWait(reportUniqueNameTxt);
			reportUniqueNameTxt.sendKeys(txt);
		}
		
		@FindBy(xpath="//input[@title='Save & Return to Report']")
		WebElement saveReturntoReport;
		
		public void clickonsaveReturntoReport() {
			explicitWait(saveReturntoReport);
			saveReturntoReport.click();
		}
		
		
		@FindBy(xpath="//h1[@class='noSecondHeader pageType']")
		WebElement reportNameSaved;
		
		public String getreportNameSaved() {
			explicitWait(reportNameSaved);
			String reportNameValue = reportNameSaved.getText().trim();
			if(reportNameValue.equals("")) {
				reportNameValue = reportNameSaved.getAttribute("value").trim();
			}
			return reportNameValue;
		}
		
		 
}
