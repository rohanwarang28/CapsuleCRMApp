package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(id="login:usernameDecorate:username")
	WebElement usernameField;
	
	
	@FindBy(id="login:passwordDecorate:password")
	WebElement passwordField;
	
	
	@FindBy(id="login:login")
	WebElement loginBtn;
	
	public LoginPage() throws IOException{
		//super();
		PageFactory.initElements(driver, this);
	}
	
	
	public HomePage login(String uname,String pwd) throws IOException {
		
		usernameField.sendKeys(uname);
		passwordField.sendKeys(pwd);
		
		loginBtn.click();
		return new HomePage();
	}
	
	
	
	
	

	
	
}
