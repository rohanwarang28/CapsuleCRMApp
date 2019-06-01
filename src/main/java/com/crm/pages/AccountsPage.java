package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Base.TestBase;
import com.util.TestUtil;

public class AccountsPage extends TestBase{

	@FindBy(linkText="Appearance")
	WebElement appearancelink;
	
	@FindBy(linkText="Users")
	WebElement userslink;
	
	@FindBy(linkText="Opportunities")
	WebElement opplink;
	
	public AccountsPage() throws IOException {
		//super();
		PageFactory.initElements(driver, this);
	}

	
	public String validateAccountsPage(String tag,String classname,String text) {
		
		driver.findElement(By.linkText(text)).click();
		return TestUtil.getTitle(tag, classname);
		
	}
	
	public AppearancePage navigateToAppearancePage() throws IOException {
		
		 appearancelink.click();
		 return new AppearancePage();
	}
	
	public UsersPage navigateToUsersPage() throws IOException {
		
		userslink.click();
		 return new UsersPage();
	}
	
	
	public OpportunitiesPage navigateToOpportunitiesPage() throws IOException {
		
		opplink.click();
		return new OpportunitiesPage();
	}
}
