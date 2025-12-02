package hclmaven;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumpract6 {
	public static List<String> findAmount(WebDriver driver, String url) throws InterruptedException
	 {
		 List<String>ans=new ArrayList<>();
		 driver.get(url);
		
		 List<WebElement>row=driver.findElements(By.tagName("tr"));
		 for(int i=1;i<row.size();i++) {
			 List<WebElement>rows=driver.findElements(By.tagName("tr"));
			 List<WebElement>cell=rows.get(i).findElements(By.tagName("td"));
			
			 int Curr=Integer.parseInt(cell.get(3).getText());
			 String pname=cell.get(1).getText();
			 
			 
			 cell.get(3).findElement(By.tagName("a")).click();
			  
		       WebElement spanElement=driver.findElement(By.id("sum"));        
		       int claimp = Integer.parseInt(spanElement.getText());
		      
		      
			 if(claimp!=Curr) {
				 ans.add(pname); 
			 }
			 driver.findElement(By.tagName("a")).click();
			
			
			 
		 }
		 return ans; 
	 }
	public static void main(String Args[]) throws InterruptedException {
		String url="C:\\Users\\harshita.mandowara\\Downloads\\Selenium-practice-html-code 1 1\\Selenium-practice-html-code 1\\Healthcare\\patientsPage.html";
		WebDriver driver=new ChromeDriver();
		List<String>ans=findAmount(driver,url);

			System.out.println(ans);
		
		
	}

}
