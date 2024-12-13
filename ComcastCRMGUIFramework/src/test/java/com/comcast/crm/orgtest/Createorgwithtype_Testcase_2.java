package com.comcast.crm.orgtest;

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
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.Creating_New_Organization_Page;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.Organization_Information_Page;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class Createorgwithtype_Testcase_2 {

	public static void main(String[] args) throws Throwable {

		// utilities
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		// Read data from properties file

		String BROWSER = flib.getdatafromPropertiesFile("browser");
		String URL = flib.getdatafromPropertiesFile("url");
		String USERNAME = flib.getdatafromPropertiesFile("username");
		String PASSWORD = flib.getdatafromPropertiesFile("password");

		// Random no
		
		// Read from excel
		String orgname = elib.getdataFromExcel("org", 4, 2) +jlib.getRandomNo();
		String industry = elib.getdataFromExcel("org", 4, 3);
		String type = elib.getdataFromExcel("org", 4, 4);
		
		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new EdgeDriver();
		}

		// step1:Login to app

		wlib.waitForPageLoad(driver);
		driver.get(URL);

		driver.manage().window().maximize();

		//Login
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(USERNAME, PASSWORD);
		
		// step2:navigate to organization module
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();

		// step3:click on "create organization button"
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getOrgimg().click();
		
		// step4:Enter all the details and create new organization
		Creating_New_Organization_Page cip=new Creating_New_Organization_Page(driver);
		cip.getOrgname().sendKeys(orgname);
		wlib.selectbytext(cip.getIndustry(),industry);
		wlib.selectbytext(cip.getTypetxt(), type);
		cip.getSave().click();

		
		
		 //validation
        Organization_Information_Page oip=new Organization_Information_Page(driver);
        String actorgname=oip.getHeaderinfo().getText();
       oip.headerinfo(actorgname, orgname);
       
       oip.industry(industry);
		
		oip.type(type);

	}

}
