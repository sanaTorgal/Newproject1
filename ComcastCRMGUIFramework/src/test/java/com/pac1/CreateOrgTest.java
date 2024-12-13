package com.pac1;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateOrgTest 
{
	@BeforeSuite
	public void configbS()
	{
		System.out.println("execute Bs");
		
	}
	
	@BeforeClass
	public void configbc()
	{
		System.out.println("execute BC");
		
	}
	
	@BeforeMethod
	public void configBm()
	{
		System.out.println("execute BM");
		
	}
	@Test
	public void createorgTest()
	{
		System.out.println("execute createorgTest");
	}
	@AfterMethod
	public void configAm()
	{
		System.out.println("execute AM");
		
	}
	@AfterClass
	public void configaC()
	{
		System.out.println("execute AC");
	}
	@Test
	public void createOrgwithIndustry()
	{
		System.out.println("execute createOrgwithIndustry");
	}
	@AfterSuite
	public void configaS()
	{
		System.out.println("execute AS");
	}

	
	
	
	
}
