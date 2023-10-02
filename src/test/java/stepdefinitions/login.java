package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Base;

public class login extends Base {
	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginpage;
	AccountPage accpage;
	
    @Given("^Open any Browser$")
	public void Open_any_Browser() throws IOException {
    	driver= initializeBrowser();
}
    @And ("^Navigate to Login page$")
    public void navigate_to_login_page() {
    	driver.get(prop.getProperty("url"));
        landingPage = new LandingPage (driver);
		landingPage.MyAccountDropDown().click();
		landingPage.LoginPress().click();
	
}
    @When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
    public void user_enters_username_as_and_password_as_into_the_fields(String email, String password) {
        loginpage=new LoginPage(driver);
		loginpage.email().sendKeys(email);
		loginpage.password().sendKeys(password);
	
}   @And("^User clicks on Login button$")
    public void user_clicks_on_login_button() {
	    loginpage.button().click();   
}
    @Then("^Verify user is able to successfully login$")
    public void verify_user_is_able_to_successfully_login() {
    	accpage=new AccountPage(driver);
    	Assert.assertTrue(accpage.account().isDisplayed());
 	
}
    @After
    public void closedBrowser() {
    	driver.close();
    }
}
