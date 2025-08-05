package playground;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {

	public static void main(String[] args) {
		// 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		//
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
		//
		driver.close();
		driver.quit();
	}

}
