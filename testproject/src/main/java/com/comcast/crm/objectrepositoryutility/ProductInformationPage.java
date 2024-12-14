package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage
{
	public  ProductInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="dtlview_Product Name")
	private WebElement pname;
	
	@FindBy(id="mouseArea_Support Start Date")
	private WebElement gstartdate;
	
	@FindBy(id="mouseArea_Support Expiry Date")
	private WebElement genddate;
	
	
	public WebElement getGstartdate() {
		return gstartdate;
	}

	public WebElement getGenddate() {
		return genddate;
	}

	public WebElement getPname()
	{
		return pname;
	}
	
	public void proinfo(String gname,String proname)
	{
		if(gname.contains(proname))
		{
			System.out.println(gname +" is verified==>pass");
		}
		else
		{
			System.out.println(gname +" is not verified==>fail");
		}
	}
	public void infostart(String gstart,String start)
	{
		if(gstart.contains(start))
		{
			System.out.println(gstart+" is verified==>pass");
		}
		else
		{
			System.out.println(gstart +" is not verified==>fail");
		}
	}
	
	
	public void infoend(String gend,String end)
	{
		if(gend.contains(end))
		{
			System.out.println(gend +" is verified==>pass");
		}
		else
		{
			System.out.println(gend+" is not verified==>fail");
		}
	}
	
}
