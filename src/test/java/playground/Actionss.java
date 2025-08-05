package playground;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionss {

	public static void main(String[] args) {
		// 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		// keyboard actions
		WebElement textinput = driver.findElement(By.id("my-text-id"));
		Actions typing = new Actions(driver);
		typing.keyDown(Keys.SHIFT).sendKeys(textinput,"hello yar").build().perform();

	}

}
