package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
 }
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement email;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement button;
	
	
	
	
	public WebElement email() {
		return email;
	}
	public WebElement password() {
		return password;
	}
	public WebElement button() {
		return button;
	}
	
	
}
