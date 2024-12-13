package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert1 
{
	@Test
	public void softassert1()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("====line1===");
		System.out.println("====line2===");
		sa.assertEquals('A', 'B');
		//sa.assertAll();
		System.out.println("====line3===");
		System.out.println("====line4===");
		
	}

}
