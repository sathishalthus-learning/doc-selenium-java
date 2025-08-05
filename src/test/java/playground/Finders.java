package playground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

public class Finders {

	public static void main(String[] args) {
		// 
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		
		//By
		driver.findElement(By.id("my-text-id"));
		
		// By Chained
		By example = new ByChained(By.id(null),By.id(null));
		
		// By All
//		By examples = new ByAll(By.id(null),By.name(null));
		
		// relative locators
		// above,near, below,leftof, rightof
		By relative = RelativeLocator.with(By.id(null)).above(By.className(null));
		
		// chaining
		

	}

}
