package samples;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class StreamOfWebElements {

	public static void main(String[] args) {
		// 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.saucedemo.com/v1/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("#login-button")).click();
		
		// PRODUCTS
		// count()
		List<WebElement> list = driver.findElements(By.cssSelector(".inventory_item"));
		int itemsCount = (int) list.stream().count();
		System.out.println("PRODUCTS=======================================");
		System.out.println("items count : " + itemsCount);
		// map()
		List<WebElement> inventory_item_price = driver.findElements(By.cssSelector(".inventory_item_price"));
		List<String> inventory_item_prices = inventory_item_price.stream().map(WebElement::getText).toList();
		// distinct
		System.out.println("distinct----------------------------");
		inventory_item_prices.stream().distinct().forEach(e->System.out.println(e));
		// sorted
		System.out.println("sorted------------------------------");
		inventory_item_prices.stream().sorted().forEach(e->System.out.println(e));
		
		//
		System.out.println("itemprice----------------------------");
		list.stream().forEach(e->{
			WebElement item =  e.findElement(By.cssSelector(".inventory_item_price"));
			System.out.println(item.getText());
		});
		
		List<WebElement> buttons = driver.findElements(By.cssSelector(".btn_inventory"));
		buttons.forEach(e->{
			e.click();
		});
		
		// CART
		System.out.println("CART======================================");
		driver.findElement(By.cssSelector("#shopping_cart_container")).click();
//		WebElement cartList = driver.findElement(By.cssSelector(".cart_list"));
		List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart_item"));
		cartItems.stream().forEach(e->{
			WebElement qty =  e.findElement(By.cssSelector(".cart_quantity"));
			System.out.println(qty.getText());
		});
		
		
		driver.quit();
	}
}
