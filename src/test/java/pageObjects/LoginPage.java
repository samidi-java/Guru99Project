package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

@FindBy(name="uid")
WebElement userIdField;


@FindBy(name="password")
WebElement passwordField;


@FindBy(name="btnLogin")
WebElement loginButton;

@FindBy(linkText ="Log out")
WebElement logoutButton;


public void enterUserId(String userId)
{
	userIdField.sendKeys("mngr412134");
}
	
public void enterPassword(String password)
{
	passwordField.sendKeys(password);
}

public void clickLogin()
{
	loginButton.click();
}


public void clickLogout()
{
	logoutButton.click();
}
	
}
