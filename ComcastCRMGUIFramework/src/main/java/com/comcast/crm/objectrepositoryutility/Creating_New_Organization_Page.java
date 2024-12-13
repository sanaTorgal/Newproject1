package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Creating_New_Organization_Page 
{
	WebDriver driver;
	public Creating_New_Organization_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgname;
	
	@FindBy(name="industry")
	private WebElement industry;
	
	@FindBy(name="button")
	private WebElement save;
	
	@FindBy(name="phone")
	private WebElement phoneno;
	@FindBy(name="accounttype")
	private WebElement typetxt;
	


	public WebElement getTypetxt() {
		return typetxt;
	}

	public WebElement getPhoneno()
	{
		return phoneno;
	}

	public WebElement getSave() 
	{
		return save;
	}

	public WebElement getOrgname() 
	{
		return orgname;
	}

	public WebElement getIndustry() 
	{
		return industry;
	}
	
	public void createOrg(String orgname1,String industry1)
	{
		orgname.sendKeys(orgname1);
		industry.sendKeys(industry1);
		save.click();
	}
	
}
