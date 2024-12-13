package com.comcast.crm.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImp implements IRetryAnalyzer
{
		int count=0,max=5;
	public boolean retry(ITestResult result)
	{
		if(count<max)
		{
			count++;;
			return true;
		}
		return false;
		
	}
	

}
