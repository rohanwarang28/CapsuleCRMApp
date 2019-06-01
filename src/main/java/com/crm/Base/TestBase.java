package com.crm.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	ChromeOptions options;
	FirefoxOptions ffoptions;
	public static WebDriverWait wait;
	
	
	public TestBase() throws IOException {
		
		prop = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\crm\\config\\config.properties");
		prop.load(fs);
	}
	
	
	public void initialization() {
		//for WINDOWS OS
		if(prop.getProperty("OS").equalsIgnoreCase("WINDOWS")) {
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver (2).exe");
			
			if(prop.getProperty("headlessmode").equalsIgnoreCase("ON")) {
				options = new ChromeOptions();
   				options.addArguments("--headless");
				driver=new ChromeDriver(options);
			
			}
			
			else 
				driver=new ChromeDriver();
				
		}
		
        if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\geckodriver.exe");
			
			if(prop.getProperty("headlessmode").equalsIgnoreCase("ON")) {
			ffoptions = new FirefoxOptions();
			ffoptions.setHeadless(true);
   			driver=new FirefoxDriver(ffoptions);	
			}
			
			else 
				driver=new FirefoxDriver();
				
		}
		
		
		}
		
		//for MAC OS
		
		if(prop.getProperty("OS").equalsIgnoreCase("MAC")) {
			
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
				
				if(prop.getProperty("headlessmode").equalsIgnoreCase("ON")) {
					options = new ChromeOptions();
	   				options.addArguments("--headless");
					driver=new ChromeDriver(options);
				
				}
				
				else 
					driver=new ChromeDriver();
					
			}
			
	        if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/geckodriver");
				
				if(prop.getProperty("headlessmode").equalsIgnoreCase("ON")) {
				ffoptions = new FirefoxOptions();
				ffoptions.setHeadless(true);
	   			driver=new FirefoxDriver(ffoptions);	
				}
				
				else 
					driver=new FirefoxDriver();
					
			}
			
			
			}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
}
