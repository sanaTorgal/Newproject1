package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class createContact_DataPro_Test2
{
	@Test(dataProvider = "getData")
	public void CreatecontactTest(String fname,String lname, long phno)
	{
		System.out.println("FirstName:"+fname +" ,last name" + lname+"phoneno:"+phno);
		
	}
	@DataProvider
	public Object[][] getData() 
	{
		Object [][]	objArr=new Object[3][3];
		objArr[0][0] ="Anshi ";
		objArr[0][1] ="hr ";
		objArr[0][2] =13456789l;
		
		
		objArr[1][0] ="veena";
		objArr[1][1] ="sh";
		objArr[1][2] =1123457l;
		
		
		objArr[2][0] ="Rashmi";
		objArr[2][1] ="Smith";  
		objArr[2][2] =133456789l;
		
		
		return objArr;
	
	
	}

}