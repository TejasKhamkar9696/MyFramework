package TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageOjects.HomePage;
import PageOjects.LoginPage;
import TestBase.BaseClass;

public class TC_002AddtoCartTest extends BaseClass {
	
	@Test(groups={"Master","Sanity"})
	public void addProductToCart() throws InterruptedException
	{
		//login page
		LoginPage lp= new LoginPage(driver);
		lp.inputUserName(p.getProperty("user"));
		lp.inputPassword(p.getProperty("password"));
		lp.clickLoginBtn();
		
		//home page
		
		HomePage hp= new HomePage(driver);
		boolean isShown=hp.showLogo();
		hp.addProductToCart();
		Boolean isAdded=hp.isProductAdded();
		
		Assert.assertEquals(true, isShown);
		Assert.assertEquals(true, isAdded);
		Thread.sleep(Duration.ofSeconds(10));
		
	}

}
