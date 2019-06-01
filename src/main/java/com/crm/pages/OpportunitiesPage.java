package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Base.TestBase;
import com.util.TestUtil;

public class OpportunitiesPage extends TestBase{

	
	@FindBy(xpath="//button[text()='Add new Milestone']")
	WebElement addmileBtn;
	
	@FindBy(xpath="//label[contains(text(),'Name')]/parent::div/following-sibling::span/input")
	WebElement nameField;
	
	@FindBy(xpath="//input[@class='form-input-text milestone-modal-probability']")
	WebElement powField;
	
	public OpportunitiesPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
public boolean addmile() {
	TestUtil.clickOn(driver, addmileBtn, 10);
	//addmileBtn.click();
	TestUtil.waitUntilVisible(driver, "//input[@id='register:firstnameDecorate:firstName']", 3);
	nameField.sendKeys("John");
	powField.sendKeys("2");
	return driver.findElement(By.xpath("//button[@class='hyperlink-button milestone-item-edit' and text()='John']")).isDisplayed();
		
		
	}
	
	
	

}
