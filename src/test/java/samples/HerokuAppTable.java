package samples;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HerokuAppTable {

	public static void main(String[] args) {
		// 
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://the-internet.herokuapp.com/tables");
		
		List<WebElement> priceElements = driver.findElements(By.xpath("//table[@id=\"table1\"]//td[4]"));
		
		double[] prices = new double[priceElements.size()];
		
		for(int i=0; i<priceElements.size();i++) {
			double price = Double.parseDouble(priceElements.get(i).getText().substring(1));
			prices[i]=price;
		}


		
		for(int i=0;i<prices.length-1;i++) {
			for(int j=0;j<prices.length-1-i;j++) {
				if(prices[j]<prices[j+1] ){
					double temp = prices[j];
					prices[j]= prices[j+1];
					prices[j+1] = temp;
				}
			}
		}
		
		for(double d: prices) {
			System.out.println(d);
		}
		driver.close();

	}

}
