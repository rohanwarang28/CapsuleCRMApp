package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.Base.TestBase;

public class TestUtil extends TestBase{


	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}



	public static int PAGE_LOAD_TIMEOUT = 40;
	public static String testDatasheetPath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\crm\\TestData\\PeopleData.xlsx";
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;


	public static Object[][] getTestData(String sheetname) throws InvalidFormatException, IOException {

		FileInputStream file = null;
		file = new FileInputStream(testDatasheetPath);
		book = WorkbookFactory.create(file);
		sheet = book.getSheet(sheetname);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for(int i = 0 ; i < sheet.getLastRowNum() ; i++) {

			for(int j = 0 ; j < sheet.getRow(i).getLastCellNum() ; j++ ) {

				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}

		}

		return data;

	}


	public static void clickOn(WebDriver driver,WebElement elem,int timeout) {

		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(elem));
		elem.click();

	}

	public static void selectIt(WebDriver driver,WebElement elem,String val) {


		Select select = new Select(elem);
		select.selectByValue(val);

	}


	public static void waitUntilVisible(WebDriver driver,String locator,int timeout) {


		wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

	}


	public static String getTitle(String tagname,String classname) {



		String xpath="//"+tagname+"[@class='"+classname+"']";
		waitUntilVisible(driver, xpath, 3);
		return driver.findElement(By.xpath(xpath)).getText();
	}

	public static void switchWindows() {

		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
		}

		driver.switchTo().window(subWindowHandler); // switch to popup window

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


	}

	public static void enterText(WebElement elem,String text) {

		js = (JavascriptExecutor)driver;

		js.executeScript("arguments[0].value='"+text+"';",elem);
		//js.executeScript(arg0, arg1)
	}

	public static void addName() {

		driver.findElement(By.xpath("//label[contains(text(),'Name')]/following-sibling::span/child::input")).sendKeys("John");
	}
	
	public static void clickSave() {
		
		driver.findElement(By.xpath("//a[text()='Save']")).click();;
	}
	
	public static void jsClick(WebElement elem) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", elem);
	}

}
