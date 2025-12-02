package hclmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumpract5 {
	public static String solve(WebDriver driver,String url) {
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.tagName("button")).click();
		
		String ans=driver.findElement(By.tagName("p")).getText();
		return ans;
		
	}
	public static void main(String args[]) {
		WebDriver driver=new ChromeDriver();
		String url="file:///C:/Users/harshita.mandowara/Downloads/Selenium-practice-html-code%201%201/Selenium-practice-html-code%201/Login/login.html";
		String ans=solve(driver,url);
		System.out.println(ans);
		
	}

}
