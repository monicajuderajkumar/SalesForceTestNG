package com.SalesForce.Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


//Feature_code_2 - First Commit
// Base Page - Main Commit
//Feature_Code - BAse Page commit

public class BasePage {

	WebDriver driver;
	Actions act ;
	String projDir = System.getProperty("user.dir");
	String pathToDownload = projDir +"\\Downloads";
	String elementName;
	// Initiate all the webElement in that page in Page Factory model`1
	public BasePage(WebDriver driver) {
		System.out.println("Step 3: PageFactory");
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void takeScreenShot() {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//TakesScreenshot screenshot = ((TakesScreenshot)driver);
		//File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
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
	
	public void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver , 10);
				wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void explicitWaitforChildWindow(int numChildWin) {
		WebDriverWait wait = new WebDriverWait(driver , 60);
				wait.until(ExpectedConditions.numberOfWindowsToBe(numChildWin));
	}
	public void implicitWait(int Sec) {
		driver.manage().timeouts().implicitlyWait(Sec, TimeUnit.SECONDS);
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
	
	public void moveToElementAndClick(WebElement element) {
		act = new Actions(driver);
		explicitWait(element);
		act.moveToElement(element).click().build().perform();
	}
	
	public void selectDropDown(WebElement dropdown, String selectOption , String selMethod) {
		  Select sel = new Select(dropdown);
		  System.out.println("DropDown Element : " + dropdown);
		  System.out.println("selectOption : " + selectOption);
		  System.out.println("selMethod : " + selMethod);
		  
		  if(selMethod.equalsIgnoreCase("selectByVisibleText")) {
		  sel.selectByVisibleText(selectOption);
		  } else if(selMethod.equalsIgnoreCase("selectByValue")) {
			  sel.selectByValue(selectOption);
			  }else if(selMethod.equalsIgnoreCase("selectByIndex")) {
				  int indexValue = Integer.parseInt(selMethod);
				  sel.selectByIndex(indexValue);
				  }
		  
	  }
	
	public void fluentWait() {
		System.out.println("Fluent wait");
		File file = new File(pathToDownload, "*.csv");
		System.out.println(file.exists());
		System.out.println(file.getName().toString());
		FluentWait<File> fwait = new FluentWait<File>(file)
				.withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(Exception.class)
				.withMessage("File is not downloaded");
		
		Boolean isDownloaded = fwait.until(f -> f.exists());
		
		if(isDownloaded) {
			System.out.println("File is fully downloaded");
		}else {
			System.out.println("File is not downloaded");
		}
		
	}
	
	public int verifyChildWindowisDisplayed() {
		WebDriverWait w = new WebDriverWait(driver, 60);
		w.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> windows = driver.getWindowHandles();
		   System.out.println("How many windows:" + windows.size());
		   Iterator<String> it = windows.iterator();
		   String parentwindow = it.next();
		   String childWindow = it.next();
		   System.out.println("Parent Window: "+ driver.getTitle());
		   driver.switchTo().window(childWindow);
		   System.out.println("Child Window: "+ driver.getTitle());
		   return windows.size();
	}
	
	 public void closeChildWindow() {
		 System.out.println("****Close Child Window ******");
		 Set<String> windows = driver.getWindowHandles();
		   System.out.println("How many windows:" + windows.size());
		   Iterator<String> it = windows.iterator();
		   String parentwindow = it.next();
		   String childWindow = it.next();
		   
		   System.out.println("Parent Window: "+ parentwindow);
		   System.out.println("Child Window: "+ childWindow);
		   driver.switchTo().window(childWindow);
		   System.out.println("Child Window URL: "+ driver.getTitle());
		   driver.switchTo().window(childWindow).close();
		   driver.switchTo().window(parentwindow);
	 }
	 
	 public String verifySelOptioninDropDown(WebElement element) {
		     explicitWait(element);
			 Select selverify = new Select(element);
			 WebElement selectedwebelement = selverify.getFirstSelectedOption();
			 String selectedoptionDropDown = selectedwebelement.getText();
			 return selectedoptionDropDown;
			 
		 }
   public void acceptAlert() {
	   driver.switchTo().alert().accept();
   }
   
   public int getwebTableRowSize(String xpathValue) {
    System.out.println("xpathValue:" + xpathValue);
   List<WebElement> rowList = driver.findElements(By.xpath(xpathValue));
   int rowSize = rowList.size();
   System.out.println("Row Size: "+ rowSize);
   return rowSize;
   }
   
   public String getValueFromTable(String rowSizeXpath, String rowElementBeforeXpath, String rowElementAfterXpath, String accName) {
	   
	   int rowSize = getwebTableRowSize(rowSizeXpath);
	  System.out.println("Row Size - getValueFromTable: "+ rowSize);
	  for(int i=2; i<=rowSize; i++) {
		  String actualXpath= rowElementBeforeXpath+i+rowElementAfterXpath;
		  System.out.println(actualXpath);
		  WebElement element = driver.findElement(By.xpath(actualXpath));
		  System.out.println(element.getText());
		  elementName = element.getText().trim();
		  if((elementName).equalsIgnoreCase(accName)) {
			  System.out.println("Found Contact" + elementName);
			  break;	 
		  }
		  
	  }
	  return elementName;
   }
   
   
 public void selectValueFromTable(String rowSizeXpath, String rowElementBeforeXpath, String rowElementAfterXpath, String accName) {
	   
	   int rowSize = getwebTableRowSize(rowSizeXpath);
	  System.out.println("Row Size - getValueFromTable: "+ rowSize);
	  for(int i=2; i<=rowSize; i++) {
		  String actualXpath= rowElementBeforeXpath+i+rowElementAfterXpath;
		  System.out.println(actualXpath);
		  WebElement element = driver.findElement(By.xpath(actualXpath));
		  System.out.println(element.getText());
		  elementName = element.getText().trim();
		  if((elementName).equalsIgnoreCase(accName)) {
			  System.out.println("Found Contact" + elementName);
			  element.findElement(By.tagName("a")).click();
			  break;	 
		  }
		  
	  }
	 
   }
   public void switchToWindow(String WindowName) {
		System.out.println("Switch to Window: "+ WindowName);
		//w = new WebDriverWait(driver, 60);
		//w.until(ExpectedConditions.numberOfWindowsToBe(2));
		
			Set<String> windows = driver.getWindowHandles();
			   System.out.println("How many windows:" + windows.size());
			   if(windows.size()>1) {
				   System.out.println("Window size is greater than 1: "+ windows.size());
				   Iterator<String> it = windows.iterator();
				   String parentwindow = it.next();
				   String childWindow = it.next();
				   System.out.println("Parent Window: "+ driver.getTitle());
				   
				   if (WindowName.equalsIgnoreCase("parentWindow")) {
					   driver.switchTo().window(parentwindow);  
				   }else if (WindowName.equalsIgnoreCase("childwindow")) {
					   driver.switchTo().window(childWindow);  
				   }
				    
			   } else if ((windows.size() == 1) && (WindowName.equalsIgnoreCase("parentWindow"))) {
				   System.out.println("Window size is equal to 1: "+ windows.size());
				   Iterator<String> it = windows.iterator();
				   String parentwindow = it.next();
				   driver.switchTo().window(parentwindow);
			   }
			  		}
}
