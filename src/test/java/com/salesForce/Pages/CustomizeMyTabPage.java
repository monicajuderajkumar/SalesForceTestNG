package com.salesForce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SalesForce.Base.BasePage;

public class CustomizeMyTabPage extends BasePage{

	public CustomizeMyTabPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@class='btnImportant']")
	WebElement CustomizeMyTabs;
	
	public void clickOnCustomizeMyTabs() {
		explicitWait(CustomizeMyTabs);
		CustomizeMyTabs.click();
	}
	
	@FindBy(xpath="//select[@id='duel_select_0']")
	WebElement availableTabs;
	
	@FindBy(xpath="//img[@class='rightArrowIcon']")
	WebElement addBtn;
	
	@FindBy(xpath="//input[@name='save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//select[@id='duel_select_1']")
	WebElement selectedTabs;
	
	@FindBy(xpath="//img[@class='leftArrowIcon']")
	WebElement removeBtn;
	
	public void clickOnRemoveBtn() {
		explicitWait(removeBtn);
		removeBtn.click();
	}
	
	public void clickOnsaveBtn() {
		explicitWait(saveBtn);
		saveBtn.click();
	}
	
	public void clickOnaddBtn() {
		explicitWait(addBtn);
		addBtn.click();
	}
	
	public void selectAvailableDropDown() {
		  explicitWait(availableTabs);
		  selectDropDown(availableTabs, "Assets" , "selectByVisibleText");
	  }
	
	public void selectSelectedDropDown() {
		  explicitWait(selectedTabs);
		  selectDropDown(selectedTabs, "Assets" , "selectByVisibleText");
	  }
}
