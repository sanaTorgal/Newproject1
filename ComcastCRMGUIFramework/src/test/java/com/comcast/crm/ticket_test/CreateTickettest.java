package com.comcast.crm.ticket_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

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

public class CreateTickettest
{

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
					
				//Read from excel file
		 String ticname=elib.getdataFromExcel("tickets", 1, 2);
		 String lastname=elib.getdataFromExcel("contact", 7, 3);
				
				 
                WebDriver driver=null;;
				 
				 if(BROWSER.equals("chrome"))
				 {
					 driver=new ChromeDriver();
					 
				 }
				 else if(BROWSER.equals("edge"))
				 {
					driver=new EdgeDriver();
					
				 }
				 else
				 {
					 driver=new ChromeDriver();
				 }
				 
				 
				 //navigate to applctn
				wlib.waitForPageLoad(driver);
				 driver.get(URL);
				 driver.manage().window().maximize();
				 
				 //login to app
				 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				 driver.findElement(By.id("submitButton")).click();
				 
				 //navigating to contacts page
				 driver.findElement(By.linkText("Contacts")).click();
				 
				 //creating contact page
				 driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
				 driver.findElement(By.name("lastname")).sendKeys(lastname);
				 driver.findElement(By.name("button")).click();
				 
				 //navigating t0 tickets page
				 
				 driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Trouble Tickets']")).click();
				 
				 driver.findElement(By.xpath("//img[@title=\"Create Ticket...\"]")).click();
				 
				 driver.findElement(By.name("ticket_title")).sendKeys(ticname);
				 driver.findElement(By.xpath("//input[@name=\"parent_name\"]/following-sibling::img")).click();
				 
				 String url="http://localhost:8888/index.php?module=Contacts&action=Popup&html=Popup_picker&form=HelpDeskEditView&fromlink=";
				 //wlib.switchNewBrowserTab(driver, URL);
			/*	 //switch to child window
				 	Set<String> allwin = driver.getWindowHandles();
				 	
				 	System.out.println(allwin.size());
				 	for (String win : allwin)
				 	{
				 		driver.switchTo().window(win);
				 		String cururl = driver.getCurrentUrl();
				 		if(cururl.contains("Contacts&action"))
				 		{
				 			break;
				 		}
					}*/
				 	
					
					 
				   driver.findElement(By.id("search_txt")).sendKeys(lastname);
				 
				 	driver.findElement(By.name("search")).click();
				 	Thread.sleep(1000);
			
				 	driver.findElement(By.linkText(lastname)).click();
				 	
				 	
	
				 	driver.findElement(By.name("button")).click();
				 	String flightname = driver.findElement(By.id("dtlview_Title")).getText();
				 	if(flightname.equals(ticname) )
				 	{
				 		System.out.println(flightname+"is verified==>pass");
				 	}
				 	else
				 	{
				 		System.out.println(flightname+"is not  verified==>fail");
				 	}
	}

}
