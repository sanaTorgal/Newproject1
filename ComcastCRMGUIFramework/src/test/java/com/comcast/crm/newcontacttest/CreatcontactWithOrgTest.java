package com.comcast.crm.newcontacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.ContactinformationPage;
import com.comcast.crm.objectrepositoryutility.Creating_New_Organization_Page;
import com.comcast.crm.objectrepositoryutility.CreatingnewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.Newwindow;
import com.comcast.crm.objectrepositoryutility.Organization_Information_Page;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreatcontactWithOrgTest extends BaseClass
{

	@Test
	public void creatcontactWithOrg() throws Throwable
	{

		String orgname = elib.getdataFromExcel("contact", 7, 2)+jlib.getRandomNo();
		System.out.println(orgname);

		String lastName = elib.getdataFromExcel("contact", 7, 3);

		// step2:navigate to organization module
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();

		// step3:click on "create organization button"
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getOrgimg().click();

		// step4:Enter all the details and create new organization
		Creating_New_Organization_Page cip=new Creating_New_Organization_Page(driver);
		cip.getOrgname().sendKeys(orgname);
		cip.getSave().click();
		Thread.sleep(2000);
		hp.getContactlink().click();

		//Organization_Information_Page oip=new Organization_Information_Page(driver);
		
		// navigate to contact module
		//oip.getConlink().click();
		ContactPage cp=new ContactPage(driver);
		cp.getImg().click();

		// creating contact page
		CreatingnewContactPage ccp=new CreatingnewContactPage(driver);
		ccp.getLastname().sendKeys(lastName);


		ccp.getLookup().click();

		// switch to child window
		wlib.switchtoWinUrl(driver, "Accounts&action");
		Newwindow nw=new Newwindow(driver);
		nw.getSearchtxt().sendKeys(orgname);
		wlib.selectbytext(nw.getDropdown(), "Organization Name");
		nw.getSearchbox().click();

		System.out.println(orgname);
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
	

		// switch back to parent window
		wlib.switchtoWinUrl(driver, "Contacts&action");
		cip.getSave().click();
		
		// validation
		ContactinformationPage cip1=new ContactinformationPage(driver);
				String actlname = cip1.getCheaderinfo().getText();
		cip1.headerinfo(actlname, lastName);
				String actorgname = cip1.getGorgname().getText();
				cip1.orginfo(actorgname,orgname);
		
		
		
	
	}
}
