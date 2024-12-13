package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;
import org.testng.internal.BaseClassFinder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassobject;


public class ListenerImpClass implements ITestListener,ISuiteListener
{
	public ExtentReports report;
	public ExtentSparkReporter spark;
	public static ExtentTest test;
	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		System.out.println("Report configuration");
		String time=new Date().toString().replace(" ","_").replace(":","_");
		 // spark report config
			ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/reports_"+time+".html");
			spark.config().setDocumentTitle("CRM Test Sutie Results");
			spark.config().setReportName("CRM Report");
			spark.config().setTheme(Theme.DARK);
			

			// Add environment info and creatte an object toEntentReports
			report = new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("os", "Windows-10");
			report.setSystemInfo("browser", "chrome");
		

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String time=new Date().toString().replace(" ","_").replace(":","_");
		
		ITestListener.super.onTestFailure(result);
		String testname=result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;

		String filepath=ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath, testname+"_"+time);
		 //test.log(Status.FAIL,result.getMethod().getMethodName()+"====Failed=====");
		 test.log(Status.FAIL,result.getThrowable()+"====Failed=====");
		
	/*	File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./failedTSscreenshots/"+result.getMethod().getMethodName()+time+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		test.log(Status.SKIP,result.getMethod().getMethodName()+"====Skipped=====");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("======"+result.getMethod().getMethodName()+"====START=====");

		 test = report.createTest(result.getMethod().getMethodName());
		 UtilityClassobject.settest(test);
		 test.log(Status.INFO,result.getMethod().getMethodName()+"====STARTED=====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		 test.log(Status.PASS,result.getMethod().getMethodName()+"====completed=====");
	}
	
	
}
