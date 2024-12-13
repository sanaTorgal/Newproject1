package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadinfoPage 
{
	public LeadinfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="mouseArea_First Name")
	private WebElement gfname;
	
	@FindBy(id="mouseArea_Last Name")
	private WebElement glname;
	
	@FindBy(id="mouseArea_Company")
	private WebElement gcompany;
	
	@FindBy(xpath="//td[@id=\"mouseArea_No Of Employees\"]")
	private WebElement gno;
	
	public WebElement getGno() {
		return gno;
	}

	public WebElement getGfname() {
		return gfname;
	}

	public WebElement getGlname() {
		return glname;
	}

	public WebElement getGcompany() {
		return gcompany;
	}
	
	public void infofname(String gname,String name)
	{
		if(gname.contains(name))
		{
			System.out.println(gname + " is verified==>pass");
		}
		else
		{
			System.out.println(gname + " is not verified==>fail");
		}
	}
	public void infolname(String glname,String lname)
	{
		if(glname.contains(lname))
		{
			System.out.println(glname + " is verified==>pass");
		}
		else
		{
			System.out.println(glname + " is not verified==>fail");
		}
		
	}
	
	public void infogno(String gno,String no)
	{
		if(gno.contains(no))
		{
			System.out.println(gno+ " is verified==>pass");
		}
		else
		{
			System.out.println(gno + " is not verified==>fail");
		}
		
	}
	

}
