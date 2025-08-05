package samples;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StringReplaceAllRegEx {

	public static void main(String[] args) {
		// 
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("http://practice.automationtesting.in/");
		
		// Click on Shop Menu
		driver.findElement(By.xpath("//a[text()=\"Shop\"]")).click();
		
		// Now click on Filter button
		driver.findElement(By.xpath("//button[text()=\"Filter\"]")).click();
		
		// Get the books names between 200 to 450 price and print in Descending order
		List<WebElement> eBooks = driver.findElements(By.xpath("//ul[contains(@class,\"products\")]//li"));
		
		Map<String,Double> catalog = new HashMap<>();
		
		for(WebElement e: eBooks) {
			
			String bookName;
			bookName= e.findElement(By.tagName("h3")).getText();
			
			Double price;
			List<WebElement> insPresent = e.findElements(By.tagName("ins"));
			if(insPresent.size()!=0) {
				String strPrice = e.findElement(By.tagName("ins")).getText().substring(1);
				price = Double.parseDouble(strPrice);
			}
			else
			{ 	
				String strPrice = e.findElement(By.cssSelector(".woocommerce-Price-amount")).getText().substring(1);
				price = Double.parseDouble(strPrice);
			}
			catalog.put(bookName, price);
			
			
		}
		
		System.out.println(catalog);

		driver.close();

	}

}
