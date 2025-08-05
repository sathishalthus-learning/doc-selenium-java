package doc.selenium;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S12_Alerts {
		//
		//
		@Test
		public void simpleAlert() {
			//
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.selenium.dev/doc.selenium/web/alerts.html");
			
			//Click the link to activate the alert
			driver.findElement(By.id("empty-alert")).click();

			//Wait for the alert to be displayed and store it in a variable
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			//Press the OK button
			alert.accept();
			driver.quit();
		}
		
		//
		@Test
		public void confirmAlert() {
			//
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.selenium.dev/doc.selenium/web/alerts.html");
			
			//Click the link to activate the alert
			driver.findElement(By.id("alert")).click();

			//Wait for the alert to be displayed and store it in a variable
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			//Store the alert text in a variable
			String text = alert.getText();
			System.out.println(text);

			//Press the OK button
			alert.accept();
			driver.quit();
		}
		
		//
		@Test
		public void promptAlert() {
			//
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.selenium.dev/doc.selenium/web/alerts.html");
			
			//Click the link to activate the alert
			driver.findElement(By.id("prompt")).click();

			//Wait for the alert to be displayed and store it in a variable
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			//Type your message
			alert.sendKeys("Selenium");

			//Press the OK button
			alert.accept();
			
			//
			driver.quit();
		}
}
