package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.TestBase;
import constants.PropertyConstants;

public class LoginPage extends TestBase{
	WebDriverWait wait;
	WebDriver dr;

	@FindBy(xpath="//input[@id='login_user']")
	WebElement emailAddress;
	
	@FindBy(xpath="	//input[@id='login_pw']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='login_btn']")
	WebElement submitBtn;
	
	@FindBy(xpath="//div[@class='form-message m15t ']//child::p ")
	WebElement errorMessage;
	 

	public LoginPage(WebDriver dr){
		this.dr=dr;
		PageFactory.initElements(dr,this);
	}
	
	//4) Verify you are on login page
	public String verifyLoginpage(){
		wait = new WebDriverWait(dr, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='login_user']")));
	    return dr.getTitle();	
	}

	//5) Try to login with invalid credentials
	public String loginUnsuccessful(){
		emailAddress.sendKeys(PropertyConstants.emailAddress);
		password.sendKeys(PropertyConstants.password);
		submitBtn.click();
		return errorMessage.getText();
}
		}	
