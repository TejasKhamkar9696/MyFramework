package PageOjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CheckoutInfoPage extends BasePage{
	
	public CheckoutInfoPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	By userName= By.id("first-name");
	By lastName= By.id("last-name");
	By postalCode= By.id("postal-code");
	
	
	By continueBtn= By.id("continue");
	
	
	public void inputUserInfo(String name, String lstname, String code)
	{
		driver.findElement(userName).sendKeys(name);
		driver.findElement(lastName).sendKeys(lstname);
		driver.findElement(postalCode).sendKeys(code);
	}
	
	public void clickContinueBtn()
	{
		driver.findElement(continueBtn).click();
	}
	
	

}
