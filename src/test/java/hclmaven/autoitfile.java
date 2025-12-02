package hclmaven;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class autoitfile {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.demo.guru99.com/test/upload/");
        Thread.sleep(9000);
        driver.findElement(By.id("file_wraper0")).click();
        Runtime.getRuntime().exec("C:\\Users\\harshita.mandowara\\OneDrive - HCL TECHNOLOGIES LIMITED\\Documents\\tryauto3.exe");
        Thread.sleep(9000);
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("submitbutton")).click();
        
	}

}
