package hclmaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPom {
	WebDriver driver;
	login objlogin;
	Home objHome;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://petstore.octoperf.com/actions/Account.action;jsessionid=E61287F8F2D102AD183D926E5C643594?signonForm=");
	}
	@Test
	public void test_HomePage() {
		objlogin=new login(driver);
		String loginmessage=objlogin.getLoginText();
		System.out.println(loginmessage);
		Assert.assertTrue(loginmessage.contains("Please enter"));
		objlogin.loginApp("j2ee", "j2ee");
		objHome=new Home(driver);
		Assert.assertTrue(objHome.getHomeDash().contains("ABC"));
	}

}
