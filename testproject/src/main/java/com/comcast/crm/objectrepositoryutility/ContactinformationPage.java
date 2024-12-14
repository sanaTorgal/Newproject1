package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactinformationPage
{
	public ContactinformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="dtlview_Last Name")
	private WebElement glname;
	
	@FindBy(id="mouseArea_Support Start Date")
	private WebElement gstartdate;
	
	@FindBy(id="mouseArea_Support End Date")
	private WebElement genddate;
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement  cheaderinfo;
	@FindBy(id="mouseArea_Organization Name")
	private WebElement gorgname;

	public WebElement getGorgname() {
		return gorgname;
	}

	public WebElement getCheaderinfo() {
		return cheaderinfo;
	}

	public WebElement getGlname() {
		return glname;
	}

	public WebElement getGstartdate() {
		return gstartdate;
	}

	public WebElement getGenddate() {
		return genddate;
	}
	public void headerinfo(String actlname,String lname)
	{
		if(actlname.contains(lname))
		{
			System.out.println(actlname + " is verified==>pass");
		}
		else
		{
			System.out.println(actlname + " is not verified==>fail");
		}
	}
	
	public void startinfo(String actstartd,String startd)
	{
		if(actstartd.contains(startd))
		{
			System.out.println(actstartd+ " is  verified ==>pass");
		}
		else
		{
			System.out.println(actstartd + "is not verified ==>fail");
		}
		
	}
	public void endinfo(String actendd,String endd)
	{
		if(actendd.contains(endd))
		{
			System.out.println(actendd + " is verified ==>passs");
		}
		else
		{
			System.out.println(actendd + " is  not  verified ==>fail");
		}
	}
	public void orginfo(String gorgname,String orgname)
	{
		if(gorgname.contains(orgname))
		{
			System.out.println(gorgname + " is verified ==>pass");
		}
		else
		{
			System.out.println(gorgname + " is not verified ==>fail");
		}
	}
	public void headerinfo1(String lname)
	{
		 String headerinfo=cheaderinfo.getText();
		
		if(headerinfo.contains(lname))
		{
			System.out.println("Header info is verefied==>pass ");
		}
		else
		{
			System.out.println("Header info is not verefied==>fail ");
		}
		
	}
}


