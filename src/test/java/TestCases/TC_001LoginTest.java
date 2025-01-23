package TestCases;

import org.testng.annotations.Test;

import PageOjects.HomePage;
import PageOjects.LoginPage;
import TestBase.BaseClass;

public class TC_001LoginTest extends BaseClass {
	
	
	@Test(groups={"Master", "Sanity"})
	public void loginTest()
	{
		try {
		
		LoginPage lp= new LoginPage(driver);
		
		lp.inputUserName(p.getProperty("user"));
		lp.inputPassword(p.getProperty("password"));
		lp.clickLoginBtn();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
