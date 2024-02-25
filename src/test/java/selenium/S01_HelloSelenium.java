package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S01_HelloSelenium {
	//
	public static void main(String[] args) {
		//
		WebDriver driver = new ChromeDriver();

		driver.get("https://selenium.dev");
		System.out.println(driver.getTitle());

		driver.quit();
	}
}
