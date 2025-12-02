package hclmaven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class reportclient {

	
		// TODO Auto-generated method stub
		WebDriver driver;
		String expectedtitle="Electronics, Cars, Fashion, Collectibles & More | eBay";
			
        String expectedtitledaraz="Online Shopping Sri Lanka: Clothes, Electronics & Phones - Daraz.lk";
        
        ExtentSparkReporter htmlReporter;
        ExtentReports extent;
        ExtentTest test1;
        ExtentTest test2;
        
       @BeforeSuite
    	public void setup() {
    	   htmlReporter = new ExtentSparkReporter("target/extentReporti.html");
    		extent = new ExtentReports();
    		extent.attachReporter(htmlReporter);
    		
    		WebDriverManager.chromedriver().setup();
    		
    		driver = new ChromeDriver();
     
    	}
    	
    	@Test(priority=1)
    	public void test1() throws InterruptedException {
    		test1 = extent.createTest("ebay Search Test", "test to validate search box");
    		test1.log(Status.INFO, "Starting test case");
    		
    		driver.manage().window().maximize();
    		test1.pass("maximize has done");
    		
    		driver.get("https://www.ebay.com");
    		Thread.sleep(1000);
    		
    		test1.pass("Navigate to Ebay.com");
    		
    		String actualTitle = driver.getTitle();
    		Assert.assertEquals(actualTitle, expectedtitledaraz);
    		test1.pass("title is correct");
    		
    		driver.findElement(By.id("gh-ac")).sendKeys("Mobile");
    		test1.pass("enter text in the text box");
    		
    		driver.findElement(By.id("gh-ac")).sendKeys(Keys.RETURN);
    		test1.pass("Press keyboard enter key");
    	}
    	
    	@Test(priority=0)
    	public void test2() throws InterruptedException {
    		test2 = extent.createTest("Daraz Search Test", "test to validate search box");
    		test2.log(Status.INFO, "Starting test case");
    		
    		driver.manage().window().maximize();
    		test2.pass("maximize has done");
    		
    		driver.get("https://www.daraz.lk/#");
    		Thread.sleep(1000);
    		test2.pass("Navigate to Daraz.lk");
    		
    		String actualTitle=driver.getTitle();
    		
    		Assert.assertEquals(actualTitle, expectedtitledaraz);
    		test2.pass("title is correct");
    		
    		driver.findElement(By.id("q")).sendKeys("Mobile");
    		test2.pass("enter text in the text box");
    		
    		driver.findElement(By.xpath("//input[@id='q']")).sendKeys(Keys.RETURN);
    		test2.pass("Press keyboard enter key");
    	}
    	
    	@AfterSuite
    	public void tearDown() {
    		driver.quit();
    		test1.pass("closed the browser");
    		test2.pass("closed the browser");
    		test1.info("test completed");
    		test2.info("test completed");
    		extent.flush();
    	}
     
    }
