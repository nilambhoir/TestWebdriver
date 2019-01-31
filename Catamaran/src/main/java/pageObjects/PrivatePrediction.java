package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrivatePrediction {
	
	public WebDriver driver;

	By title = By.xpath("//*[@id='title']");
	By description =By.xpath("//*[@id='description']");
	By Choice1 = By.xpath("//*[@id='choice2']");
	By Choice2 = By.xpath("//*[@id='choice4']");
	By AddChoice = By.className("add-more-choices");
	By Choice3 = By.xpath("//*[@id='choice5']");
	By endDate =By.id("end_date");
	By month = By.xpath("/html/body/div[7]/div[1]/table/thead/tr[2]/th[2]");
	//By month = By.cssSelector("[class='datepicker-days'][class='datepicker-switch']");/html/body/div[7]/div[1]/table/thead/tr[2]/th[2]
	By EmailId = By.xpath("//*[@id='emails']");
	By UploadImg = By.xpath("//*[@id='uploadImage']");
	By SubmitPoll = By.xpath("//*[@id='frm_prediction']/div[8]/button");
	
	public PrivatePrediction(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement gettitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getdescription()
	{
		return driver.findElement(description);
	}
	
	public WebElement getoption1()
	{
		return driver.findElement(Choice1);
	}
	
	public WebElement getoption2()
	{
		return driver.findElement(Choice2);
	}
	
	public WebElement addmoreoption()
	{
		return driver.findElement(AddChoice);
	}
	
	public WebElement getoption3()
	{
		return driver.findElement(Choice3);
	}
	
	public WebElement getEndDate()
	{
		 return driver.findElement(endDate);
		
    }
	
	public WebElement getMonth()
	{
		 return driver.findElement(month);
    }
	
	public WebElement getEmails()
	{
		return driver.findElement(EmailId);
	}
	
	
    public WebElement UploadImg()
    
    {
    	return driver.findElement(UploadImg);
    }

    public WebElement getSubmitpoll()
    
    {
    	return driver.findElement(SubmitPoll);
    }
}
