package practice.testng;

import  static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertWithoutAsrt
{
	@Test
	public void hardAssertWithoutAsrt()
	{
		System.out.println("====line1===");
		System.out.println("====line2===");
		assertEquals('A', 'A');
		System.out.println("====line3===");
		System.out.println("====line4===");
		
	}

}
