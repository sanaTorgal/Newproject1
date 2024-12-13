package listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class ListenerImplementation implements ITestListener,ISuiteListener
{
	JavaUtility jlib=new JavaUtility();
	@Override
	public void onFinish(ISuite suite)
	{
		System.out.println( "on suite finish ");
		ISuiteListener.super.onFinish(suite);
	}

	@Override
	public void onStart(ISuite suite) 
	{
		System.out.println( "on start of suite");
		ISuiteListener.super.onStart(suite);
	
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		
		System.out.println( "on finish of test");
		ITestListener.super.onFinish(context);
	}

	@Override
	public void onStart(ITestContext context)
	{
		System.out.println( "on Test Start");
		ITestListener.super.onStart(context);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		System.out.println( "On Test failed WithinSuccessPercentage  ");
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		System.out.println( "On Test failed With Timeout");
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println( "On Test failure");
		ITestListener.super.onTestFailure(result);
		System.out.println(result.getName());
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./failedTSscreenshots/"+result.getName()+jlib.getRandomNo()+".png");
		
		try {
				FileHandler.copy(src, dest);
		
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println(result.getName()+"Test is fail");
		
			
		
				
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println( "on Test skipped");
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println( "on Start of @Test  ");
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("on success of @Test");
		ITestListener.super.onTestSuccess(result);
	}
	
	
	

}
