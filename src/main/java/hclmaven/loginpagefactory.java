package hclmaven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class loginpagefactory {
	
	
	WebDriver driver;
	@FindBy(name="username")
	WebElement userName;
	
	
	@FindBy(xpath="//*[@id=\"Catalog\"]/form/p[1]")
	WebElement MessageText;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="signon")
	WebElement login;
	
	public loginpagefactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void setUserName(String username) {
		userName.sendKeys(username);
	}
	
	public void setPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}
	
	
	public void clickLogin() {
		login.click();
	}
	
	public String getLoginText() {
		return MessageText.getText();
	}
	
	
	public void LoginToApplication(String username,String pass) {
		this.setUserName(username);
		this.setPassword(pass);
		this.clickLogin();
		
	}
	
	
	
	
}
 