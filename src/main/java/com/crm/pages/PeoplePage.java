package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.Base.TestBase;
import com.util.TestUtil;

public class PeoplePage extends TestBase{

	@FindBy(xpath = "//a[text()='Add Person']")
	WebElement addPersonBtn;
	
	@FindBy(id="party:fnDecorate:fn")
	WebElement fnameField;
	
	@FindBy(id="party:lnDecorate:ln")
	WebElement lnameField;
	
	@FindBy(id="party:roleDecorate:jobTitle")
	WebElement jobField;
	
	@FindBy(id="party:orgDecorate:org")
	WebElement orgField;
	
	@FindBy(name="party:j_id108:j_id116")
	WebElement titleDrop;
	
	@FindBy(id="party:tagsDecorate:tagComboBox")
	WebElement tagField;
	
	
	@FindBy(id="party:j_id325:0:phnDecorate:number")
	WebElement phField;
	
	
	@FindBy(id="party:j_id342:0:emlDecorate:nmbr")
	WebElement emailField;
	
	@FindBy(id="party:save")
	WebElement saveBtn;
	
	@FindBy(id="party:tagsDecorate:j_id187")
	WebElement addTagBtn;
	
	
	
	
	public PeoplePage() throws IOException {
		//super();
		PageFactory.initElements(driver, this);
	}

	
	public void addNewPerson(String title,String ftname,String ltname,String jobtitle,String org,String tag,String phoneNo,String email) {
		
	    TestUtil.clickOn(driver, addPersonBtn, 20);
		
		TestUtil.selectIt(driver, titleDrop, title);
		
		fnameField.sendKeys(ftname);
		lnameField.sendKeys(ltname);
		jobField.sendKeys(jobtitle);
		orgField.sendKeys(org);
		tagField.sendKeys(tag);
		addTagBtn.click();
		
		phField.sendKeys(phoneNo);
		emailField.sendKeys(email);
		
		saveBtn.click();
		
	}
	
	
	
	
	
	public boolean verifyCustomerAdded(String custName) {
		String xpath ="(//td[@class='list-results-cell is-party is-system is-summary ember-view']/child::a[text()='"+custName+"'])[1]";
		TestUtil.waitUntilVisible(driver, xpath, 5000);
		return driver.findElement(By.xpath("(//td[@class='list-results-cell is-party is-system is-summary ember-view']/child::a[text()='"+custName+"'])[1]")).isDisplayed();
		
		
		
		
	}
	
}
