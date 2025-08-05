package playground;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Javascripts {

	public static void main(String[] args) {
		// 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/javascriptEnhancedForm.html");
		//
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement password = driver.findElement(By.id("password"));
		jse.executeScript("arguement[0].fill()", password);
		
		// 
		driver.quit();
	}

}
