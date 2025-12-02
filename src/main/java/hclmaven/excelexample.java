package hclmaven;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
 
public class excelexample {
 
	WebDriver driver;
	WebDriverWait wait;
	String appURL="https://www.linkedin.com/";
	By bySignInLink=By.linkText("Sign in");
	By byEmail=By.name("session_key");
	By byPassword=By.name("session_password");
	By bySignIn=By.xpath("//button[@type='submit']");
	By byError=By.id("error-for-username");
	
	@BeforeClass
	public void testSetup() { 
		System.setProperty("webdriver.chrome.driver","C:/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	@DataProvider(name="inputData")
	public Object[][] getCellData() throws IOException{
		FileInputStream file=new FileInputStream("C:\\Users\\harshita.mandowara\\Downloads\\Book 7 (1).xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet s=wb.getSheet("Sheet1");
		int rowcount=s.getLastRowNum()+1;
		int cellcount=s.getRow(0).getLastCellNum();
		Object data[][]=new Object[rowcount][cellcount];
		for(int i=0;i<rowcount;i++) {
			Row r=s.getRow(i);
			for(int j=0;j<cellcount;j++) {
				Cell c=r.getCell(j);
				data[i][j]=c.getStringCellValue();
			}
		}
		wb.close();
		return data;
	}
	@Test(dataProvider="inputData")
	public void verifyInvalidLogin(String username,String password) {
		driver.get(appURL);
		driver.findElement(bySignInLink).click();
		driver.findElement(byEmail).sendKeys(username);
		driver.findElement(byPassword).sendKeys(password);
		driver.findElement(bySignIn).click();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byError));
		String expectedErrorMessage="Please enter a valid username.";
		String actualErrorMessage=driver.findElement(byError).getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		
		
	}
}