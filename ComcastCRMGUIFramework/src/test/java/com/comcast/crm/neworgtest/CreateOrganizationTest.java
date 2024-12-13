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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassobject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.listenerutility.ListenerImpClass;
import com.comcast.crm.objectrepositoryutility.Creating_New_Organization_Page;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.Organization_Information_Page;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)

public class CreateOrganizationTest extends BaseClass
{

	@Test(groups = "smokeTest" , retryAnalyzer =com.comcast.crm.listenerutility.RetryListenerImp.class )
	public void createOrganization() throws Throwable
	{	
		
	
		
		//Reading from Excel utility
	     UtilityClassobject.gettest().log(Status.INFO,"Read data from excel");
		 String orgname=elib.getdataFromExcel("org",1,2)+jlib.getRandomNo();
		 String industry=elib.getdataFromExcel("org", 4, 3);
	 		
	      
	      //home page::navigate to organization module
		 UtilityClassobject.gettest().log(Status.INFO,"navigating to organization module");
	        HomePage hp=new HomePage(driver);
	        hp.getOrglink().click();
	        
	        //click on orgimg
	        UtilityClassobject.gettest().log(Status.INFO,"navigate to  new org image");
	        OrganizationsPage op=new OrganizationsPage(driver);
	        op.getOrgimg().click();		
	 
	 		//step3:Create organization"
	        UtilityClassobject.gettest().log(Status.INFO,"creating new organization");
	        Creating_New_Organization_Page cp=new Creating_New_Organization_Page(driver);
	        cp.createOrg(orgname, industry);
	        
	        /*validation
	        Organization_Information_Page cip=new Organization_Information_Page(driver);
	        String actorgname=cip.getHeaderinfo().getText();
	       cip.headerinfo(actorgname, orgname);*/
	       
	       //validation using Asserts
	       
	       Organization_Information_Page cip=new Organization_Information_Page(driver);
	        String actorgname=cip.getHeaderinfo().getText();
	        boolean status1=actorgname.contains(orgname);
	        Assert.assertEquals(status1,true);
	        
	      /*  Organization_Information_Page cip=new Organization_Information_Page(driver);
	        String actorgname=cip.getHeaderinfo().getText();
	        Assert.assertEquals(actorgname,orgname);*/
	     
	 		
	 }
	
	@Test(groups = "regressionTest",retryAnalyzer =com.comcast.crm.listenerutility.RetryListenerImp.class )
	public void createorgwithtype() throws Throwable
	{
		
		// Read from excel
		UtilityClassobject.gettest().log(Status.INFO, "Read data from excel");
		String orgname = elib.getdataFromExcel("org", 4, 2) +jlib.getRandomNo();
		String industry = elib.getdataFromExcel("org", 4, 3);
		String type = elib.getdataFromExcel("org", 4, 4);
	
		// step2:navigate to organization module
		UtilityClassobject.gettest().log(Status.INFO, "navigate to organization module");
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();

		// step3:click on "create organization button"
		UtilityClassobject.gettest().log(Status.INFO, "click on new org image");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getOrgimg().click();
		
		// step4:Enter all the details and create new organization
		UtilityClassobject.gettest().log(Status.INFO, "creating new Organization");
		Creating_New_Organization_Page cip=new Creating_New_Organization_Page(driver);
		cip.getOrgname().sendKeys(orgname);
		wlib.selectbytext(cip.getIndustry(),industry);
		wlib.selectbytext(cip.getTypetxt(), type);
		cip.getSave().click();

		
		
		 /*validation using if else
        Organization_Information_Page oip=new Organization_Information_Page(driver);
        String actorgname=oip.getHeaderinfo().getText();
       oip.headerinfo(actorgname, orgname);*/
       
     /*  oip.industry(industry);
		
		oip.type(type);*/
		
		//validation using Asserts
		UtilityClassobject.gettest().log(Status.INFO, "org name with type and industry verified");
		 Organization_Information_Page oip=new Organization_Information_Page(driver);
	     String actorgname=oip.getHeaderinfo().getText();
	    boolean status=actorgname.contains(orgname);
	    Assert.assertEquals(status, true);
		
       String gtype=oip.getActtype().getText();
       String gindustry=oip.getGindustry().getText();
      
       boolean status2=gtype.contains(type);
       boolean status3=gindustry.contains(industry);
       
       Assert.assertEquals(status3, true);
       Assert.assertEquals(status2, true);

	}
	@Test(groups = "regressionTest",retryAnalyzer =com.comcast.crm.listenerutility.RetryListenerImp.class )
	public void createOrganizationwithphoneno() throws Throwable
	{
		// Read from excel file
		UtilityClassobject.gettest().log(Status.INFO, "Read data from excel");
		String orgname = elib.getdataFromExcel("org", 7, 2)+jlib.getRandomNo();
		String	phoneno=elib.getdataFromExcel("org", 7, 3);

	
		// step2:navigate to organization module
		UtilityClassobject.gettest().log(Status.INFO, "navigate to organization module");
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();
		
		
		// step3:click on "create organization button"
		UtilityClassobject.gettest().log(Status.INFO, "Click on new org image");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getOrgimg().click();
		// step4:Enter all the details and create new organization
		UtilityClassobject.gettest().log(Status.INFO, "Creating new organization");
		Creating_New_Organization_Page cip=new Creating_New_Organization_Page(driver);
		cip.getOrgname().sendKeys(orgname);
		cip.getPhoneno().sendKeys(phoneno);
		cip.getSave().click();
		

		// validation using if else
		UtilityClassobject.gettest().log(Status.INFO, "Org name with phone no verified");
		Organization_Information_Page oip=new Organization_Information_Page(driver);
		String actorgname = oip.getHeaderinfo().getText();
		//oip.headerinfo(actorgname, orgname);
		String actphoneno=oip.getGuiphone().getText();
		
		boolean status1=actorgname.contains(orgname);
		boolean staus2=actphoneno.contains(phoneno);
		
		Assert.assertEquals(status1, true);
		Assert.assertEquals(status1, true);

	}

	
	}


