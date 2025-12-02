package hclmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdownandcheckbox {
	
	 
	static void  fillDateOfBirth(WebDriver driver, String pageUrl){
		driver.get(pageUrl);
		Select dropdownM=new Select(driver.findElement(By.id("month")));
		dropdownM.selectByIndex(4);
		
		Select dropdownD=new Select(driver.findElement(By.id("day")));
		dropdownD.selectByIndex(19);
		
		Select dropdownY=new Select(driver.findElement(By.id("year")));
		dropdownY.selectByIndex(23);
		
		
	}
	
	static void answerQuestions(WebDriver driver, String pageUrl) {
		driver.findElement(By.xpath("//input[@value='Java']")).click();
		driver.findElement(By.xpath("/html/body/div/form/div[2]/input[2]")).click();
		driver.findElement(By.xpath("/html/body/div/form/div[3]/input[2]")).click();
		driver.findElement(By.className("submit-btn")).click();
		
		
		
		
		
	}
	public static void main(String args[]) {
		WebDriver d=new ChromeDriver();
		String url="C:\\Users\\harshita.mandowara\\Downloads\\Selenium-practice-html-code 1 1\\Selenium-practice-html-code 1\\Dropdown\\form.html";
		fillDateOfBirth(d,url);
		answerQuestions(d,url);
		System.out.println("done");
		
	}

}
