package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility
{
	
	//***********implicit wait***************
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	//************explicit wait************
	public void waitForPageElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void waitTillElementTobeSelected(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public void waittillElementBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//*************switching between windows using url************
	public void switchtoWinUrl(WebDriver driver,String partialurl)
	{
		 Set<String> allwin = driver.getWindowHandles();
		 for (String win : allwin) 
		 {
			 driver.switchTo().window(win);
			String url = driver.getCurrentUrl();
			System.out.println(url);
			if(url.contains(partialurl))
			{
				break;
			}
			
		}
	} 
	
		//***********switching between windows using title***************
		 
		 public void switchtoWinTitle(WebDriver driver,String partialTitle)
		{
				 Set<String> allwin = driver.getWindowHandles();
				 for (String win : allwin) 
				 {
					 driver.switchTo().window(win);
					String title = driver.getTitle();
					System.out.println( title );
					if(title.contains(partialTitle))
					{
						break;
					}
					
				}
		 
		}
		 
		 //********switching between frames************
		 
		 public void switchToFrame(WebDriver driver,int index)
		 {   
			 
			 driver.switchTo().frame(index);	  
		 }
		 public void switchtoframe(WebDriver driver,String nameId)
		 {
			 driver.switchTo().frame(nameId);	
			 
		 }
		 public void switchtoframe(WebDriver driver,WebElement element)
		 {
			 driver.switchTo().frame(element);	
			 
		 }

		 //**********Switch to alert************
		 public void switchToAlertandAccept(WebDriver driver)
		 {
			 driver.switchTo().alert().accept();
		 }
		 
		 public void switchToAlertandDismiss(WebDriver driver)
		 {
			 driver.switchTo().alert().dismiss();
		 }
		 
		 //***********drop down*******************
		 public void selectbytext(WebElement element,String text)
		 {
			Select sel=new Select(element);
			 sel.selectByVisibleText(text);
		 }
		 public void selectbyindex(WebElement element,int index)
		 {
			 Select sel= new Select(element);
			 sel.selectByIndex(index);
		 }
		 public void selectbyvalue(WebElement element,String value)
		 {
			 Select sel=new Select(element);
			 sel.selectByValue(value);
		 }
		
		 //************Actions class**************
		 public void mousemoveonElement(WebDriver driver,WebElement element)
		 {
			 Actions act=new Actions(driver);
			 act.moveToElement(element).perform();
		 }
		 
		 //double click
		 public void doubleClick(WebDriver driver,WebElement element)
		 {
			 Actions act=new Actions(driver);
			 act.doubleClick(element).perform();
		 }
		 //sendkeys
		 public void sendkeys(WebDriver driver,String  keys)
		 {
			 Actions act=new Actions(driver);
			 act.sendKeys(keys).perform();
		 }
		 //scroll bar using actions class
		 public void scrollDownByAmount(WebDriver driver)
		 {
			 Actions act=new Actions(driver);
			 act.scrollByAmount(0,900).perform();
		 }
		 public void scrolldownToElement(WebDriver driver,WebElement element)
		 {
			 Actions act=new Actions(driver);
			 act.scrollToElement(element).perform();
		 }
		 public void ScrollEntire(WebDriver driver)
		 {
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		 }
		 
		 //drag and drop
		 public void dragAndDrop(WebDriver driver,WebElement drag,WebElement drop)
		 {
			 Actions act=new Actions(driver);
			 act.dragAndDrop(drag, drop).perform();
			 	 
		 }
		 
		 //right click on webelement
		 public void rightClickOnElement(WebDriver driver,WebElement element)
		 {
			 Actions act=new Actions(driver);
			 act.contextClick(element).perform();
		 }
		 
		 //right click on webpage
		 public void rightClickOnPage(WebDriver driver)
		 {
			 Actions act=new Actions(driver);
			 act.contextClick().perform();
		 }
		 
		 //Double Click on webelement
		 public void DoubleClickonElement(WebDriver driver,WebElement element)
		 {
			 Actions act=new Actions(driver);
			 act.doubleClick().perform();
		 }
		 //********Scroll down by JS**********
		 public void scrollDownbyJs(WebDriver driver,int x,int y)
		 {
			 JavascriptExecutor js=( JavascriptExecutor)driver;
			 js.executeScript("window.scrollBy("+x+","+y+")");
				/*
				 * for(int i=0;i<5;i++) { js.executeScript("window.scrollBy(x,y)"); }
				 */
		 }
		 
		 //Scroll down by js till visibility of element
		 public void scrolltillelementJs(WebDriver driver,WebElement element)
		 {
			 JavascriptExecutor js=( JavascriptExecutor)driver;
			 for(int i=0;i<5;i++)
			 {
				 js.executeScript("arguments[0].scrollIntoView()",element);
			 }
		 }
		 public void maximize(WebDriver driver)
		 {
			 driver.manage().window().maximize();
			 
		 }
		 public void geturl(WebDriver driver,String  url)
		 {
			 
			 driver.get(url);
		 }
		 
}
