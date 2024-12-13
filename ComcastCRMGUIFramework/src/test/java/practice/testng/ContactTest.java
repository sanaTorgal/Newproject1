package practice.testng;

import org.testng.annotations.Test;

public class ContactTest 
{
	@Test()
	public void createContactTest()
	{
		System.out.println("execute create contact" );
	}
	@Test(dependsOnMethods = "createContactTest")
	public void modifyContactTest()
	{
		System.out.println("execute modify contacttest");
	}
	@Test(dependsOnMethods = "modifyContactTest")
	public void deleteContactTest()
	{
		System.out.println("delete contact test");
	}
}
