package doc.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S14_Frames {
	//
	//
	@Test
	public void usingAWebelement() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/doc.selenium/web/click_frames.html");
		
		//Store the web element
		WebElement iframe = driver.findElement(By.id("source"));

		//Switch to the frame
		driver.switchTo().frame(iframe);

		//Now we can click the button
		driver.findElement(By.id("otherframe")).click();
		//
		driver.quit();
	}
	
	//
	@Test
	public void usingNameOrId() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/doc.selenium/web/click_frames.html");
		
		//Using the ID
		driver.switchTo().frame("target");

		//Or using the name instead
		driver.switchTo().frame("target");

		//Now we can click the button
		driver.findElement(By.tagName("button")).click();
		//
		driver.quit();
	}

	//
	@Test
	public void usingIndex() {
		
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/doc.selenium/web/click_frames.html");
		
		// Switches to the second frame
		driver.switchTo().frame(1);  
		driver.quit();
	}
	
	//
	@Test
	public void leavingFrame() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/doc.selenium/web/click_frames.html");
		
		// Switches to the second frame
		driver.switchTo().frame(1);  
		// Return to the top level
		driver.switchTo().defaultContent();
		//
		driver.quit();
		  
	}
}
