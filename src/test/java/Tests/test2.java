package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class test2 extends Base{
	public WebDriver driver;
	Logger log;
@Test
	public void testTwo () throws IOException {
	    log = LogManager.getLogger(LoginTest.class.getName());
		System.out.println("drugi test");
		log.info("Test Two pass");
		driver= initializeBrowser();
		system.out.println("This test fail");
		driver.get("https://maven.apache.org/plugins/maven-resources-plugin/examples/filter.html");
		Assert.assertFalse(true);
		
		
	}
@AfterMethod
public void close() {
	driver.close();
}

}
