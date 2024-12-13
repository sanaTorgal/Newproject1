package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.basetest.BaseClass;

public class DocumentsPage extends BaseClass
{
	public DocumentsPage() 
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt=\"Create Document...\"]")
	private WebElement docimg;
	
	

}
