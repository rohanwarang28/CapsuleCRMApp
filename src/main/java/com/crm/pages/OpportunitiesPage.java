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
	
	@FindBy(xpath="//input[@class='form-input-text milestone-modal-name']")
	WebElement nameField;
	
	@FindBy(xpath="//input[@class='form-input-text milestone-modal-probability']")
	WebElement powField;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveBtn;
	
	public OpportunitiesPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
public boolean addmile() {
	TestUtil.clickOn(driver, addmileBtn, 10);
	//addmileBtn.click();
	TestUtil.switchWindows();
	TestUtil.waitUntilVisible(driver, "//input[@class='form-input-text milestone-modal-name']", 3);
	int random =(int) (Math. random() * 50 + 1);

	nameField.sendKeys("John"+random);
	//TestUtil.enterText(nameField, "John");
	powField.sendKeys("2");
	//TestUtil.enterText(powField, "2");
	
	saveBtn.click();
	
	return driver.findElement(By.xpath("//button[@class='hyperlink-button milestone-item-edit' and text()='John"+random+"']")).isDisplayed();
		
		
	}
	
	
	

}
