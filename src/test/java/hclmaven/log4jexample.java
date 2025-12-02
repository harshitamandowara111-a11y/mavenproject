package hclmaven;

import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class log4jexample {
	Logger log = Logger.getLogger(log4jexample.class);
	 
	@Test
	public void login() {
		log.info("Opening browser...");
		WebDriver driver = new ChromeDriver();
 
		log.info("Navigating to Google");
		driver.get("https://www.google.com");
 
		log.info("Entering data in search");
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("selenium");
 
		log.info("Login test completed");
		//driver.quit();
	}
}

