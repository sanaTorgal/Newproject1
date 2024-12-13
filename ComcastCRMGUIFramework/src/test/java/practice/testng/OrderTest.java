package practice.testng;

import org.testng.annotations.Test;

public class OrderTest
{
	@Test(invocationCount = 5)
	public void createOrderTest()
	{
		System.out.println("Execute create order test==");
		//String str=null;
		//System.out.println(str.equals("123"));
	}
	@Test(enabled = false)
	public void billingOrderTest()
	{
		System.out.println("execute billing order test:");
	}
}
