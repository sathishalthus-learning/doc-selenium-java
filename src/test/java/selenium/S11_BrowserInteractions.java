package selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S11_BrowserInteractions {
	//
	
	WebDriver driver = new ChromeDriver();
	
	//
	@Test
	public void getBrowserInformation() {
		driver.getTitle();
		driver.getCurrentUrl();
	}

	//
	@Test
	public void browserNavigations() {
		//Convenient
		driver.get("https://selenium.dev");

		//Longer way
		driver.navigate().to("https://selenium.dev");
		  
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}
}
