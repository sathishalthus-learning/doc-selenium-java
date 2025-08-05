package samples;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		
//		WebElement table = driver.findElement(By.cssSelector(".tsc_table_s13"));
		List<WebElement> elements = driver.findElements(By.xpath("//table[@class=\"tsc_table_s13\"]//tr/td[3]"));
		List<Integer> heights = new ArrayList<Integer>();
		
		for(WebElement e : elements) {
			heights.add(Integer.parseInt(e.getText().substring(0,3)));
			
		}
		
//		for(Integer i : heights) {
//			System.out.println(i);
//		}
//		
//		for(int i=0;i<=heights.size()-1;i++) {
//				Integer left = heights.get(i);
//			for(int j=i+1;j<=heights.size()-1;j++) {
//				Integer right = heights.get(j);
//				
//				// swap
//				if(left>right) {
//					
//					
//					Integer temp = left;
//					left = right;
//					right = temp;
//					
//					heights.set(i, left);
//					heights.set(j, right);
//					
//				}
//
//			}
//		}
//		
		
		Collections.sort(heights,Collections.reverseOrder());
		System.out.println(heights);
		
		driver.close();
		driver.quit();

	}

}
