package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	
	public WebDriver driver;
	
	By Search = By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/div/input");
	By Prediction = By.xpath("//*[@id='popularpredictions']/div[1]/div[1]/div/div[2]/button");
	By Add_Predict = By.xpath("/html/body/div[4]/div/div[1]/div[1]/div[2]/div/div[2]/a");
	By Question = By.xpath("/html/body/div[4]/div[3]/div[2]/div/div[1]/div[1]/a/div");
	
	
	
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver =driver;
	}

	public WebElement getSearch()
	{
		return driver.findElement(Search);
	}
	
	public WebElement Prediction()
	{
		return driver.findElement(Prediction);
	}
	
	public WebElement Add_Prediction()
	{
		return driver.findElement(Add_Predict);
	}
	
	public WebElement clickOnQuestion()
	{
		return driver.findElement(Question);
	}
	
	
}
	