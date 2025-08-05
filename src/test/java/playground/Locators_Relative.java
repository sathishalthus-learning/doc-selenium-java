package playground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Locators_Relative {

	public static void main (String args[]) {
	
		// 
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.google.com");

		By aboveBox = RelativeLocator.with(By.name("btnK")).above(By.name("q"));
		By belowButton = RelativeLocator.with(By.name("q")).below(By.name("btnK"));

		driver.findElement(aboveBox).sendKeys("above text");
		driver.findElement(belowButton).click();
		
		
	}

}
