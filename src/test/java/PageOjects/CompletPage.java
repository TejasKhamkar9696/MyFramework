package PageOjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletPage extends BasePage {

	public CompletPage(WebDriver driver) {
		super(driver);
	}
	
	By orderPlacedMsg= By.xpath("//h2[@data-test='complete-header']");
	By backHomeBtn= By.id("back-to-products");
	
	
	public String getConfirmMsg()
	{
		return driver.findElement(orderPlacedMsg).getText();
	}
	
	public void clickBackHomeBtn()
	{
		driver.findElement(backHomeBtn).click();
	}

}
