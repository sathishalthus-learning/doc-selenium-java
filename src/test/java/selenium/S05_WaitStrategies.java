package selenium;

import java.time.Duration;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class S05_WaitStrategies {
	//
	 @Test
	  public void implicit() {
		 WebDriver driver = new ChromeDriver();

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
	    driver.findElement(By.id("adder")).click();

	    WebElement added = driver.findElement(By.id("box0"));

	    Assert.assertEquals("redbox", added.getDomAttribute("class"));
	    driver.quit();
	  }
	 //
	@Test
	public void explicit() {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
		WebElement revealed = driver.findElement(By.id("revealed"));	
		driver.findElement(By.id("reveal")).click();

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> revealed.isDisplayed());

		revealed.sendKeys("Displayed");
		Assert.assertEquals("Displayed", revealed.getDomProperty("value"));
		driver.quit();
	}

	@Test
	public void explicitWithOptions() {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
		WebElement revealed = driver.findElement(By.id("revealed"));
		driver.findElement(By.id("reveal")).click();

		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(2))
				.pollingEvery(Duration.ofMillis(300))
				.ignoring(ElementNotInteractableException.class);

		wait.until(d -> {
			revealed.sendKeys("Displayed");
			return true;
		});

		Assert.assertEquals("Displayed", revealed.getDomProperty("value"));
		driver.quit();
	}
}
