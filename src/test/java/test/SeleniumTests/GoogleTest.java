package test.SeleniumTests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.Selenium.BasePage.BasePage;
import test.Selenium.Pages.Google;

public class GoogleTest {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public Google google;
	
	@BeforeMethod()
	public void setUp() {
		
		
		basePage=new BasePage();
		prop=basePage.init_Properties();
		String browser= prop.getProperty("browser");
		driver=basePage.init_Browser(browser);		
		driver.get(prop.getProperty("url"));
		google= new Google(driver);
		 
		
		
	}
	@ Test
	public void googlePageTitle_Test() {
		String title=google.getPageTiltle();
		System.out.println("Title of the page is: "+title);
		Assert.assertEquals(title,"Google");
		}
	@AfterMethod
	public void tearDown() {
		driver.close();
		
	}
}
