package hclmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
	WebDriver driver;
	By homeuser=By.xpath("//div[@id='WelcomeContent']");
	//*[@id="app"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div
	public Home(WebDriver driver) {
		this.driver=driver;
	}
	public String getHomeDash() {
		return driver.findElement(homeuser).getText();
	}

}
