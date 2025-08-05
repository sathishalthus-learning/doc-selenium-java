package playground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators_ {

	public static void main(String[] args) {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		//
		driver.findElement(By.id(null));
		driver.findElement(By.name(null));
		driver.findElement(By.className(null));
		driver.findElement(By.cssSelector(null));
		driver.findElement(By.tagName(null));
		driver.findElement(By.linkText(null));
		driver.findElement(By.partialLinkText(null));
		
		
		
	}

}