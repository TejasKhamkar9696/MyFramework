package PageOjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	By cartPageTitle= By.xpath("//span[text()='Your Cart']");
	By inventoryItemName = By.xpath("//div[@data-test='inventory-item-name']");
	By checkoutBtn= By.xpath("//button[@id='checkout']");
	
	public boolean isCartPageTitleDisplayes()
	{
		return driver.findElement(cartPageTitle).isDisplayed();
	}
	
	public String getItemName()
	{
		return driver.findElement(inventoryItemName).getText();
	}
	
	public void clickCheckoutBtn()
	{
		driver.findElement(checkoutBtn).click();
	}

}
