package playground;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Locators_By {

	@Test
	public void ByLocator() {
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.google.com");
		//
		By searchBox =  By.name("q");
		By searchButton = By.name("btnK");
		
		driver.findElement(searchBox).sendKeys("come on");
		driver.findElement(searchButton).click();
	}
	
	@Test
	public void RelativeLocators() {
	
		// 
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.google.com");

		By aboveBox = RelativeLocator.with(By.name("q")).above(By.name("btnK"));
		By belowButton = RelativeLocator.with(By.name("btnK")).below(By.name("q"));

		driver.findElement(aboveBox).sendKeys("above text");
		driver.findElement(belowButton).click();
		
		
	}

}
