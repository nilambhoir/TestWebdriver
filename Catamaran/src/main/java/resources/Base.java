package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

public static WebDriver driver;

// Created InitializeDriver Method to invoke browser 	
public WebDriver initializeDriver() throws IOException
{
	Properties prop = new Properties();  //Creating object of Properties File
	
	// Created property file & Given its path 
    FileInputStream fis = new FileInputStream("C:\\Users\\ITRs-32\\Catamaran\\src\\main\\java\\resources\\data.properties");  
	
    // Loading the Property File
    prop.load(fis);
    
    // Fetching value of Browser info from file
	String browserName =prop.getProperty("Browser");
	
	
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ITRs-32\\LatestAutomation\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ITRs-32\\LatestAutomation\\geckodriver.exe");
		 driver = new FirefoxDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return driver;

}

public void getScreenshot(String result) throws IOException
{
	File src =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File ("C://test//"+result+"screenshot.png"));
}



} 
