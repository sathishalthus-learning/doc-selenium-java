package selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	//
	
	WebDriver driver = new ChromeDriver();
	
	//
	@Test
	public void usingAWebelement() {
		//Store the web element
		WebElement iframe = driver.findElement(By.cssSelector("#modal>iframe"));

		//Switch to the frame
		driver.switchTo().frame(iframe);

		//Now we can click the button
		driver.findElement(By.tagName("button")).click();
		  
	}
	
	//
	@Test
	public void usingNameOrId() {
		//Using the ID
		driver.switchTo().frame("buttonframe");

		//Or using the name instead
		driver.switchTo().frame("myframe");

		//Now we can click the button
		driver.findElement(By.tagName("button")).click();
	}

	//
	@Test
	public void usingIndex() {
		// Switches to the second frame
		driver.switchTo().frame(1);  
	}
	
	//
	@Test
	public void leavingFrame() {
		// Switches to the second frame
		driver.switchTo().frame(1);  
		// Return to the top level
		driver.switchTo().defaultContent();
		  
	}
}
