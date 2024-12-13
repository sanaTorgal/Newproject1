package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

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

public class Create_contact_wiht_support_date_testcase5 {

	public static void main(String[] args) throws IOException, Throwable
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
			String lastname=elib.getdataFromExcel("contact", 1, 2);
		
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
			 
			 //creating contact page
			 driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
			
			 String startdate=jlib.getsystemDateYYYYDDMM();
			 String  enddate=jlib.getRequiredDateYYYYDDMM(30);
			 
			 driver.findElement(By.name("lastname")).sendKeys(lastname);
			 driver.findElement(By.name("support_start_date")).clear();
			 driver.findElement(By.name("support_start_date")).sendKeys(startdate);
			// driver.findElement(By.name("support_end_date")).sendKeys(enddate);
			 Thread.sleep(1000);
			 driver.findElement(By.name("support_end_date")).clear();
			 driver.findElement(By.xpath("//input[@name=\"support_end_date\"]")).sendKeys(enddate);
			 driver.findElement(By.name("button")).click();
			 
			 //validation
			 
			 String actlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
			 
			 String actstartdate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
			 
			 String actenddate=driver.findElement(By.id("dtlview_Support End Date")).getText();
			 
			 if(actlastname.equals(lastname))
			 {
				 System.out.println(actlastname +" is verified==> pass");
			 }
			 else
			 {
				 System.out.println(actlastname +" is not  verified==> fail");
			 }
				if(actstartdate.equals(startdate))
				{
					System.out.println(actstartdate +"information is verrified==>pass");
				}
				else
				{
					System.out.println(actstartdate +"information is  not verrified==>fail");
				}
				if(actenddate.equals(enddate))
				{
					System.out.println(actenddate +"is verified ==>pass");
				}
				else
				{
					System.out.println(actenddate+"is not verified==>fail");
				}
	
			 }
			 
			 
			 
			 
		

	}


