package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Base.TestBase;
import com.util.TestUtil;

public class UsersPage extends TestBase{

	@FindBy(xpath="//a[text()='Add new User']")
	WebElement adduserBtn;
	
	@FindBy(id="register:firstnameDecorate:firstName")
	WebElement fnameField;
	
	@FindBy(id="register:lastNameDecorate:lastName")
	WebElement lnameField;
	
	@FindBy(id="register:emailDecorate:email")
	WebElement emailField;
	
	@FindBy(id="register:usernameDecorate:username")
	WebElement usernameField;
	
	@FindBy(id="register:save")
	WebElement saveBtn;
	
	
	public UsersPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public boolean addUser() {
		
		adduserBtn.click();
		TestUtil.waitUntilVisible(driver, "//input[@id='register:firstnameDecorate:firstName']", 3);
		fnameField.sendKeys("John");
		lnameField.sendKeys("K");
		emailField.sendKeys("jk@gmail.com");
		usernameField.sendKeys("rohan");
		
		saveBtn.click();
		return driver.findElement(By.xpath("//td[@class='list-column-left']/child::a[contains(text(),'John K')]")).isDisplayed();
	}
	

}
