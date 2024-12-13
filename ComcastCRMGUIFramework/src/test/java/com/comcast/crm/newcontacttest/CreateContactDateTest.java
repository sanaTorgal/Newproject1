package com.comcast.crm.newcontacttest;

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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.ContactinformationPage;
import com.comcast.crm.objectrepositoryutility.CreatingnewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
@Listeners(listeners.ListenerImplementation.class)
public class CreateContactDateTest extends BaseClass
{

	@Test
	public void createContactdate()throws Throwable
	{
		//Read data from excel
			String lastname=elib.getdataFromExcel("contact", 1, 2);
			
			//Home page
			HomePage hp=new HomePage(driver);
			hp.getContactlink().click();
		
			 //navigating to contacts page
			ContactPage cp=new ContactPage(driver);
			cp.getImg().click();
			
			
			 //creating contact page
			CreatingnewContactPage ccp=new CreatingnewContactPage(driver);
			ccp.getLastname().sendKeys(lastname);
			
			String startdate = jlib.getsystemDateYYYYDDMM();
			System.out.println(startdate);
			String enddate = jlib.getRequiredDateYYYYDDMM(30);
			System.out.println(enddate);
			ccp.getStartdate().sendKeys(jlib.getsystemDateYYYYDDMM());
			ccp.getEnddate().clear();
			ccp.getEnddate().sendKeys(jlib.getRequiredDateYYYYDDMM(30));
			ccp.getSave().click();

			 //validation
		/*	ContactinformationPage cip=new ContactinformationPage(driver);
			String actlname = cip.getGlname().getText();
			String actstartd = cip.getGstartdate().getText();
			String actendd=cip.getGenddate().getText();
			cip.headerinfo(actlname, lastname);
			cip.startinfo(actstartd,startdate);
			cip.endinfo(actendd, enddate);*/
			
			//validation with asserts
			ContactinformationPage cip=new ContactinformationPage(driver);
			String actlname = cip.getGlname().getText();
			String actstartd = cip.getGstartdate().getText();
			String actendd=cip.getGenddate().getText();
			Assert.assertEquals(actlname, lastname);
			Assert.assertEquals(actstartd, startdate);
			Assert.assertEquals(actendd,enddate);
			
			
		}
	
	
	
	
}


