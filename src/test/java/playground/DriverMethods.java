package playground;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		// 
		driver.get(null);
		driver.getCurrentUrl();
		driver.getTitle();
		driver.getWindowHandle();
		driver.getWindowHandles();
		driver.findElement(null);
		driver.findElements(null);
		//
		driver.manage().window().getPosition();
		driver.manage().window().getSize();
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		// 
		driver.manage().timeouts().implicitlyWait(null);
		driver.manage().timeouts().pageLoadTimeout(null);
		//
		driver.close();
		driver.quit();
	}

}