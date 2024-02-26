package selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S11_BrowserInteractions {
	//
	

	
	//
	@Test
	public void getBrowserInformation() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.dev");
		//
		String title = driver.getTitle();
		System.out.println(title);
		//
		String url = driver.getCurrentUrl();
		System.out.println(url);
		//
		driver.quit();
	}

	//
	@Test
	public void browserNavigations() {
		//Convenient
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.dev");

		//Longer way
		driver.navigate().to("https://selenium.dev");
		  
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		//
		driver.quit();
	}
}
