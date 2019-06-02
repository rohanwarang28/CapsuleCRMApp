package com.crm.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Base.TestBase;
import com.crm.pages.AccountsPage;
import com.crm.pages.AppearancePage;
import com.crm.pages.HomePage;
import com.crm.pages.IntegrationsPage;
import com.crm.pages.LoginPage;
import com.crm.pages.OpportunitiesPage;
import com.crm.pages.PeoplePage;
import com.crm.pages.TagsPage;
import com.crm.pages.TracksPage;
import com.crm.pages.UsersPage;

public class AccountsPageTest extends TestBase{

	
	LoginPage loginpage;
	HomePage homepage;
	//PeoplePage peoplepage;
	AccountsPage accountspage;
	AppearancePage appearancepage;
	UsersPage userspage;
	OpportunitiesPage opppage;
	TracksPage trackspage;
	TagsPage tagspage;
	IntegrationsPage integrationspage;
	SoftAssert asserts;
	public AccountsPageTest() throws IOException {
		super();
		
	}
	
	
	@BeforeMethod
	public void setup() throws IOException {
		
		initialization();
		loginpage=new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		//peoplepage = homepage.clickOnPeopleIcon();
		accountspage=homepage.clickOnAccountsIcon();
		
		
		
	}
	
	@Test
	public void accountsPageValidation() throws IOException {
		
	asserts=new SoftAssert();
	
	
	
	

	
	asserts.assertEquals(accountspage.validateAccountsPage("span","settings-content-menu-title","Account"), "Account Settings");
	asserts.assertEquals(accountspage.validateAccountsPage("h1","settings-page-header","Account"), "Account");
	asserts.assertEquals(accountspage.validateAccountsPage("header", "page-box-header", "Invoices"), "Invoices");
	asserts.assertEquals(accountspage.validateAccountsPage("h1","settings-page-header","Export"), "Export");
	asserts.assertEquals(accountspage.validateAccountsPage("h1","settings-page-header","Appearance"), "Appearance");
	asserts.assertEquals(accountspage.validateAccountsPage("h2","settings-page-header","Mail Drop Box"), "Mail Drop Box");
	asserts.assertEquals(accountspage.validateAccountsPage("h2","settings-page-header","Users"), "Users");
	asserts.assertEquals(accountspage.validateAccountsPage("header", "page-box-header", "Opportunities"), "Opportunities");
	asserts.assertEquals(accountspage.validateAccountsPage("h2","settings-page-header","Tracks"), "Tracks");
	asserts.assertEquals(accountspage.validateAccountsPage("h2","settings-page-header","Task Categories"), "Task Categories");
	asserts.assertEquals(accountspage.validateAccountsPage("h2","settings-page-header","Custom Fields"), "Custom Fields");
	asserts.assertEquals(accountspage.validateAccountsPage("h2","settings-page-header","Tags"), "Tags and DataTags");
	asserts.assertEquals(accountspage.validateAccountsPage("h2","settings-page-header","Integrations"), "Integrations");
	asserts.assertEquals(accountspage.validateAccountsPage("h2","settings-page-header","Trash"), "Trash");
	
	
	appearancepage = accountspage.navigateToAppearancePage();
	appearancepage.uploadFile();
	
	userspage = accountspage.navigateToUsersPage();
	asserts.assertEquals(userspage.addUser(), true);
	
	opppage = accountspage.navigateToOpportunitiesPage();
	asserts.assertEquals(opppage.addmile(), true);
	
	trackspage = accountspage.navigateToTracksPage();
	asserts.assertEquals(trackspage.addTracks(), true);
	
	tagspage = accountspage.navigateToTagsPage();
	asserts.assertEquals(tagspage.addTags(), true);
	
	integrationspage = accountspage.navigateToIntegrationsPage();
	asserts.assertEquals(integrationspage.verifyNoOfButtons(), 10);
	
	asserts.assertAll();
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
	}
	
}
