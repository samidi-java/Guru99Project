package testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ConfigUtil;

public class BaseTest {
WebDriver driver;
public static Logger logger= Logger.getLogger("ebanking");

ConfigUtil config=new ConfigUtil();
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser)
	{
		PropertyConfigurator.configure(config.getLog4jPath());
		//Pre_Requisit steps
		if(browser.equals("edge"))
		{
		System.setProperty("webdriver.edge.driver", config.getEdgePath());
		driver=new EdgeDriver(); 
		}else if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", config.getChromePath());
			driver=new ChromeDriver(); 
		}else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", config.getGeckoPath());
			driver=new FirefoxDriver(); 
		}
	}
	
	@AfterMethod
	public void destroy()
	{
		//close browser
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver,String tcName)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"\\screenshots\\"+tcName+".png");
	    try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
