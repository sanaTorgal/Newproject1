package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	//WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText ="Organizations")
	private WebElement orglink;
	
	
	
	public WebElement getDoclink() {
		return doclink;
	}

	@FindBy(linkText ="Contacts")
	private WebElement contactlink;
	
	@FindBy(linkText = "Documents")
	private WebElement doclink;
	
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminimg;
	
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;
	
	@FindBy(linkText = "Products")
	private WebElement prolink;
	
	@FindBy(linkText ="Leads")
	private WebElement leadlink;
	
	public WebElement getLeadlink() {
		return leadlink;
	}

	public WebElement getProlink() {
		return prolink;
	}

	public WebElement getAdminimg() 
	{
		return adminimg;
	}

	public WebElement getOrglink() 
	{
		return orglink;
	}

	public WebElement getContactlink()
	{
		return contactlink;
	}
	public void signOut(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(adminimg).perform();
		adminimg.click();
		signout.click();
		
		
		
	}
	
	

}
