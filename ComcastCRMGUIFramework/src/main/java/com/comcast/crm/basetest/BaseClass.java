package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DatabaseUtility1;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassobject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass 
{
	//create object
	 public WebDriver driver=null;

	 public FileUtility flib=new FileUtility();
	 public ExcelUtility elib=new ExcelUtility();
	 public WebDriverUtility wlib=new WebDriverUtility();
	 public JavaUtility jlib=new JavaUtility();
	 public DatabaseUtility1 dlib=new DatabaseUtility1();
	 public static WebDriver sdriver;
	
	
	@BeforeSuite (alwaysRun = true)
	public void configBS() throws Throwable
	{
		System.out.println("===connect to DB,Report config======");
		//dlib.getDataBaseconnection();
		
	}
	
//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable
	{
		System.out.println("***Lauch browser*****");
		String BROWSER = flib.getdatafromPropertiesFile("browser");
		//String BROWSER=browser;
		String URL = flib.getdatafromPropertiesFile("url");
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}
		wlib.waitForPageLoad(driver);
		wlib.geturl(driver, URL);
		wlib.maximize(driver);	
		sdriver=driver;
		UtilityClassobject.setdriver(driver);
	}
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable
	{
		System.out.println("===Login==");
		
		
		String USERNAME = flib.getdatafromPropertiesFile("username");
		String PASSWORD = flib.getdatafromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(USERNAME,  PASSWORD);
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAm()
	{
		System.out.println("Logout");
		
		HomePage hp=new HomePage(driver);
		hp.signOut(driver);
		
	}
	
	
	@AfterClass(alwaysRun = true)
	public void configaC()
	{
		System.out.println("==Close Browser====");
		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void configaS() throws Throwable
	{
		System.out.println("=====Close DB,Report backup====");
		//dlib.closeConnection();
	}
	
	
	
	
}
