package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingnewContactPage 
{
	
	public CreatingnewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(name="support_end_date")
	private WebElement enddate;
	@FindBy(xpath="//input[@name=\"account_name\"]/parent::td[@class=\"dvtCellInfo\"]//img")
	private WebElement lookup;
	
	@FindBy(name="support_start_date")
	private WebElement startdate;
	@FindBy(name="button")
	private WebElement save;
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getEnddate() {
		return enddate;
	}
	public WebElement getStartdate() {
		return startdate;
	}
	public WebElement getSave() {
		return save;
	}

	public WebElement getLookup() {
		return lookup;
	}
	@FindBy(name="type=\"submit\"")
	private WebElement save2;
	public WebElement getSave2() {
		return save2;
	}
}
	
