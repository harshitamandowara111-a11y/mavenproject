package hclmaven;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public  class validandinvalidlinks {
	public static List<String> findlinks(WebDriver driver,String mainurl){
		driver.get(mainurl);
		List<WebElement>ans=driver.findElements(By.tagName("a"));
		List<String> links=new ArrayList<>();
		for(int i=0;i<ans.size();i++) {
			
	     
	      String link= ans.get(i).getAttribute("href");
	     
	         links.add(link);
	   
			
		}
		
		
		return links;
	}
	public static List<String> findvalidlinks(WebDriver driver,String mainurl){
	     driver.get(mainurl);
	     String curr=driver.getTitle();
	     List<String> links=new ArrayList<>();
		List<String>ans=findlinks(driver,mainurl);
		for(String i:ans) {
			driver.get(i);
			String subcurr=driver.getTitle();
			if(curr.equals(subcurr)) {
				links.add(i);
			}
		}
		
		
		return links;
	}
	public static List<String> findInvalidlinks(WebDriver driver,String mainurl){
	     driver.get(mainurl);
	     String curr=driver.getTitle();
	     List<String> links=new ArrayList<>();
		List<String>ans=findlinks(driver,mainurl);
		for(String i:ans) {
			driver.get(i);
			String subcurr=driver.getTitle();
			if(!curr.equals(subcurr)) {
				links.add(i);
			}
		}
		
		
		return links;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            String link="C:\\Users\\harshita.mandowara\\Downloads\\Selenium-practice-html-code 1 1\\Selenium-practice-html-code 1\\dashboard-links\\index.html";
            WebDriver d=new ChromeDriver();
            List<String> ans=findlinks(d,link);
            
            	System.out.println(ans);
            	List<String>ans1=findvalidlinks(d, link);
            	System.out.println("valid links: "+ans1 );
            	
            	List<String>ans2=findInvalidlinks(d, link);
            	System.out.println("Invalid links: "+ans2 );
            	
            	
            
	}

}
