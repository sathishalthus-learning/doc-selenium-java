package selenium;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S08_FindingElements {
	//
	
	@Test
	public void findingFirstElement() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/workspaces/selenium/Locators.html");
		
		// evaluating entire DOM
		WebElement vegetable = driver.findElement(By.className("tomatoes"));

		// evaluating subset of DOM
		WebElement fruits = driver.findElement(By.id("fruits"));
		WebElement fruit = fruits.findElement(By.className("tomatoes"));
		  
		// optimized locator
		WebElement fruito = driver.findElement(By.cssSelector("#fruits .tomatoes"));
		  
	}
	
	@Test
	public void findingAllMatchingElements() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/workspaces/selenium/Locators.html");
		
		List<WebElement> plants = driver.findElements(By.tagName("li"));
		  
		// get an element
		List<WebElement> elements = driver.findElements(By.tagName("li"));
		for (WebElement element : elements) {
		    System.out.println("Paragraph text:" + element.getText());
		}	  
	}
	
	@Test
	public void findingElementsFromElement() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/workspaces/selenium/Locators.html");
		
        // Get element with tag name 'div'
        WebElement element = driver.findElement(By.tagName("div"));

        // Get all the elements available with tag name 'p'
        List<WebElement> elements = element.findElements(By.tagName("p"));
        for (WebElement e : elements) {
            System.out.println(e.getText());
        }	  
	}
	
	@Test
	public void getActiveElement() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("webElement");

        // Get attribute of current active element
        String attr = driver.switchTo().activeElement().getAttribute("title");
        System.out.println(attr);
			  
	}
	
}
