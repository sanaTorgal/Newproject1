package practice.testng;
/**
 * test class for contact module
 * @author sana
 * 
 */

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class searchContactTest extends BaseClass
{
	/**
	 * Scenario:login()==>navigatecontact==>createContact()==>verify
	 */
	@Test
	public void searchContactTest() 
	{
		/*step 1:Login to app */
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp("admin", "admin");
	}
	

}
