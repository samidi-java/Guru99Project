package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class LoginTest extends BaseTest {

	
	@Test
	public void loginTestWithValidCredentials()
	{
		logger.info("loginTestWithValidCredentials test is started");
		driver.get(config.getApplicationUrl());
		logger.info("https://demo.guru99.com/V4/index.php url is opened");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserId(config.getUserName());
		logger.info("User id entered sucessfully");
		loginPage.enterPassword(config.getPassword());
		logger.info("Password entered sucessfully");
		loginPage.clickLogin();
		logger.info("Login button clicked sucessfully");
		String actualTitle=driver.getTitle();
		String expectedTitle="Guru99 Bank Manager HomePage";
		logger.info("actualTitle:"+actualTitle);
		logger.info("expectedTitle:"+expectedTitle);
		//Assert.assertEquals(actualTitle, expectedTitle);
		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);
		}else
		{
			captureScreenshot(driver, "loginTestWithValidCredentials");
			Assert.assertTrue(false);
		}
		logger.info("loginTestWithValidCredentials test is completed");
		
	}
	
	@Test
	public void test2()
	{
		Assert.assertEquals(true, true);
	}
	
	
	@Test
	public void test3()
	{
		Assert.assertEquals(true, true);
	}
	@Test
	public void test4()
	{
		Assert.assertEquals(true, true);
	}
	
	@Test
	public void test5()
	{
		Assert.assertEquals(true, true);
	}
}
