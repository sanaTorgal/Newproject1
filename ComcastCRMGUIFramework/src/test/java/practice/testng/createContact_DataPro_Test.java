package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class createContact_DataPro_Test
{
	@Test(dataProvider = "getData")
	public void CreatecontactTest(String fname,String lname)
	{
		System.out.println("FirstName:"+fname +" ,last name" + lname);
		
	}
	@DataProvider
	public Object[][] getData() 
	{
		Object [][]	objArr=new Object[3][2];
		objArr[0][0] ="Anshi ";
		objArr[0][1] ="hr ";
		
		
		objArr[1][0] ="veena";
		objArr[1][1] ="sh";
		
		objArr[2][0] ="Rashmi";
		objArr[2][1] ="Smith";  
		
		return objArr;
	
	
	}

}