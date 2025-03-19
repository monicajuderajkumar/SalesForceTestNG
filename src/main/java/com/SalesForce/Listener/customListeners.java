package com.SalesForce.Listener;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.SalesForce.Base.BasePage;
import com.SalesForce.Base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class customListeners extends BaseTest implements ITestListener {
	ExtentTest test;
	//ExtendReportGeneration reportGn = new ExtendReportGeneration();
	// Calling static method method from ExtendReportGeneration class
	ExtentReports xtnreport = ExtendReportGeneration.getReports();
	// To make it thread safe
	//ThreadLocal<ExtentTest> threadsafeTest = new ThreadLocal<ExtentTest>();
	//ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
	
	
	public void onTestStart(ITestResult result) {
		System.out.println("*******THread ID:" + Thread.currentThread().getId());
		//createTest returns ExtentTest
		test = xtnreport.createTest(result.getMethod().getMethodName());
	//	threadsafeTest.set(test); // Unique thread id will be assigned to this test   
		
	}

	  /**
	   * Invoked each time a test succeeds.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS
	   */
	public void onTestSuccess(ITestResult result) {
	
	  }

	  /**
	   * Invoked each time a test fails.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#FAILURE
	   */
	public void onTestFailure(ITestResult result) {
		//threadsafeTest.get().log(Status.FAIL, "Failed");
		//threadsafeTest.get().fail(result.getThrowable());
		 String testCaseName = result.getMethod().getMethodName();
		 System.out.println("TestCase Neme " +  result.getMethod().getMethodName());
		
	 try {
		 driver =(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	} 
	 //String filePath = quickphoto(driver, testCaseName);
	 //threadsafeTest.get().addScreenCaptureFromPath(filePath, testCaseName);
	 //threadsafeTest.get().addScreenCaptureFromPath(filePath);
	  }

	  /**
	   * Invoked each time a test is skipped.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SKIP
	   */
	public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	  /**
	   * Invoked each time a method fails but has been annotated with successPercentage and this failure
	   * still keeps it within the success percentage requested.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	   */
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  /**
	   * Invoked each time a test fails due to a timeout.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   */
	public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  /**
	   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt;
	   * tag and calling all their Configuration methods.
	   *
	   * @param context The test context
	   */
	public void onStart(ITestContext context) {
	    // not implemented
	  }

	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
	   * run and all their Configuration methods have been called.
	   *
	   * @param context The test context
	   */
	public void onFinish(ITestContext context) {
		xtnreport.flush();
	  }
}
