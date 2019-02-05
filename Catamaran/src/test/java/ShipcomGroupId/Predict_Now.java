package ShipcomGroupId;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.FBLogin;
import pageObjects.HomePage;
import pageObjects.PrivatePrediction;
import resources.Base;

public class Predict_Now extends Base {
	
	
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
		 // String s1 = driver.getCurrentUrl();
		  //System.out.println(s1);

	     HomePage hp = new HomePage(driver);
		 hp.Prediction().click();
		 //Log.info("Clicked on Predic Now from Home Screen");
		 
		 hp.Add_Prediction().click();
         //Log.info("Clicked on  add Prediction button");
	}
	
	@Test
	public void  AddPrivatePrediction() throws InterruptedException
	{
		final PrivatePrediction pp = new PrivatePrediction(driver);
		pp.gettitle().sendKeys("Who will be the next prime minister?");
		Log.info(" Entering title of prediction in the title field");
	
		pp.getdescription().sendKeys("This is test description to check private prediction");
		Log.info(" Entering description of prediction in the description field");
		
		pp.getoption1().sendKeys("Rahul Gandhi");
		Log.info(" Entered option 1");
		
		pp.getoption2().sendKeys("Narendra Modi");
		Log.info(" Entered option 2");
		
		pp.addmoreoption().click();
		Log.info(" Clicked on Add More Option");
		
		pp.getoption3().sendKeys("Raj Thakre");
		Log.info(" Entered option 3");
		
		pp.getEndDate().click();
		Log.info("Click on End date Field");
		
		while(!pp.getMonth().getText().contains("April")) // Checkng current Month is April
		{
			//Checking That if Month is not april then Click on Next Button. 
			driver.findElement(By.xpath("/html/body/div[7]/div[1]/table/thead/tr[2]/th[3]")).click(); 
		}
		Log.info("Select month");
		
		List<WebElement>  dates = driver.findElements(By.className("day"));
		int count =driver.findElements(By.className("day")).size();
		
		for (int i=0; i<=count; i++)
		{
 			String text = driver.findElements(By.className("day")).get(i).getText();
			if (text.equalsIgnoreCase("23"))
				{
					driver.findElements(By.className("day")).get(i).click();
					Log.info(" select required day from calender");
				    break;
				}		
		}
       
		pp.getEmails().sendKeys("nilambhoir26@gmail.com");
		Log.info("Entered required email Ids");
		//pp.UploadImg().sendKeys("C:\\Users\\ITRs-32\\Catamaran\\src\\DataFiles\\ba107735e52eeca6ff908182b9f2-is-the-confederate-flag-a-positive-or-negative-symbol.jpg");
		
		File file = new File("./DataFiles/img1.jpg");
		pp.UploadImg().sendKeys(file.getAbsolutePath());
		Log.info("Upload  prediction img ");
	
		Thread.sleep(5000);
		
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        
        pp.getSubmitpoll().click();
  
        
	} 
	   
	/*@AfterTest
	
	public void Close()
	{
		driver.close();
		driver =null;
	}*/
	
}


  