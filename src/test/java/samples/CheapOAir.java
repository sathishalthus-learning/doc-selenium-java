package samples;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheapOAir {

	public static void main(String[] args) throws InterruptedException{
		// 
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
		try{
			driver.get("https://www.cheapoair.com/");

	        // Select the "One Way Trip" radio button
	        WebElement tripType =  driver.findElement(By.xpath("//div[text()='One-way']"));
	        JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()",tripType );
			
	        
	     // Enter the destination as "MAAs"
			WebElement destination =  driver.findElement(By.xpath("//a[@aria-label='clear field']"));
			jse.executeScript("argument[0].click()", destination);
			WebElement eleFrom = driver.findElement(By.id("from0"));
			eleFrom.sendKeys("MAA");
			Thread.sleep(500);
			eleFrom.sendKeys(Keys.TAB);

	        // Clear the destination input field
	        driver.findElement(By.xpath("(//a[@aria-label='clear field'])[2]")).click();

	        // Enter the destination as "Bengaluru"
	        WebElement dest = driver.findElement(By.xpath("//input[contains(@id,'to')]"));
	        Thread.sleep(2000); // Pause for 2 seconds to ensure input field is ready
	        dest.sendKeys("Bengaluru"); // Input destination name
	        Thread.sleep(2000); // Pause for 2 seconds to wait for autocomplete options
	        dest.sendKeys(Keys.ENTER); // Select the entered destination

	        // Select today's date from the calendar
	        WebElement eleDate = driver.findElement(By.xpath("//a[contains(@class,'month-date is--today')]"));
	        driver.executeScript("arguments[0].click();", eleDate);

	        // Scroll to and click on the "Traveler" section
	        WebElement traveler = driver.findElement(By.xpath("//div[text()='Traveler']"));
	        driver.executeScript("arguments[0].scrollIntoView(true);", traveler);
	        traveler.click();

	        // Add one adult traveler
	        driver.findElement(By.id("addadults")).click();
	        
	        // Click the "Done" button to confirm traveler selection
	        WebElement eleDone = driver.findElement(By.xpath("//button[text()='Done']"));
	        driver.executeScript("arguments[0].click();", eleDone);

	        // Click on the "Search Now" button to search for flights
	        driver.findElement(By.id("searchNow")).click();

	        // Pause for 10 seconds to allow search results to load
	        Thread.sleep(10000);

	        // Locate all price elements from the search results
	        List<WebElement> allElements = driver.findElements(By.xpath("//span[@class='currency text-nowrap']"));
	        
	        // Initialize a list to store all prices as doubles
	        List<Double> allPrice = new ArrayList<>();
	        
	        // Extract the price (in title attribute) from each element and add it to the list
	        for (WebElement eachEle : allElements) {
	            String priceInString = eachEle.getAttribute("title"); // Get price as a string
	            double priceInDouble = Double.parseDouble(priceInString); // Convert string to double
	            System.out.println(priceInDouble); // Print each price
	            allPrice.add(priceInDouble); // Add price to the list
	        }

	        // Initialize the least price variable with the first price
	        Double least = allPrice.get(0);
	        
	        // Iterate through the price list to find the lowest price
	        for (int i = 0; i < allPrice.size(); i++) {
	            Double val = allPrice.get(i);
	            if (val < least) {
	                least = val; // Update least price if a lower price is found
	            }
	        }
	        // Print the least price
	        System.out.println("The lowest price flight is: USD " + least);

	        // Locate and click the "Select" button for the flight with the least price
	        WebElement eleSelect = driver.findElement(By.xpath("//span[contains(@title,'" + least + "')]/following::span[text()='Select']"));
	        driver.executeScript("arguments[0].click();", eleSelect);
	        Thread.sleep(5000);
	        // Close the browser
	        driver.quit();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			driver.quit();
		}
	
	}

}
