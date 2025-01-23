package PageOjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By productTitle= By.xpath("//span[text()='Products']");
	
	By bagPack= By.xpath("(//div[text()='Sauce Labs Backpack']//..//..//following-sibling::div)[2]//button");
	
	By shoppingBadge= By.xpath("//span[@data-test='shopping-cart-badge']");
	
	By addToCart= By.xpath("//a[@data-test='shopping-cart-link']");
	
	By hamBurger= By.id("react-burger-menu-btn");
	
	By logoutMenu= By.xpath("//a[text()='Logout']");
	
	
	public boolean showLogo()
	{
		return driver.findElement(productTitle).isDisplayed();
	}
	
	public void addProductToCart()
	{
		driver.findElement(bagPack).click();
	}

	public boolean isProductAdded()
	{
		return driver.findElement(shoppingBadge).isDisplayed();
	}
	
	public void clickAddToCart()
	{
		driver.findElement(addToCart).click();
	}
	
	public void clickHamBurger()
	{
		driver.findElement(hamBurger).click();
	}
	
	public void clickLogoutLink()
	{
		driver.findElement(logoutMenu).click();
	}
	

}
