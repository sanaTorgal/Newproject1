package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Newwindow
{
	 public Newwindow(WebDriver driver)
	{
		 PageFactory.initElements(driver,this);
		
	}
	 @FindBy(id="search_txt")
	 private WebElement searchtxt;
	 
	 @FindBy(name="search_field")
	 private WebElement dropdown;
	
	 @FindBy(xpath="//input[@type=\"button\"]")
	 private WebElement searchbox;

	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}
	 
	 

}
