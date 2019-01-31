package ShipcomGroupId;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;

public class Search extends Base{

	@Test
	public void Search() throws IOException

	{
		driver = initializeDriver( );
		//driver.get("https://cushisd.shipcomwireless.com/web/#/login");
	    driver.get("https://test.crowdwisdom.co.in/");
	    
	    HomePage hp = new HomePage(driver);
	  // Assert.assertEquals(driver.getTitle().getText(), "xyz");
	
	}
@AfterTest
	
	public void Close()
	
	{
		driver.close();
		driver =null;
	}	


}

