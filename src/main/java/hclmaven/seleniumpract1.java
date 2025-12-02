package hclmaven;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumpract1 {
	public static List<String>scrapevul(WebDriver driver, String vulnPageurl,String wpversion)
	{
		List<String>cvid=new ArrayList<>();
		driver.get(vulnPageurl);
		List<WebElement>row=driver.findElements(By.tagName("tr"));
		for(int i=0;i<row.size();i++) { 
			List<WebElement>cell=row.get(i).findElements(By.tagName("td"));

			  
		    if (cell.size() < 5) {
		        continue;
		    }

			String version=cell.get(4).getText();
			if(version.equals(wpversion)) {
				cvid.add(cell.get(0).getText());
			}
			
		}
		return cvid;
		
		
	}
	public static String topvul(WebDriver driver,String vulnpageurl,String wpversion) {
		String cveid="";
		driver.get(vulnpageurl);
		List<WebElement>row=driver.findElements(By.tagName("tr"));
		double highest=0.0;
		for(int i=0;i<row.size();i++) {
			List<WebElement>cell=row.get(i).findElements(By.tagName("td"));

			  if (cell.size() < 5) {
			        continue;
			    }

			String version=cell.get(4).getText();
			
			if(version.equals(wpversion)) {
				String s=cell.get(3).getText();
				double score=Double.parseDouble(s);
				if(score>highest) {
					highest=score;
					cveid=cell.get(0).getText();
				}
			}
		}
		return cveid;
	}
	public static void main(String args[]) {
		WebDriver d=new ChromeDriver();
		String vulurl="C:\\Users\\harshita.mandowara\\Downloads\\Selenium-practice-html-code 1 1\\Selenium-practice-html-code 1\\Vuln-practice\\vuln-page.html";
		System.out.println(scrapevul(d,vulurl,"4.3"));
		System.out.println(topvul(d,vulurl,"4.3"));
		
	}

}
