package hclmaven;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class happypath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		   driver.get("https://petstore.octoperf.com/");
	        driver.manage().window().maximize();
	        Thread.sleep(3000);
	        driver.findElement(By.linkText("Enter the Store")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.partialLinkText("Sign")).click();
	        Thread.sleep(3000);
	    	driver.findElement(By.name("username")).sendKeys("harshita");
	        driver.findElement(By.name("password")).clear();
	        Thread.sleep(3000);
	    	driver.findElement(By.name("password")).sendKeys("123");
	        Thread.sleep(3000);
	        driver.findElement(By.name("signon")).click();
	        Thread.sleep(5000);
	      
	        driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[1]/img")).click();
	        
	        driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a")).click();
	        
	        driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a")).click();
	        
	        

	}

}
