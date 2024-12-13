package com.comcast.crm.neworgtest;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.Creating_New_Organization_Page;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.Organization_Information_Page;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrg 
{

	public static void main(String[] args) throws Throwable 
	{
		
		//utilities
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		JavaUtility jlib=new JavaUtility();
		
	
		// Reading from Fileutility
		String BROWSER=flib.getdatafromPropertiesFile("browser");
		String URL=flib.getdatafromPropertiesFile("url");
		String username=flib.getdatafromPropertiesFile("username");
		String password=flib.getdatafromPropertiesFile("password");
		
		//Reading from Excel utility
		String orgname=elib.getdataFromExcel("org",10,2)+jlib.getRandomNo();
		String industry=elib.getdataFromExcel("org", 4, 3);
		
		
		
			
			WebDriver driver=null;
			if(BROWSER.equals("chrome"))
			{
				driver=new ChromeDriver();
			}
			else
			{
				driver=new EdgeDriver();
			}
			
	 			//step1:Login to app
	 		wlib.waitForPageLoad(driver);
	 			
	 		driver.get(URL);
	 	
	 		driver.manage().window().maximize();
	 		//LoginPage lp=PageFactory.initElements( driver,LoginPage.class);
	 		LoginPage lp=new LoginPage(driver);
	         lp.loginToapp(username, password);
	      
	      //home page::navigate to organization module
	        HomePage hp=new HomePage(driver);
	        hp.getOrglink().click();
	        
	        //click on orgimg
	        OrganizationsPage op=new OrganizationsPage(driver);
	        op.getOrgimg().click();		
	 
	 		//step3:Create organization"
	        Creating_New_Organization_Page cp=new Creating_New_Organization_Page(driver);
	        cp.createOrg(orgname, industry);
	        
	        //validation
	        Organization_Information_Page cip=new Organization_Information_Page(driver);
	        String actorgname=cip.getHeaderinfo().getText();
	       cip.headerinfo(actorgname, orgname);
	       
	       //go back to organizationpage
	     
	        hp.getOrglink().click();
	        
	        //Enter orgname in search box
	        op.getSearchtxt().sendKeys(orgname);
	       op.getSearchfield().sendKeys("organizationname");
	       op.getSubmitbtn().click();
	       
	       
	       //deleting
	       
	       driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
	       wlib.switchToAlertandDismiss(driver);
	       
	    /*   
	       if(actorgname.contains(orgname))
	       {
	    	   System.out.println(actorgname +"is verified ==>pass");
	       }
	       else
	       {
	    	   System.out.println(actorgname +"is not verified ==>fail");
	       }
	 		*/
	       
	       //close
	       
	     
	 }
			
		
		
		
	}


