package com.comcast.crm.newcontacttest;

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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassobject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.ContactinformationPage;
import com.comcast.crm.objectrepositoryutility.Creating_New_Organization_Page;
import com.comcast.crm.objectrepositoryutility.CreatingnewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.Newwindow;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
		
		
public class CreateContactTest extends BaseClass {

	@Test(groups = "smokeTest",retryAnalyzer =com.comcast.crm.listenerutility.RetryListenerImp.class )
	public void CreateContact() throws Throwable {

		// Read data from excel
		UtilityClassobject.gettest().log(Status.INFO,"Read data from excel");
		String lastname = elib.getdataFromExcel("contact", 1, 2);
		System.out.println(lastname);

		// navigating to contacts page
		UtilityClassobject.gettest().log(Status.INFO,"Navigate to contact module");
		HomePage hp = new HomePage(driver);
		hp.getContactlink().click();

		// navigating to create contact page
		UtilityClassobject.gettest().log(Status.INFO,"click on new contact img");
		ContactPage cp = new ContactPage(driver);
		cp.getImg().click();

		// creating contact page
		UtilityClassobject.gettest().log(Status.INFO,"creating new contact");
		CreatingnewContactPage ccp = new CreatingnewContactPage(driver);
		ccp.getLastname().sendKeys(lastname);
		ccp.getSave().click();
		
		/* validation using if else
		ContactinformationPage cip = new ContactinformationPage(driver);
		String actlname = cip.getCheaderinfo().getText();
		cip.headerinfo(actlname, actlname);
		cip.headerinfo1(lastname);*/
		
		//validation using Asserts
		UtilityClassobject.gettest().log(Status.INFO,"Contact name verified");
		ContactinformationPage cip = new ContactinformationPage(driver);
		String  header=cip.getCheaderinfo().getText();
		boolean status = header.contains(lastname);	
		Assert.assertEquals(status,true);
		
		String glastname=cip.getGlname().getText();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals( glastname,lastname);
		sa.assertAll();
		
		

	}
	
	
	
	@Test(groups = "regressionTest" ,retryAnalyzer =com.comcast.crm.listenerutility.RetryListenerImp.class )
	public void creatcontactWithOrg() throws Throwable
	{
		UtilityClassobject.gettest().log(Status.INFO,"Read data from excel");
		String orgname = elib.getdataFromExcel("contact", 7, 2)+jlib.getRandomNo();
		System.out.println(orgname);

		String lastName = elib.getdataFromExcel("contact", 7, 3);

		// step2:navigate to organization module
		UtilityClassobject.gettest().log(Status.INFO,"Navigate to organization module");
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();

		// step3:click on "create organization button"
		UtilityClassobject.gettest().log(Status.INFO,"click on new contact img");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getOrgimg().click();

		// step4:Enter all the details and create new organization
		UtilityClassobject.gettest().log(Status.INFO,"creating new organization");
		Creating_New_Organization_Page cip=new Creating_New_Organization_Page(driver);
		cip.getOrgname().sendKeys(orgname);
		cip.getSave().click();
		Thread.sleep(2000);
		hp.getContactlink().click();

		//Organization_Information_Page oip=new Organization_Information_Page(driver);
		
		// navigate to contact module
		//oip.getConlink().click();
		UtilityClassobject.gettest().log(Status.INFO,"click on new contact img ");
		ContactPage cp=new ContactPage(driver);
		cp.getImg().click();

		// creating contact page
		UtilityClassobject.gettest().log(Status.INFO,"creating new contact");
		CreatingnewContactPage ccp=new CreatingnewContactPage(driver);
		ccp.getLastname().sendKeys(lastName);


		ccp.getLookup().click();

		// switch to child window
		UtilityClassobject.gettest().log(Status.INFO,"Switching to child window");
		wlib.switchtoWinUrl(driver, "Accounts&action");
		Newwindow nw=new Newwindow(driver);
		nw.getSearchtxt().sendKeys(orgname);
		wlib.selectbytext(nw.getDropdown(), "Organization Name");
		nw.getSearchbox().click();

		System.out.println(orgname);
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
	

		// switch back to parent window
		UtilityClassobject.gettest().log(Status.INFO,"switching to parent window");
		wlib.switchtoWinUrl(driver, "Contacts&action");
		cip.getSave().click();
		
		/* validation using if else
		ContactinformationPage cip1=new ContactinformationPage(driver);
				String actlname = cip1.getCheaderinfo().getText();
		cip1.headerinfo(actlname, lastName);
				String actorgname = cip1.getGorgname().getText();
				cip1.orginfo(actorgname,orgname);*/
		
		//validation using Asserts
		UtilityClassobject.gettest().log(Status.INFO,"contact name verified ");
		ContactinformationPage cip1=new ContactinformationPage(driver);
		String actlname = cip1.getCheaderinfo().getText();
		String actorgname = cip1.getGorgname().getText();
		
			boolean status1=actlname.contains(lastName);
			boolean status2=actorgname.contains(orgname);
			Assert.assertEquals(status1, true);
			Assert.assertEquals(status2, true);
		
	
	}
	
	@Test(groups = "regressionTest" ,retryAnalyzer =com.comcast.crm.listenerutility.RetryListenerImp.class )
	public void CreateContactDate() throws Throwable
	{
			//Read data from excel
		   UtilityClassobject.gettest().log(Status.INFO,"Read data from excel");
			String lastname=elib.getdataFromExcel("contact", 1, 2);
			
			//Home page
			UtilityClassobject.gettest().log(Status.INFO,"Navigate to contact module");
			HomePage hp=new HomePage(driver);
			hp.getContactlink().click();
		
			 //navigating to contacts page
			UtilityClassobject.gettest().log(Status.INFO,"click on contact img");
			ContactPage cp=new ContactPage(driver);
			cp.getImg().click();
			
			
			 //creating contact page
			UtilityClassobject.gettest().log(Status.INFO,"creating new contact");
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

			 /*validation using if -else stmts
			ContactinformationPage cip=new ContactinformationPage(driver);
			String actlname = cip.getGlname().getText();
			String actstartd = cip.getGstartdate().getText();
			String actendd=cip.getGenddate().getText();
			cip.headerinfo(actlname, lastname);
			cip.startinfo(actstartd,startdate);
			cip.endinfo(actendd, enddate);*/
			
			//validation using Asserts
			UtilityClassobject.gettest().log(Status.INFO,"contat name with startdate and enddate verified");
			ContactinformationPage cip=new ContactinformationPage(driver);
			String actlname = cip.getGlname().getText();
			String actstartd = cip.getGstartdate().getText();
			String actendd=cip.getGenddate().getText();
						boolean status1 = actlname.contains(lastname);
						boolean status2=actstartd.contains(startdate);
						boolean staus3=actendd.contains(enddate);
				SoftAssert sa=  new SoftAssert();
				sa.assertEquals(status1, true);
				sa.assertEquals(status1, true);
				sa.assertEquals(status1, true);		
			
		 }
	
}
