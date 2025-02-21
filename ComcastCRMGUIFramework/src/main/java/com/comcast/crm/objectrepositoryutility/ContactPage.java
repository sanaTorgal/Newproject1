package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@alt=\"Create Contact...\"]")
	private WebElement img;
	
	@FindBy(xpath="//table//input[@name='search_text']")
	private WebElement searchtxt;
	
	@FindBy(name="submit")
	private WebElement searchnow;

	public WebElement getImg() {
		return img;
	}

	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getSearchnow() {
		return searchnow;
	}
	

	
	
}
