package com.comcast.crm.product_test;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
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
import com.comcast.crm.objectrepositoryutility.CreateproductPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ProductInformationPage;
import com.comcast.crm.objectrepositoryutility.ProductsPage;

public class CreateproductTest  extends BaseClass
{

	@Test(groups = "smokeTest")
	public void creatProductTest()throws Throwable
	{
		
			//Read from excel file
				String proname =elib.getdataFromExcel("products", 1, 2);		
				
				 //navigate to products page
				 HomePage hp=new HomePage(driver);
				 hp.getProlink().click();

				 ProductsPage pp=new ProductsPage(driver);
				 pp.getNewproimg().click();
				 
				 //create new product
				 CreateproductPage cpp=new CreateproductPage(driver);
				 cpp.getProname().sendKeys(proname);
				 cpp.getSavebtn().click();
				 
				
				//validation
				 ProductInformationPage pip=new ProductInformationPage(driver);
				 String gname=pip.getPname().getText();
				 pip.proinfo(gname, proname);
			
				 
	}

}
