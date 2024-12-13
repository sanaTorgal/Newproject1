package practice.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Fetch_Data_From_otherclassTest
{
	@Test(dataProviderClass=Get_Product_infoTest.class,dataProvider="getdata")
	public void  fetch_Data_From_otherclassTest(String brand,String product)
	{		WebDriver driver=new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
	
			driver.findElement(By.name("q")).sendKeys(brand,Keys.ENTER);

			String price = driver.findElement(By.xpath("//div[text()='"+product+"']/ancestor::div[@class=\"yKfJKb row\"]/descendant::div[@class=\"Nx9bqj _4b5DiR\"]")).getText();
			System.out.println(price);
	}
	
}
