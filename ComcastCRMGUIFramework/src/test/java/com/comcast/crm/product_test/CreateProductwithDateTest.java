package com.comcast.crm.product_test;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreateproductPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ProductInformationPage;
import com.comcast.crm.objectrepositoryutility.ProductsPage;

public class CreateProductwithDateTest extends BaseClass
{
	@Test(groups = "RegressonTest")
	public void  createProductwithDateTest()throws Throwable
	{

		//Read from excel file
			String proname =elib.getdataFromExcel("products", 1, 2);		
			String startdate=jlib.getsystemDateYYYYDDMM();
			String enddate=jlib.getRequiredDateYYYYDDMM(30);
			 //navigate to products page
			 HomePage hp=new HomePage(driver);
			 hp.getProlink().click();

			 ProductsPage pp=new ProductsPage(driver);
			 pp.getNewproimg().click();
			 
			 //create new product
			 CreateproductPage cpp=new CreateproductPage(driver);
			 cpp.getProname().sendKeys(proname);
			 cpp.getStartdate().sendKeys(startdate);
			 cpp.getEnddate().sendKeys(enddate);
			 cpp.getSavebtn().click();
			 
			 
			 //validation
			 ProductInformationPage pip=new ProductInformationPage(driver);
			 String gname=pip.getPname().getText();
			 String gstart=pip.getGstartdate().getText();
			 String gend=pip.getGenddate().getText();
			 pip.proinfo(gname, proname);
			 
			 
			 
	}

}
