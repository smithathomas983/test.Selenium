package test.Selenium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import test.Selenium.BasePage.BasePage;

public class Google extends BasePage{

	
	public WebDriver driver;
	
	
public Google(WebDriver driver) {
		
		this.driver=driver  ;
		PageFactory.initElements(driver, this);
			}

public String getPageTiltle() {
	return driver.getTitle();
	
}

	
}
