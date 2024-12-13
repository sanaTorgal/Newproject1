package com.comcast.crm.leadtest;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateLeadPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadPage;
import com.comcast.crm.objectrepositoryutility.LeadinfoPage;
@Listeners(listeners.ListenerImplementation.class)
public class CreateleadTest extends BaseClass
{
		@Test(groups = "smokeTest")
		public void createLead()throws Throwable
		{
		
		
		//Read from excel file
		String firstname=elib.getdataFromExcel("leads", 1, 2)+jlib.getRandomNo();
		 String lastname=elib.getdataFromExcel("leads", 1, 3)+jlib.getRandomNo();
		 String company=elib.getdataFromExcel("leads", 1, 6)+jlib.getRandomNo();
		
		 
		 wlib.waitForPageLoad(driver);
		 //navigate to applctn
		 Thread.sleep(1000);
		 HomePage hp=new HomePage(driver);
		 hp.getLeadlink().click();
		 
		
		 //navigate to lead
		LeadPage lp=new LeadPage(driver);
		lp.getLeadimg().click();
		
		 
		CreateLeadPage clp=new CreateLeadPage(driver);
		//clp.leaddrop(clp.getLeadstaus(),"Mr");
		clp.getLastname().sendKeys(lastname);
		clp.getFirstname().sendKeys(firstname);
		clp.getCompany().sendKeys(company);
		clp.getSave().click();
		
		
		
		//validation
		LeadinfoPage lip=new LeadinfoPage(driver);
	
		String gfirst=lip.getGfname().getText();
		String glast=lip.getGlname().getText();
		String gcom=lip.getGcompany().getText();
		lip.infofname(gfirst, firstname);
		lip.infolname(glast, lastname);
		
		
	
	}	
	
	
	

}
