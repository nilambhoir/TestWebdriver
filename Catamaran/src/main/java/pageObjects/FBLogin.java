package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FBLogin {
	
	
	public WebDriver driver;
	
	By Login = By.xpath("/html/body/div[1]/div/div[1]/div[3]/a");
	By FB = By.xpath("//*[@id='facebook']");
	By FBUsername = By.xpath("//*[@id='email']");
	By FBPassword = By.xpath("//*[@id='pass']");
	By FBSignIn = By.xpath("//*[@id='u_0_0']");
	
	public FBLogin(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getLoginPage()
	{
		return driver.findElement(Login); // clicking on login button from homr page
		
	}
	
	public WebElement navigateFBLogin()
	{
		return driver.findElement(FB);
	}

	public WebElement getFBUsername()
	{
		return driver.findElement(FBUsername);
	}
	
	public WebElement getFBPassword()
	{
		return driver.findElement(FBPassword);
	}
	
	public WebElement getFBLog_In()
	{
		return driver.findElement(FBSignIn);
	}
	
	
}
