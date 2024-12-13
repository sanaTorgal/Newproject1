package com.pac1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Multiple_Bm 
{
	@BeforeMethod
	public void configBm1()
	{
		System.out.println("execute Bm1");
	}
	{
		System.out.println("execute Bm4");
	}
		
	@Test(invocationCount = 2)
	public void createContact()
	{
		System.out.println("execute CC");
	}
	@Test(priority=1)
	public void ceateDD()
	{
		System.out.println("execute dd");
	
	}
	@AfterMethod
	public void configAm4()
	{
		System.out.println("execute Am4");
	}
	@AfterMethod
	public void configAm1()
	{
		System.out.println("execute Am1");
	}
}
