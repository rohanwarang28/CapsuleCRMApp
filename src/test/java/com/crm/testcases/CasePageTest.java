package com.crm.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Base.TestBase;
import com.crm.pages.CasePage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.pages.PeoplePage;
import com.util.TestUtil;

public class CasePageTest extends TestBase{

	String sheetname = "People";
	LoginPage loginpage;
	HomePage homepage;
	CasePage casepage;
	SoftAssert asserts;
	public CasePageTest() throws IOException {
		super();
		
	}

	@BeforeMethod
	public void setup() throws IOException {
		
		initialization();
		loginpage=new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		casepage = homepage.clickOnCasesIcon();
		
		
		
	}
	
	@DataProvider
	public Object[][] getPeopleData() throws InvalidFormatException, IOException {
		
		Object data[][]=TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(dataProvider="getPeopleData")
	public void addCaseTest(String title,String fname,String lname,String jobTitle,String org,String tag,String phno,String email,String casename,String casedesc,String casetag) throws IOException 
	
	{
		
		casepage.addNewCase(fname,lname,casename,casedesc,casetag);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String casenameReflected = driver.findElement(By.xpath("//div[@class='entity-details-title']")).getText();
		String usernameReflected = driver.findElement(By.id("ember72")).getText();
		
		boolean status = driver.findElement(By.xpath("//span[@class='kase-summary-status-open']")).isDisplayed();
		
		asserts.assertEquals(casenameReflected, casename);
		asserts.assertEquals(usernameReflected, fname+" "+lname);
		asserts.assertEquals(status, true);
		asserts.assertAll();
		
}
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
	}
	
}
	
