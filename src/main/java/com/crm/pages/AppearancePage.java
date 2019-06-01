package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Base.TestBase;

public class AppearancePage extends TestBase{
	
	
	@FindBy(id="appearance:uploadDecorate:logoImage")
	WebElement chooseFilePath;

	public AppearancePage() throws IOException {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void uploadFile() {
		
		chooseFilePath.sendKeys(System.getProperty("user.dir")+"\\logo.png");
		
	}

	
}
