package ShipcomGroupId;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.FBLogin;
import resources.Base;

public class LoginByFB extends Base{
	
	public static Logger Log = LogManager.getLogger(Base.class.getName());
	@Test
	public void FBSignIn() throws IOException

	{
		driver = initializeDriver( );
	    driver.get("https://test.crowdwisdom.co.in/");
	  
	    FBLogin fb =new FBLogin(driver);
	    fb.getLoginPage().click();
	   
	    String hometab = driver.getWindowHandle();
	    fb.navigateFBLogin().click();
	    
	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(hometab);
	    // change focus to new tab
	    driver.switchTo().window(newTab.get(0));
	     String s = driver.getCurrentUrl();
	     Log.info(s);
	     
	     fb.getFBUsername().sendKeys("nilambhoir1990@gmail.com");
	     fb.getFBPassword().sendKeys("Sunday@123"); 
	     fb.getFBLog_In().click();
     }
	
	
	@AfterTest
	
	public void Close()
	
	{
		driver.close();
		driver =null;
	}

}


