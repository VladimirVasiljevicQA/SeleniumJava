package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base  {
	public WebDriver driver;
	 Logger log;
	@BeforeMethod
	public void openBrowser() throws IOException {
		
	    log = LogManager.getLogger(LoginTest.class.getName());
		driver= initializeBrowser();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Go to url");
		
	}
	
	@Test(dataProvider="loginData")
	public void login(String email,String password, String result) throws IOException, InterruptedException {
	    
		
		LandingPage landingPage = new LandingPage (driver);
		landingPage.MyAccountDropDown().click();
		log.debug("Click on Myaccount dropdown");

		landingPage.LoginPress().click();
		log.debug("Click on login");

		LoginPage loginpage=new LoginPage(driver);
		loginpage.email().sendKeys(email);
		log.debug("enter email address");

		loginpage.password().sendKeys(password);
		log.debug("Enter password");

		loginpage.button().click();
		log.debug("Click on login button");

		AccountPage accpage=new AccountPage(driver);
		
        
		String acutualResult = null;
		if(accpage.account().isDisplayed()) {
			   acutualResult = "pass";
			   log.debug("We are logged in app");
			   }
		else {
			log.debug("We are not logged in app");
			Assert.fail();
		}
		Assert.assertEquals(result,acutualResult);
		
		if(acutualResult.equalsIgnoreCase(result)) {
			log.info("Test pass");
		}
		else {
			log.error("Test fail");
		}
			
	}
	
	@AfterMethod
    public void teardown() {
		driver.close();
		log.debug("Browser is closed");
	}
	@DataProvider
	public Object[][] loginData() {
		Object [][] data= {{"vladimirvasiljevicbp@hotmail.com","1234","pass"}}; 
		return data;
	}
	
}
