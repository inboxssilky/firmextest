package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import constants.PropertyConstants;

public class TestBase {
	//Initialization
		public static WebDriver dr;
		public static void systemProperty(){
		String	key = "webdriver.chrome.driver";
		String value = "C:\\Users\\sharm\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";
		System.setProperty(key, value);
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.manage().deleteAllCookies();
		//1) Go to Firmex.com 
		dr.get(PropertyConstants.url); 

		}
	}