package doc.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class S07_Locators {
	//
	@Test
	public void traditionalLocators() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		
		driver.findElement(By.className("form-control-color"));
		driver.findElement(By.cssSelector("#my-text-id"));
		driver.findElement(By.id("my-text-id"));
		driver.findElement(By.name("my-text"));
		driver.findElement(By.linkText("Return to index"));
		driver.findElement(By.partialLinkText("Return"));
		driver.findElement(By.tagName("a"));
		driver.findElement(By.xpath("//input[@type='color']"));
		
		driver.quit();
	}

	//
	@Test
	public void relativeLocators() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/doc.selenium/web/web-form.html");
		//
		WebElement textInputField = driver.findElement(RelativeLocator.with(By.name("my-text")).above(By.name("my-password")));
		textInputField.sendKeys("hello");
		driver.quit();
	}
	
	//
	@Test
	public void chainingLocators() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/doc.selenium/web/web-form.html");
		//
		WebElement textInputField = driver.findElement(
				RelativeLocator.with(By.name("my-text"))
				.above(By.name("my-password"))
				.near(By.name("my-textarea")));
		textInputField.sendKeys("hello");
		
		driver.quit();
	}
}
