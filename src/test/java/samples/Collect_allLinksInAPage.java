package samples;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Collect_allLinksInAPage {

	public static void main(String[] args) {
		// 
		ChromeOptions options = new ChromeOptions();
		options.setBrowserVersion("127");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		List<String> hrefs = links.stream().map(link->link.getAttribute("href")).collect(Collectors.toList());
		
		hrefs.forEach(System.out::println);
		
		driver.quit();
		

	}

}
