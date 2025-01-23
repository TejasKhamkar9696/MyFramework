package TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageOjects.CartPage;
import PageOjects.CheckoutInfoPage;
import PageOjects.CheckoutOverviewPage;
import PageOjects.HomePage;
import PageOjects.LoginPage;
import TestBase.BaseClass;

public class TC_005CheckoutOverviewTest extends BaseClass {
	
	@Test(groups={"Master","Regression"})
	public void overviewPagevalidations() throws InterruptedException
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
		cp.clickCheckoutBtn();
		
		//checkoutPage
		CheckoutInfoPage cf= new CheckoutInfoPage(driver);
		cf.inputUserInfo("Raja", "anaana", "411010");
		cf.clickContinueBtn();
		
		//overview page
		CheckoutOverviewPage cop= new CheckoutOverviewPage(driver);
		cop.clickFinishBtn();
		Assert.assertTrue(cop.isOverviewTitleDisplayed());
		Thread.sleep(Duration.ofSeconds(10));
	}

}
