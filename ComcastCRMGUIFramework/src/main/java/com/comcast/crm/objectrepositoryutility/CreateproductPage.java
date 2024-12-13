package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateproductPage
{
	public CreateproductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="productname")
	private WebElement proname;
	public WebElement getProname() {
		return proname;
	}
	@FindBy(name="button")
	private WebElement savebtn;
	
	@FindBy(xpath="//input[@name=\"start_date\"]")
	private WebElement startdate;
	
	@FindBy(xpath="//input[@name=\"expiry_date\"]")
	private WebElement enddate;
	
	public WebElement getStartdate() {
		return startdate;
	}

	public WebElement getEnddate() {
		return enddate;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
}
