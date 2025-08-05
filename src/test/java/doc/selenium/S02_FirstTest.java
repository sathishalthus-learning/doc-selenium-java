package doc.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

public class S02_FirstTest {
	//
	@Test
	public void eightComponents() {
		
		//1. Starting the Session
		WebDriver driver = new ChromeDriver();
		
		//2. Take action on browser
		driver.get("https://www.selenium.dev/doc.selenium/web/web-form.html");

		//3. Request browser information
		String title = driver.getTitle();
		System.out.println(title);

		//4. Establish Waiting Strategy
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		//5. Find an element
		WebElement textBox = driver.findElement(By.name("my-text"));
		WebElement submitButton = driver.findElement(By.cssSelector("button"));

		//6. Take action on element
		textBox.sendKeys("Selenium");
		submitButton.click();
		
		//7. Request element information 
		String title1 = driver.getTitle();
		System.out.println(title1);
		assertEquals("Web form - target page", title1);

		//8. End the session
		driver.quit();
	}

}
