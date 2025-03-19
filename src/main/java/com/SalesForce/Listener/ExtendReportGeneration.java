package com.SalesForce.Listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportGeneration {

	public static ExtentReports getReports() {
		
		String projDir = System.getProperty("user.dir");
		String path = projDir+"\\reports\\extendReport.html";
		ExtentSparkReporter sparkreport = new ExtentSparkReporter(path);
		sparkreport.config().setReportName("Sales Force Report Name");
		sparkreport.config().setDocumentTitle("Sales Force Test Result");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(sparkreport);
		report.setSystemInfo("Tester", "Monica");
		return report;
	}
}
