package playground;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	public static void main(String[] args) {
		// 
		WebDriver driver = new ChromeDriver();
		//
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		
		// explicit 
		WebElement revealed = driver.findElement(By.id("my-text-id"));
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(d-> revealed.isDisplayed());
//		wait.until(ExpectedConditions.alertIsPresent());
		wait.until(ExpectedConditions.elementToBeClickable(revealed));
		
		// fluent wait
		Wait<WebDriver> fWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(2))
				.pollingEvery(Duration.ofMillis(300))
				.ignoring(ElementNotInteractableException.class);
		fWait.until(d-> {revealed.sendKeys("hello");return true;});
		
		// 
		driver.close();
		driver.quit();
	}

}
