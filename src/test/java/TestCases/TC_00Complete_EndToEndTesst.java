package TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageOjects.CartPage;
import PageOjects.CheckoutInfoPage;
import PageOjects.CheckoutOverviewPage;
import PageOjects.CompletPage;
import PageOjects.HomePage;
import PageOjects.LoginPage;
import TestBase.BaseClass;

public class TC_00Complete_EndToEndTesst extends BaseClass{
	
	@Test(groups={"Master","Sanity","Regression"})
	public void completeEntToEndTest() throws InterruptedException
	{
		        //login page
				LoginPage lp= new LoginPage(driver);
				lp.inputUserName(p.getProperty("user"));
				lp.inputPassword(p.getProperty("password"));
				lp.clickLoginBtn();
				Thread.sleep(Duration.ofSeconds(3));
				
				//home page
				
				HomePage hp= new HomePage(driver);
				hp.addProductToCart();
				hp.clickAddToCart();
				Thread.sleep(Duration.ofSeconds(3));
			
				
				//CartPage
				CartPage cp= new CartPage(driver);
				cp.clickCheckoutBtn();
				Thread.sleep(Duration.ofSeconds(3));
				
				//checkoutPage
				CheckoutInfoPage cf= new CheckoutInfoPage(driver);
				cf.inputUserInfo("Raja", "anaana", "411010");
				cf.clickContinueBtn();
				Thread.sleep(Duration.ofSeconds(3));
				
				//overview page
				CheckoutOverviewPage cop= new CheckoutOverviewPage(driver);
				cop.clickFinishBtn();
				Thread.sleep(Duration.ofSeconds(3));
				
				
				//complete page
				CompletPage cmp= new CompletPage(driver);
				String confirmMessage= cmp.getConfirmMsg();
				
				if(confirmMessage.equals(p.getProperty("productConfirm")))
				{
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
				cmp.clickBackHomeBtn();
				
				//click logout
				hp.clickHamBurger();
				hp.clickLogoutLink();
				Thread.sleep(Duration.ofSeconds(3));
		
	}

}
