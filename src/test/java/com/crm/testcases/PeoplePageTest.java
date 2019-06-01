package com.crm.testcases;



import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.pages.PeoplePage;
import com.util.TestUtil;

public class PeoplePageTest extends TestBase{

	
	String sheetname = "People";
	LoginPage loginpage;
	HomePage homepage;
	PeoplePage peoplepage;
	SoftAssert asserts;
	public PeoplePageTest() throws IOException {
		super();
		
	}

	@BeforeMethod
	public void setup() throws IOException {
		
		initialization();
		loginpage=new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		peoplepage = homepage.clickOnPeopleIcon();
		
		
		
	}
	
	@DataProvider
	public Object[][] getPeopleData() throws InvalidFormatException, IOException {
		
		Object data[][]=TestUtil.getTestData(sheetname);
		return data;
	}
	
	
	@Test(dataProvider="getPeopleData")
	public void addPersonTest(String title,String fname,String lname,String jobTitle,String org,String tag,String phno,String email,String casename,String casedesc,String casetag) throws IOException {
		
		peoplepage.addNewPerson(title, fname, lname, jobTitle, org, tag, phno, email);
		homepage.clickOnPeopleIcon();
		asserts = new SoftAssert();
		
		
		
		asserts.assertEquals(peoplepage.verifyCustomerAdded(fname+" "+lname),true );
		asserts.assertAll();
	}
	
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
	}
	
}
