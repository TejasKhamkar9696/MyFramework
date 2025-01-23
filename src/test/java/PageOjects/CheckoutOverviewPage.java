package PageOjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage{

	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
	}
	
	By overviewPageTitle = By.xpath("//span[@data-test='title']");
	
	By finishBtn= By.id("finish");
	
	
	public boolean isOverviewTitleDisplayed()
	{
		return driver.findElement(overviewPageTitle).isDisplayed();
	}
	
	public void clickFinishBtn()
	{
		driver.findElement(finishBtn).click();
	}

}
