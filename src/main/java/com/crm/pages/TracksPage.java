package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Base.TestBase;
import com.util.TestUtil;

public class TracksPage extends TestBase{

	@FindBy(xpath="//a[text()='Add new Track']")
	WebElement addNewTrackBtn;
	
	
	@FindBy(id="j_id123:taskLines:0:taskDescriptionDecorate:taskDescription")
	WebElement descField;
	
	public TracksPage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public boolean addTracks() {
		TestUtil.clickOn(driver, addNewTrackBtn, 10);
		
		TestUtil.addName();
		descField.sendKeys("Desc");
		TestUtil.clickSave();
		TestUtil.waitUntilVisible(driver, "//td[@class='list-column-left']/child::a[text()='John']", 3);
		return driver.findElement(By.xpath("//td[@class='list-column-left']/child::a[text()='John']")).isDisplayed();
		
		
	}

	
	
}
