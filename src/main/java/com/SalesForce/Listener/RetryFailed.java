package com.SalesForce.Listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailed implements IRetryAnalyzer{
    int count =0;
    int maxRetry = 1;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Retrying to execute :" + result.getMethod().getMethodName());
		if(count < maxRetry) {
			count++;
			return true;
		}
		return false;
	}

}
