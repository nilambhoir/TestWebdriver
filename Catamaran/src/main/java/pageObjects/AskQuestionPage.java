package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AskQuestionPage  {
	
	public WebDriver driver;
	
	
	By AskQuestion = By.cssSelector(".btn-danger");
	By TitleOfQuestion = By.xpath("//*[@id='title']");
	By Description = By.xpath("//*[@id='description']");
	By Topics = By.xpath("//*[@id='search_topics']");
	By opt1 = By.xpath("//*[@id='choice2']");
	By opt2 = By.xpath("//*[@id='choice4']");
	By img = By.xpath("//*[@id='uploadImage']");
	By submit = By.xpath("//*[@id='frm_question']/div[11]/button");
	

	 public AskQuestionPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver = driver;
	}

	public WebElement ClickAskNow()
	 {
		 return driver.findElement(AskQuestion);
	 }
     
	 public WebElement getTitle()
	 {
		 return driver.findElement(TitleOfQuestion);
	 }

	 public WebElement getDescription()
	 {
		 return driver.findElement(Description);
	 }

	 public WebElement getTopics()
	 {
		 return driver.findElement(Topics);
	 }

	 public WebElement getopt1()
	 {
		 return driver.findElement(opt1);
	 }
	 
	 public WebElement getopt2()
	 {
		 return driver.findElement(opt2);
	 }
	 
	 public WebElement getimg()
	 {
		 return driver.findElement(img);
	 }
	 
	 public WebElement getSubmit()
	 {
		 return driver.findElement(submit);
	 }
	 
}
