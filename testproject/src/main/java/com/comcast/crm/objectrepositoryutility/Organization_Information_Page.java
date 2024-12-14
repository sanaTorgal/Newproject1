package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_Information_Page
{
	//WebDriver driver;
	public Organization_Information_Page(WebDriver driver) 
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement headerinfo;
	
	@FindBy(id="dtlview_Industry")
	private WebElement actindusty;
	
	@FindBy(id="dtlview_Type")
	private WebElement acttype;
	@FindBy(id="dtlview_Phone")
	private WebElement guiphone;
	
	@FindBy(linkText = "Contacts")
	private WebElement conlink;
	@FindBy(id="mouseArea_Industry")
	private WebElement gindustry;
	
	

	public WebElement getGindustry() {
		return gindustry;
	}
	public WebElement getGuiphone() {
		return guiphone;
	}
	public WebElement getConlink() {
		return conlink;
	}
	public WebElement getActtype() {
		return acttype;
	}
	public WebElement getHeaderinfo() 
	{
		return headerinfo;
	}
	public void headerinfo(String actorgname1,String orgname)
	{
		  if(actorgname1.contains(orgname))
	       {
	    	   System.out.println(actorgname1 +"is verified ==>pass");
	       }
	       else
	       {
	    	   System.out.println(actorgname1 +"is not verified ==>fail");
	       }
		  
	}
	public void industry(String industry)
	{
		String actind=actindusty.getText();
		if(actind.equals(industry))
		{
			System.out.println(actind + "is verified==>pass");
		}
		else
		{
			System.out.println(actind + "is not verified==>fail");
		}
	}
	public void type(String type)
	{
				String typegui = acttype.getText();
				if(typegui.equals(type))
				{
					System.out.println(typegui + " is verified==>passs ");
				}
				else
				{
					System.out.println(typegui + " is not  verified==>fail");
				}
	}
	
	public void phone(String phone)
	{
		String actphone=guiphone.getText();
		
		if(actphone.equals(phone))
		{
			System.out.println(actphone+" is verified==>pass");
		}
		else
		{
			System.out.println(actphone+" is not  verified==>fail");
		}
	}
}
