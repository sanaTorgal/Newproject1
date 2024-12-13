package com.comcast.crm.orgtest1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

public class CreateOrgTest extends BaseClass
{
	
	@Test
	public void createorgtTest()
	{
		System.out.println("execute createcorgand verify");
	}
	
	@Test
	public void createOrgwithindustry()
	{
		System.out.println("execute org with industry and verify ");
	}
	


	
}
