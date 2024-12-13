package practice.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTest
{
	@Test(invocationCount = 2,threadPoolSize = 2)
	public void m1()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		System.out.println("Hello");
	}

}
