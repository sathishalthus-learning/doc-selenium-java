package selenium;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class S12_Alerts {

		//
	
		WebDriver driver = new ChromeDriver();
		
		//
		@Test
		public void simpleAlert() {
			//Click the link to activate the alert
			driver.findElement(By.linkText("See an example alert")).click();

			//Wait for the alert to be displayed and store it in a variable
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			//Store the alert text in a variable
			String text = alert.getText();

			//Press the OK button
			alert.accept();
		}
		
		//
		@Test
		public void confirmAlert() {
			//Click the link to activate the alert
			driver.findElement(By.linkText("See an example alert")).click();

			//Wait for the alert to be displayed and store it in a variable
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			//Store the alert text in a variable
			String text = alert.getText();

			//Press the OK button
			alert.accept();
		}
		
		//
		@Test
		public void promptAlert() {
			//Click the link to activate the alert
			driver.findElement(By.linkText("See a sample prompt")).click();

			//Wait for the alert to be displayed and store it in a variable
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			//Type your message
			alert.sendKeys("Selenium");

			//Press the OK button
			alert.accept();
		}
}
