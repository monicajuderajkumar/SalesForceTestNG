package com.salesForce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SalesForce.Base.BasePage;

public class MergeAccountsPage extends BasePage{
	public MergeAccountsPage(WebDriver driver) {
		super(driver);
	}

	  @FindBy(xpath="//input[@id='srch' and @title='Find Accounts']")
			WebElement searchTxt;
	  
	  @FindBy(xpath="//input[@class='btn' and @title='Find Accounts']")
		WebElement findAccBtn;
	  
	  @FindBy(xpath="//table[@class='list']")
		WebElement MergeTable;
	  
	  
		 @FindBy(xpath="//table[@class='list']/tbody/tr[2]/th")
			WebElement Acc1;
		 
		 public void clickfirstMergeAcc() {
				explicitWait(Acc1);
				Acc1.click();
			}
		 
		 @FindBy(xpath="//table[@class='list']/tbody/tr[3]/th")
			WebElement Acc2;
		 public void clicksecondMergeAcc() {
			 Acc2.click();
			}
		 
		 @FindBy(xpath="//input[@title='Next']")
			WebElement nextBtn;
		 
		 public void clickNextBtnMergeAcc() {
				explicitWait(nextBtn);
				nextBtn.click();
			}
		 
		 @FindBy(xpath="//input[@title='Merge']")
			WebElement mergeBtn;
		 
		 public void clickmergeBtnMergeAcc() {
				explicitWait(mergeBtn);
				mergeBtn.click();
			}
		 
	  public void entersearchTxtValue(String txt){
			explicitWait(searchTxt);
			searchTxt.sendKeys(txt);
		}
	  
	  public void clickfindAccBtn() {
			explicitWait(findAccBtn);
			findAccBtn.click();
		}
	  public boolean verifyMergeTableDisplayed() {
			explicitWait(MergeTable);
			return MergeTable.isDisplayed();
		}
	  
	  
}
