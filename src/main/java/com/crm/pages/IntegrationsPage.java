package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.crm.Base.TestBase;

public class IntegrationsPage extends TestBase{

	public IntegrationsPage() throws IOException {
		
		// TODO Auto-generated constructor stub
	}
	
	public int verifyNoOfButtons() {
		
		return driver.findElements(By.xpath("//a[text()='Configure']")).size();
		
		
		
		
	}

}
