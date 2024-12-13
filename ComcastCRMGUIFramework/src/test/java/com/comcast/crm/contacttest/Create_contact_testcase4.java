package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class Create_contact_testcase4 
{

	public static void main(String[] args) throws Throwable
	{
		// utilities
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		
		//Read data from propeties file
		
		String BROWSER = flib.getdatafromPropertiesFile("browser");
		String URL=flib.getdatafromPropertiesFile("url");
		String USERNAME=flib.getdatafromPropertiesFile("username");
		String PASSWORD=flib.getdatafromPropertiesFile("password");
		
		//Read data from excel
		String lastname = elib.getdataFromExcel("contact", 1, 2);
		 
		//randomno generation
		int count=jlib.getRandomNo();
	
			 WebDriver driver=null;
			 if(BROWSER.equals("chrome"))
			 {
				 driver=new ChromeDriver();
			 }
			 else
			 {
				 driver=new EdgeDriver();
			 }
			 
			wlib.waitForPageLoad(driver);
			driver.manage().window().maximize();
			 
			 //lanunching an application
			 driver.get(URL);
			 
			 
			 //login into app
			 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			 driver.findElement(By.id("submitButton")).click();
			 
			 //navigating to contacts page
			 driver.findElement(By.linkText("Contacts")).click();
			 
			 //read from excel
			 	
			 //creating contact page
			 driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
			 driver.findElement(By.name("lastname")).sendKeys(lastname);
			 driver.findElement(By.name("button")).click();
			 
			 //validation
			 
			 String actlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
			 
			 if(actlastname.equals(lastname))
			 {
				 System.out.println(actlastname +" is verified==> pass");
			 }
			 else
			 {
				 System.out.println(actlastname +" is not  verified==> fail");
			 }
				
		
			 }

	}


