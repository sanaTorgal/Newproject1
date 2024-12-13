package practice.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetDataFromApp 
{
	@Test(dataProvider = "getdata")
	public void getDataFromApp(String brand,String product)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys(brand,Keys.ENTER);
	
		String price = driver.findElement(By.xpath("//div[text()='"+product+"']/ancestor::div[@class=\"yKfJKb row\"]/descendant::div[@class=\"Nx9bqj _4b5DiR\"]")).getText();
		System.out.println(price);
		
	}
	@DataProvider
	public Object[][] getdata() throws Throwable
	{
		/*ExcelUtility elib=new ExcelUtility();
		int rowcount = elib.getRowcount("phone");
		Object[][] objArr=new Object[rowcount][2];
		for(int i=0;i<rowcount;i++)
		{
		   objArr[0][0]=elib.getdataFromExcel("phone", i+1, 0);
		   objArr[0][1]=elib.getdataFromExcel("phone",i+1, 1);
		}*/
		Object[][] objArr=new Object[2][2];
		objArr[0][0]="iphone";
		objArr[0][1]="Apple iPhone 16 (Teal, 256 GB)";
		
		objArr[1][0]="iphone";
		objArr[1][1]="Apple iPhone 16 Pro (Natural Titanium, 128 GB)";
		
		return objArr;
		
		
	}
		
		

}
