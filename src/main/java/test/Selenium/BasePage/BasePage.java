package test.Selenium.BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage {

	public WebDriver driver;
	public Properties prop;


	public WebDriver init_Browser(String browserName) {
		if (browserName.equals("chrome")) {
			System.setProperty("webDriver.Chrome.driver", System.getProperty("user.dir")+"/scr/main/resources/drivers/chromedriver");
			if (prop.getProperty("headless").equals("yes")) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				//String[] s=new String["--headless"];
				//co.setBinary();
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}

		}driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageloadtimeout")), TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		return driver;
		
	}
	

	public Properties init_Properties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\test\\Selenium\\Config\\config.properties");
				
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}}

