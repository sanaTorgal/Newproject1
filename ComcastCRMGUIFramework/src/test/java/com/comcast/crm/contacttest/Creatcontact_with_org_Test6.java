package com.comcast.crm.contacttest;

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

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class Creatcontact_with_org_Test6
{

	public static void main(String[] args) throws IOException, Throwable
	{
		// utilities
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		// Read data from propeties file

		String BROWSER = flib.getdatafromPropertiesFile("browser");
		String URL = flib.getdatafromPropertiesFile("url");
		String USERNAME = flib.getdatafromPropertiesFile("username");
		String PASSWORD = flib.getdatafromPropertiesFile("password");

		// Random no
		int count = jlib.getRandomNo();
		// Read data from excel file
		String orgname1 = elib.getdataFromExcel("contact", 7, 2);
		String orgname = orgname1 + count;
		String contactLastName = elib.getdataFromExcel("contact", 7, 3);

		WebDriver driver = null;
		if (BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		} else 
		{
			driver = new EdgeDriver();
		}

		// step1:Login to app

		wlib.waitForPageLoad(driver);
		driver.get(URL);

		driver.manage().window().maximize();

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

		// step2:navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();

		// step3:click on "create organization button"
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// step4:Enter all the details and create new organization

		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.name("button")).click();

		Thread.sleep(1000);

		// navigate to contact module

		driver.findElement(By.xpath("(//a[contains(text(),'Contacts')])[1]")).click();

		// creating contact page
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		// System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@name=\"account_name\"]/following-sibling::img")).click();

		// switch to child window
		wlib.switchtoWinUrl(driver, "Accounts&action");

		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();

		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();

		// switch back to parent window
		wlib.switchtoWinUrl(driver, "Contacts&action");
		driver.findElement(By.xpath("//input[@class=\"crmButton small save\"]")).click();

		// validation
		// verify cantactlastname

		String actlastname = driver.findElement(By.id("mouseArea_Last Name")).getText();
		System.out.println(actlastname);
		if (actlastname.trim().equals(contactLastName)) {
			System.out.println(actlastname + "is verified==>pass");
		} else {
			System.out.println(actlastname + "is not verified==>fail");
		}

		String actorgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actorgname);

		if (actorgname.trim().equals(orgname)) {
			System.out.println(actorgname + "is verifed ==>pass");
		} else {
			System.out.println(actorgname + "is not verifed ==>fail");
		}
	}
}
