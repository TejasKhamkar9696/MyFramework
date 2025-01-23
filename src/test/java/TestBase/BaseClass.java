package TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	public static WebDriver driver;
	public Properties p;
	
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters({"browser"})
	public void setup(String br) {
	    try {
	        System.out.println("Loading properties file...");
	        FileReader file = new FileReader("C:\\Users\\Tejas\\eclipse-workspace\\SauceDemo\\src\\test\\resources\\config.properties");
	        p = new Properties();
	        p.load(file);
	        System.out.println("Properties loaded successfully!");
	        System.out.println("appUrl: " + p.getProperty("appUrl"));

	        String appUrl = p.getProperty("appUrl");
	        if (appUrl == null || appUrl.isEmpty()) {
	            throw new IllegalArgumentException("The appUrl property is missing or empty in config.properties");
	        }
	        
	        switch(br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver(); break;
			case "edge" : driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name.."); return;
			}
	       
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        driver.get(p.getProperty("appUrl"));
	        driver.manage().window().maximize();
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Setup failed: " + e.getMessage());
	    }
	}

	
	
	@AfterClass(groups={"Master","Sanity","Regression"})
	public void tearDown()
	{
		driver.quit();
	}

	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
