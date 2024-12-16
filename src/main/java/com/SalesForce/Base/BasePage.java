package com.SalesForce.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	Actions act ;
	
	// Initiate all the webElement in that page in Page Factory model`1
	public BasePage(WebDriver driver) {
		System.out.println("Step 3: PageFactory");
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver , 10);
				wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchTodefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	public void sendpathToBrowsweinWindows(WebElement element, String path){
		explicitWait(element);
		element.sendKeys(path);
	}
	
	public void cropImg(WebElement element, int xOffset, int yOffSet ) {
		act = new Actions(driver);
		explicitWait(element);
		act.clickAndHold(element).moveByOffset(xOffset, yOffSet).release().build().perform();
	}
	
	public void moveToElement(WebElement element) {
		act = new Actions(driver);
		 act.moveToElement(element).build().perform();
	}

}
