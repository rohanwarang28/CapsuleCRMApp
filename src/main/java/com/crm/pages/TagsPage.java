package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Base.TestBase;
import com.util.TestUtil;

public class TagsPage extends TestBase{

	
	@FindBy(xpath="//a[text()='Add new Tag']")
	WebElement addNewTagBtn;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement saveBtn;
	
	public TagsPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public boolean addTags() {
		TestUtil.clickOn(driver, addNewTagBtn, 10);
		TestUtil.switchWindows();
		TestUtil.addName();
		//descField.sendKeys("Desc");
		
		//TestUtil.waitUntilVisible(driver, "//td[@class='list-column-left']/child::span/child::a[text()='John']", 3);
		TestUtil.jsClick(saveBtn);
		TestUtil.waitUntilVisible(driver, "//td[@class='list-column-left']/child::span/child::a[text()='John']", 3);
		return driver.findElement(By.xpath("//td[@class='list-column-left']/child::span/child::a[text()='John']")).isDisplayed();
		
		
	}

}
