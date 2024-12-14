package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateLeadPage extends WebDriverUtility
{
	public CreateLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="salutationtype")
	private WebElement dropdown;
	
	@FindBy(name="button")
	private WebElement save;
	
	public WebElement getSave() {
		return save;
	}

	public WebElement getDropdown() {
		return dropdown;
	}
	@FindBy(name="firstname")
	private WebElement firstname;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(name="company")
	private WebElement company;
	@FindBy(name="leadstatus")
	private WebElement leadstaus;
	
	@FindBy(id="noofemployees")
	private WebElement noofemp;
	public WebElement getNoofemp() {
		return noofemp;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getFirstname() {
		return firstname;
	}
	
	
	
	
	public WebElement getLeadstaus() {
		return leadstaus;
	}

	public void leaddrop(WebElement leadstaus,String value)
	{
		Select sel=new Select(leadstaus);
		sel.selectByVisibleText(value);	
		
	}
}
