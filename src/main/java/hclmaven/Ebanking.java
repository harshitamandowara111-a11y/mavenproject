package hclmaven;

	
	import org.openqa.selenium.*;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	 
	

public class Ebanking {
	 
	public static class LoanDetails {
		String name;
	    String surname;
	    String email;
	    String loanType;
	    String loanDuration;
	    public LoanDetails(String name, String surname, String email, String loanType, String loanDuration) {
			super();
			this.name = name;
			this.surname = surname;
			this.email = email;
			this.loanType = loanType;
			this.loanDuration = loanDuration;
		}
		
	}
	 
		    public static String applyLoan(WebDriver driver, String loanPageUrl, LoanDetails loanDetails) {
		        driver.get(loanPageUrl);
		        String ans="";
		        
		        
		        driver.findElement(By.id("firstName")).sendKeys(loanDetails.name);
		        driver.findElement(By.id("lastName")).sendKeys(loanDetails.surname);
		        driver.findElement(By.id("email")).sendKeys(loanDetails.email);
		        
		        Select dropdown1=new Select(driver.findElement(By.id("loanType")));
		        dropdown1.selectByVisibleText(loanDetails.loanType);
		        
		        
		        Select dropdown2=new Select(driver.findElement(By.id("loanDuration")));
		        dropdown2.selectByVisibleText(loanDetails.loanDuration);
		        
		        driver.findElement(By.id("submitBtn")).click();
		      ans=driver.findElement(By.id("secretCode")).getText();
		        
		        
		        return ans;
		         
		    }
	 
		 
		    public static void main(String[] args) {
		        WebDriver driver = new ChromeDriver();
	 
		       
		        LoanDetails loanDetail = new LoanDetails("John", "Doe", "john.doe@example.com", "Personal","2 Years");
	 
		        String url = "C:\\Users\\harshita.mandowara\\Downloads\\Selenium-practice-html-code 1 1\\Selenium-practice-html-code 1\\LoanDetails-practice\\loanPage.html"; // Replace with actual loan page URL
		        String secretCode = applyLoan(driver, url, loanDetail);
		        System.out.println("Secret Code after loan application: " + secretCode);
	 
		   
		    }
		
	}
	 
	 


