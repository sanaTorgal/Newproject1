package practice.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SoftAssrtwthout_sa 
{
	@Test
	public void softAssrtwthout_sa()
	{
		SoftAssert sa= new SoftAssert();
		
		System.out.println("====line1===");
		System.out.println("====line2===");
		sa.assertEquals('A', 'B');
		sa.assertAll();
		System.out.println("====line3===");
		System.out.println("====line4===");
		
		
	}

}
