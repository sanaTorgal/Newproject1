package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage
{
	//WebDriver driver;
	public OrganizationsPage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title=\"Create Organization...\"]")
	private WebElement orgimg;

	public WebElement getOrgimg()
	{
		return orgimg;
	}
	
	@FindBy(name="search_text")
	private WebElement searchtxt;
	
	
	@FindBy(name="search_field")
	private WebElement searchfield;
	
	
	@FindBy (name="submit")
	private WebElement submitbtn;
	


	public WebElement getSearchtxt() {
		return searchtxt;
	}


	public WebElement getSearchfield() {
		return searchfield;
	}


	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	
	
}
