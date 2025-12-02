package hclmaven;

import java.util.*;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumpract2 {
	public static Map<String,Integer> searchprod(WebDriver driver, String searchurl,String ProdName) throws InterruptedException{
		Map<String,Integer>mp=new HashMap<>();
		driver.get(searchurl);
		
		driver.findElement(By.name("productName")).sendKeys(ProdName);
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/div/form/button")).click();
		Thread.sleep(4000);
		List<WebElement>row=driver.findElements(By.tagName("tr"));
		for(int i=0;i<row.size();i++) {
			List<WebElement>cell=row.get(i).findElements(By.tagName("td"));
			if(cell.size()<3) {
				continue;
			}
			String vendor=cell.get(1).getText().toString();
			int price=Integer.parseInt(cell.get(2).getText());
			mp.put(vendor,price);
			
		}
		
		return mp;
		
	}
	public static String minProd(WebDriver driver,String searchurl,String Prodname) {
		String mini="";
		int p=Integer.MAX_VALUE;
     
		
		List<WebElement>row=driver.findElements(By.tagName("tr"));
		for(int i=0;i<row.size();i++) {
			List<WebElement>cell=row.get(i).findElements(By.tagName("td"));
			if(cell.size()<3) {
				continue;
			}
			int price=Integer.parseInt(cell.get(2).getText());
			if(price<p) {
				p=price;
				mini=cell.get(1).getText().toString();
				
			}
			
		}
		
		
		return mini;
	}

	public static void main(String args[]) throws InterruptedException {
	     String url="C:\\Users\\harshita.mandowara\\Downloads\\Selenium-practice-html-code 1 1\\Selenium-practice-html-code 1\\product-search\\searchPage.html";
	     String prodname="Laptop";
	     WebDriver driver=new ChromeDriver();
	     Map<String,Integer>ans=searchprod(driver,url,prodname);
	    
	     for(String i:ans.keySet())
	     System.out.println(i+"->"+ans.get(i));
	     System.out.println(minProd(driver,url,prodname));
	}
	}


