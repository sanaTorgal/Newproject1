package com.crm.generic.baseutility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass1
{

	@BeforeSuite
	public void configBS()
	{
		System.out.println("===connect to DB,Report config======");
		
	}
	
	@BeforeClass
	public void configBC()
	{
		System.out.println("=Lauch browser");
		
	}
	@BeforeMethod
	public void configBM()
	{
		System.out.println("===Login==");
		
	}
	
	@AfterMethod
	public void configAm()
	{
		System.out.println("Logout");
		
	}
	
	
	@AfterClass
	public void configaC()
	{
		System.out.println("==Close Browser====");
	}

	@AfterSuite
	public void configaS()
	{
		System.out.println("=====Close DB,Report backup====");
	}
	
	
	
	

}
