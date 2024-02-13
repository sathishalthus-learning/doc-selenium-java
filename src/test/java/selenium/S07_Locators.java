package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class S07_Locators {
	//
	@Test
	public void traditionalLocators() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/workspaces/selenium/Locators.html");
		
		driver.findElement(By.className("information"));
		driver.findElement(By.cssSelector("#fname"));
		driver.findElement(By.id("lname"));
		driver.findElement(By.name("newsletter"));
		driver.findElement(By.linkText("Selenium Official Page"));
		driver.findElement(By.partialLinkText("Official Page"));
		driver.findElement(By.tagName("a"));
		driver.findElement(By.xpath("//input[@value='f']"));
	}

	public void relativeLocators() {
		//
		
	}
	
	public void chainingLocators() {
		//
		
	}
}
