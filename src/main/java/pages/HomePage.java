package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import config.TestBase;

public class HomePage extends TestBase{
	WebDriverWait wait;
	WebDriver dr;
	
	@FindBy(xpath="//a[@class='button login']")
	WebElement loginButton;
	
	//initialization of page objects
	public HomePage(WebDriver dr){
		this.dr=dr;
		PageFactory.initElements(dr,this);
	}
	
	//2) Verify the page title
	public String verifyHomepageTitle(){
		wait = new WebDriverWait(dr, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='custom-logo']")));
	return dr.getTitle();	
	}
	
	//3) Click on Login button
	public void clickOnLoginButton(){
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
}
