package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class TestCaseOne extends TestBase {
	LoginPage lp;
	HomePage hp;
	
	public TestCaseOne()throws IOException{
		super();
	}
  
  @BeforeTest
  public void beforeMethod() {
	  TestBase.systemProperty();
	  lp = new LoginPage(dr);
	  hp = new HomePage(dr);
}

  @AfterTest
  public void afterMethod() {
     dr.quit();
  }

  @Test (priority=1)
  public void verifyTitleTest() {
      String homeTitle = hp.verifyHomepageTitle();
      Assert.assertEquals("The World's Most Trusted Virtual Data Room | Firmex", homeTitle);
  }
  
  @Test (priority=2)
  public void verifyLoginPageTest() {
      hp.clickOnLoginButton();
      String loginTitle = lp.verifyLoginpage();
      System.out.println(loginTitle);
      Assert.assertEquals("Firmex Virtual Data Room Login", loginTitle);
  }
  
  @Test (priority=3)
  public void verifyErrorMessage() {
	  String errorMessage = lp.loginUnsuccessful();
	  
	  //6) Verify the error message
      Assert.assertEquals("User credentials are invalid. Click here to reset your password", errorMessage);
  }
}
