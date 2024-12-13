package practice.testng;

import org.testng.annotations.Test;

public class ExtentTest1 
{
	@Test
	public void createDemoTest()
	{
		int a=10;
		int b=20;
		System.out.println("=========step1====");
		System.out.println("=========step2====");
		add(10,20);
		System.out.println("=========step3====");
		System.out.println("=========step4====");
	}
	public int add(int c,int d)
	{
		return c+d;
	}

}
