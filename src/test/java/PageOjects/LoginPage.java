package PageOjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By UserName= By.xpath("//input[@id='user-name']");
	By Password= By.xpath("//input[@id='password']");
	
	By btnSubmit= By.xpath("//input[@id='login-button']");
	
	
	public void inputUserName(String name)
	{
		 driver.findElement(UserName).sendKeys(name);
	}
	
	public void inputPassword(String pass)
	{
		 driver.findElement(Password).sendKeys(pass);
	}
	
	public void clickLoginBtn()
	{
		 driver.findElement(btnSubmit).click();
	}

}
