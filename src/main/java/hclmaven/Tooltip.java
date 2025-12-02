package hclmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tooltip {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		WebElement googleicon=driver.findElement(By.cssSelector("a[aria-label='Google apps']"));
		googleicon.getAttribute("aria-label");
		System.out.println(googleicon);
		// TODO Auto-generated method stub

	}

}
