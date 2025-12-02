package hclmaven;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

public class seleniumpract7 {
	public static int locatenontext(WebDriver driver, String url) {
		driver.get(url);

		// List<WebElement>temp=driver.findElements(By.xpath("//input[not(@type='text')]"));
		return driver.findElements(By.xpath("//input[not(@type='text')]")).size();

	}

	public static int startswithcontact(WebDriver driver, String url) {

		List<WebElement> temp = driver.findElements(By.xpath("//input[starts-with(@name,'contact')]"));
		return temp.size();

	}

	public static int locateSubmitElement(WebDriver driver, String url) {

		List<WebElement> temp = driver.findElements(By.xpath("//button[@type='submit']"));
		return temp.size();

	}

	public static int locateIdMissingElements(WebDriver driver, String url) {
		List<WebElement> temp = driver.findElements(By.xpath("//form//input[not(@id)]"));
		return temp.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		String url = "C:\\Users\\harshita.mandowara\\Downloads\\Selenium-practice-html-code 1 1\\Selenium-practice-html-code 1\\ContactUs-Form\\contact.html";
		System.out.println(locatenontext(driver, url));
		System.out.println(startswithcontact(driver, url));
		System.out.println(locateSubmitElement(driver, url));
		System.out.println(locateIdMissingElements(driver, url));

	}

}
