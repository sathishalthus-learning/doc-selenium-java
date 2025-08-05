package playground;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {

	public static void main(String[] args) {
		// 
		WebDriver driver =  new  ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/alerts.html");
		//
		driver.findElement(By.id("alert")).click();
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		// alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		System.out.println("hhhhaaaa");
		
		// prompt
		driver.findElement(By.id("prompt")).click();
		Wait<WebDriver> wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait2.until(ExpectedConditions.alertIsPresent());
		Alert prompt =  driver.switchTo().alert();
		System.out.println(prompt.getText());
		prompt.sendKeys("hello");
		prompt.accept();
		
		driver.close();
		driver.quit();
		
	}

}
