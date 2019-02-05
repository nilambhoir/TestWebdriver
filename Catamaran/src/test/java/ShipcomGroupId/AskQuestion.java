package ShipcomGroupId;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AskQuestionPage;
import pageObjects.FBLogin;
import pageObjects.HomePage;
import resources.Base;

public class AskQuestion extends Base{

	WebDriverWait wait;

	public static Logger Log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initializeTest() throws IOException
	{
		driver = initializeDriver( );
		Log.info(" Chrome Driver is initialized");
		
	    driver.get("https://test.crowdwisdom.co.in/");
	    Log.info("Landing to crowdwisdom site");
	    
	    driver.manage().window().maximize();
	    Log.info("Maximizing the screen");
	  
	    FBLogin fb =new FBLogin(driver);
	    fb.getLoginPage().click(); // clicking on login button
	    Log.info(" Clicking on Login screen");
	   
	    String hometab = driver.getWindowHandle();
	    fb.navigateFBLogin().click();
	    Log.info(" Navigating to FB Login Screen");
	    
	    
	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(hometab);
	    // change focus to new tab
	    driver.switchTo().window(newTab.get(0));
	     String s = driver.getCurrentUrl();
	    // Log.info(s);
	     
	     fb.getFBUsername().sendKeys("nilambhoir1990@gmail.com");
	     //Log.info("Entering  username ");
	     
	     fb.getFBPassword().sendKeys("Sunday@123"); 
	     //Log.info("Entering Password ");
	     
	     String fbtab = driver.getWindowHandle();
	     fb.getFBLog_In().click();
	     Log.info("Logged in with FB");
	     
	     ArrayList<String> nextTab = new ArrayList<String>(driver.getWindowHandles());
		 nextTab.remove(fbtab);
		  // change focus to login screen
		  driver.switchTo().window(nextTab.get(0));
		 	  
	}	
	
	@DataProvider
	
	public Object[][] getData1()
	{
		Object[][] data = new Object[2][2];
		
		data[0][0] = "Med";
		data[0][1] = "Medicine";
		
		data[1][0]= "Med";
		data[1][1]= "Mediclaim";
		
		return data;
		
	}
	
		 @Test
		 
		 public void  AskQuestionFunction() throws InterruptedException
		 {
			 	 
	     HomePage hp = new HomePage(driver);
	     hp.clickOnQuestion().click();
		  
		 AskQuestionPage q = new AskQuestionPage(driver);
		  q.ClickAskNow().click();
		  Log.info("Clicked on AskQuestion button");
		  
		  q.getTitle().sendKeys("How many of the 5 Lok Sabha Seats in Uttarakhand will BJP win in 2019?");
		  Log.info("Entered title of question");
		  
		  q.getDescription().sendKeys("The 2014 Indian general election in Uttarakhand, occurred for 5 seats in the state. All 5 seats were won by the Bharatiya Janata Party. Now the scenario has changed. Give your opinion");
		  Log.info("Entered description");
		
		 }
		 
		 @Test(dataProvider ="getData1")
		 
		 public void autocomplete(String key, String selection)
		 {
		  //step 1: click on topic field
		
		  driver.findElement(By.name("search_topics")).sendKeys(key);
		  WebElement autolist  = driver.findElement(By.xpath("//*[@id='frm_question']/div[4]"));
		  wait = new WebDriverWait(driver, 5);
		  wait.until(ExpectedConditions.visibilityOf(autolist));
		  
		  List<WebElement> optionsToSelect = autolist.findElements(By.xpath("//*[@id='frm_question']/div[4]/div[1]/a"));
		  for(WebElement option : optionsToSelect){
		        if(option.getText().equals(selection)) {
		        	System.out.println("Trying to select: "+optionsToSelect);
		            option.click();
		            break;
		        }
		    }
		  
		  
		 }
	
			
		}
		  
		 
		  
		  
	








