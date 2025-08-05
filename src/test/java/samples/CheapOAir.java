package samples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheapOAir {

	public static void main(String[] args) {
		// 
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.cheapoair.com/");
		
			// 1. Select one way trip
			driver.findElement(By.cssSelector(".select-dropdown-selected-item")).click();
			driver.findElement(By.xpath("//*[text()=\"One-way\"]")).click();
			
			// 2. Select Destination
			WebElement destination = driver.findElement(By.id("fs_destCity_0"));
			destination.clear();
			
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(d->{})
	
			
			// 3. Select Travel date
			driver.findElement(By.cssSelector(".v2-date")).click();
			driver.findElement(By.cssSelector(".is--depart")).click();

			// 4. Select 2 adults & Click on Done
			driver.findElement(By.className("travelers-count")).click();
			driver.findElement(By.id("addADULTS")).click();
			driver.findElement(By.xpath("//button[text()='Done']")).click();
			
			// 5. Click search Flights
			driver.findElement(By.xpath("//input[@value='Search Flights']")).click();
			
			//6. write a logic to find the lowest price flight and print.
			WebElement elements = driver.findElement(By.tagName("li"));
//			List<WebElement> elements = driver.findElements(null);
//			List<Integer> prices ;
//			for(WebElement e : elements) {
//				prices.add(Integer.parseInt(e.getText().substring(0);
//			}
//				
			Integer minPrice=0;
//			for(Integer price: prices) {
//				if(minPrice<price)
//				minPrice = price;
//			}
			
			System.out.println("Minimum Price" + minPrice);
		driver.close();

	}

}
