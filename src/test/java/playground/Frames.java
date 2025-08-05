package playground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {
		// 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		//
		driver.switchTo().frame(0);
		driver.findElement(By.tagName("button")).click();
		
		// 
//		driver.findElement(null)
	
		//
		driver.close();
		driver.quit();

	}

}
