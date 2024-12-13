package practice.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Get_Product_infoTest 
{
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] obj=new Object[2][2];
		obj[0][0]="iphone";
		obj[0][1]="Apple iPhone 16 (Teal, 256 GB)";
		
		obj[1][0]="iphone";
		obj[1][1]="Apple iPhone 16 Pro (Natural Titanium, 128 GB)";
		
		return obj;
		
		
	}
	
	
}
