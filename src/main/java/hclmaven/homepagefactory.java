package hclmaven;



	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	public class homepagefactory {
		WebDriver driver;
		By homeuser=By.xpath("//div[@id='WelcomeContent']");
		
		public homepagefactory(WebDriver driver) {
			this.driver=driver;
		}
		public String getHomeDash() {
			return driver.findElement(homeuser).getText();
		}

	}



