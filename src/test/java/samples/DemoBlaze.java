package samples;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoBlaze {

	public static void main(String[] args) {
		// 
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.demoblaze.com/");
		
		List<WebElement> priceElements = driver.findElements(By.xpath("//div[@class='card-block']//h5"));
		List<Integer> prices = new ArrayList<>();
		for(WebElement e : priceElements) {
			prices.add(Integer.parseInt(e.getText().replaceAll("$", "")));
		}
		
		List<WebElement> nameElements = driver.findElements(By.xpath("//div[@class='card-block']//h5/a"));
		List<String> names = new ArrayList<>();
		for(WebElement e : nameElements) {
			prices.add(Integer.parseInt(e.getText()));
		}
		
		List<Integer> filteredPrice = new ArrayList<>();
		// filter prices
		for(Integer i: prices) {
			if(i >= 360 && i<=700) {
				filteredPrice.add(i);
			}
		}
		System.out.println(filteredPrice);
		
		for(int i=0;i<filteredPrice.size()-1;i++) {
			for(int j=0; j<filteredPrice.size()-1;j++) {
				Integer left =filteredPrice.get(j);
				Integer right = filteredPrice.get(j+1); 
				if(left>right) {
					Integer temp = left;
					left = right;
					right=temp;
				}
			}
		}
		
		for(Integer i: filteredPrice) {
			System.out.println(names.get(prices.indexOf(filteredPrice.get(0)))+ " : " + i);
		}
		
		
//		Get the phone names and print in descending order based on price between 360 to 700.
		
		driver.close();

	}

}
