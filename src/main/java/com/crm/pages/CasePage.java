package com.crm.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Base.TestBase;
import com.util.TestUtil;

public class CasePage extends TestBase{
	
	@FindBy(xpath="//a[text()='Add Case']")
	WebElement addCasesBtn;
	
	
	@FindBy(id="partySearch")
	WebElement relatesField;
	
	@FindBy(xpath="//script[@id='j_id111']")
	WebElement relation;
	
	@FindBy(id="caseNameDecorate:name")
	WebElement nameField;
	
	
	@FindBy(id="caseDescriptionDecorate:description")
	WebElement descField;
	
	@FindBy(id="tagsDecorate:tagComboBox")
	WebElement tagField;
	
	@FindBy(id="tagsDecorate:j_id191")
	WebElement addTagBtn;	
	
	@FindBy(id="save")
	WebElement saveBtn;
	
	
	
	
	public CasePage() throws IOException {
		//super();
		PageFactory.initElements(driver, this);
	}
	
	
public void addNewCase(String fname,String lname,String casename,String casedesc,String casetag) {
		
	TestUtil.clickOn(driver, addCasesBtn, 20);
	
	relatesField.sendKeys(fname+" "+lname);
	
	//adding thread.sleep as there is no way to use explicit wait in this case
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	relatesField.sendKeys(Keys.ARROW_DOWN);
	relatesField.sendKeys(Keys.ENTER);
	nameField.sendKeys(casename);
	descField.sendKeys(casedesc);
	tagField.sendKeys(casetag);
	
	addTagBtn.click();
	
	saveBtn.click();
	}

	
}

