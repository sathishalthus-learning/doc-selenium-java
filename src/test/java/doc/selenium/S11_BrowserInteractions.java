package doc.selenium;

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
		driver.get("https://doc.selenium.dev");
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
		driver.get("https://doc.selenium.dev");

		//Longer way
		driver.navigate().to("https://doc.selenium.dev");
		  
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		//
		driver.quit();
	}
}
