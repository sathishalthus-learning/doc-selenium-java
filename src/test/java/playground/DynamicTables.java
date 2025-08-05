package playground;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTables {

	public static void main(String[] args) {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers");
		driver.manage().window().maximize();

		WebElement table = driver.findElement(By.tagName("table"));
//		System.out.println(table.getText());

//		table.findElement(By.)
		
		for (int i = 1; i <= 6; i++) {
			String head = driver.findElement(By.xpath("//table[@class='dataTable']/thead/tr/th[" + i + "]")).getText();
			System.out.println(head);
		}
		
		for (int i = 1; i <= 6; i++) {
			String head = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[" + i + "]")).getText();
			System.out.println(head);
		}

		driver.quit();

	}

}
