package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.Base.TestBase;
import com.util.TestUtil;

public class HomePage extends TestBase{

	
	@FindBy(xpath="//a[@href='/parties']")
	WebElement peopleIcon;
	
	@FindBy(xpath="//a[@href='/cases']")
	WebElement casesIcon;
	
	@FindBy(xpath="(//div[@class='menu-select ember-view simple'])[2]")
	WebElement accountsIcon;
	
	@FindBy(xpath="//a[text()='Account Settings']")
	WebElement accountsSettingsTab;
	
	
	
	//WebDriverWait wait;
	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public PeoplePage clickOnPeopleIcon() throws IOException {
		TestUtil.clickOn(driver, peopleIcon, 10);
		//peopleIcon.click();
		return new PeoplePage();
	}
	
	
	public CasePage clickOnCasesIcon() throws IOException {
		TestUtil.clickOn(driver, casesIcon, 10);
		//casesIcon.click();
		return new CasePage();
	}
	
	public AccountsPage clickOnAccountsIcon() throws IOException {
		TestUtil.clickOn(driver, accountsIcon, 10);
		TestUtil.clickOn(driver, accountsSettingsTab, 10);
		return new AccountsPage();
	}
	
	
}
