package com.comcast.crm.leadtest;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreateLeadPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadPage;
import com.comcast.crm.objectrepositoryutility.LeadinfoPage;

public class CreateLeadwithnoofempTest extends BaseClass
{
	@Test(groups = "regressionTest")
	public void createLeadwithnoofemmpTest()throws Throwable
	{
		
		 String firstname=elib.getdataFromExcel("leads", 1, 2);
		 String no=elib.getdataFromExcel("leads", 1, 4);
		 String lastname=elib.getdataFromExcel("leads", 1, 3);
		 String company=elib.getdataFromExcel("leads", 1, 5);
		
		 HomePage hp=new HomePage(driver);
		 hp.getLeadlink().click();
		 
		 //navigate to lead
		LeadPage lp=new LeadPage(driver);
		lp.getLeadimg().click();
		
		CreateLeadPage clp=new CreateLeadPage(driver);
		clp.getNoofemp().sendKeys(no);
		clp.getLastname().sendKeys(lastname);
		clp.getFirstname().sendKeys(firstname);
		clp.getCompany().sendKeys(company);
		
		clp.getSave().click();
		
		//validation
				LeadinfoPage lip=new LeadinfoPage(driver);
			
				String gfirst=lip.getGfname().getText();
				String glast=lip.getGlname().getText();
				String gno = lip.getGno().getText();
				lip.infofname(gfirst, firstname);
				lip.infolname(glast, lastname);
				lip.infogno(gno, no);
				
		
		
		
	}

	
}
