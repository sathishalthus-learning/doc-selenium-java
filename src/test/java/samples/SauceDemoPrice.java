package samples;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class SauceDemoPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/v1/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		List<WebElement> priceItems = driver.findElements(By.cssSelector(".inventory_item_price"));
		
		
		List<String> prices = new ArrayList<>();
		
		for(int i=0; i<priceItems.size();i++) {
			WebElement e = priceItems.get(i);
			prices.add(e.getText());
		}
		
		prices.sort(null);
		
		
		

		driver.quit();
		
		

	}

}
