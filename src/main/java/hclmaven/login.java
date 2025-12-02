package hclmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {
	WebDriver driver;
	By user=By.name("username");
	By password=By.name("password");
	By login=By.name("signon");
	By message=By.xpath("//p[contains(text(),'Please enter')]");
	
	public login(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setUserName(String struser) {
		driver.findElement(user).sendKeys(struser);
	}
	public void setPassword(String strpass) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(strpass);
		
	}
	public void clickLogin() {
		driver.findElement(login).click();
	}
	public String getLoginText() {
		return driver.findElement(message).getText();
	}
	
	public void loginApp(String struser,String strpass) {
		this.setUserName(struser);
		this.setPassword(strpass);
		this.clickLogin();
	}
	
}
