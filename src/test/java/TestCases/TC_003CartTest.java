package TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageOjects.CartPage;
import PageOjects.HomePage;
import PageOjects.LoginPage;
import TestBase.BaseClass;

public class TC_003CartTest extends BaseClass {
	
	@Test(groups={"Master","Regression"})
	public void validateCartProduct() throws InterruptedException
	{
		//login page
		LoginPage lp= new LoginPage(driver);
		lp.inputUserName(p.getProperty("user"));
		lp.inputPassword(p.getProperty("password"));
		lp.clickLoginBtn();
		
		//home page
		
		HomePage hp= new HomePage(driver);
		hp.addProductToCart();
		hp.clickAddToCart();
	
		
		//CartPage
		CartPage cp= new CartPage(driver);
		Boolean isDisplayed= cp.isCartPageTitleDisplayes();
		String productName=cp.getItemName();
		
		cp.clickCheckoutBtn();
		
		Assert.assertEquals(true, isDisplayed);
		if(productName.equals(p.getProperty("productName")))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		Thread.sleep(Duration.ofSeconds(10));
		
		
	}

}
