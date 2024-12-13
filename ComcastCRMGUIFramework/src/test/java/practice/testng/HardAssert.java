package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert
{
	@Test
	public void hardAssert()
	{
		System.out.println("====line1===");
		System.out.println("====line2===");
		Assert.assertEquals('A', 'B');
		System.out.println("====line3===");
		System.out.println("====line4===");
		
	}


}
