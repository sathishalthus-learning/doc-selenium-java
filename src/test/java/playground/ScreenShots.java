package playground;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShots {

	public static void main(String[] args) throws IOException {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		// screenshot page
		File screenshotPage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotPage, new File("src/test/resources/ss.jpg"));
		
		
		// screenshot element
	    WebElement element = driver.findElement(By.cssSelector("h1"));
	    File screenshotElement = element.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshotElement, new File("src/test/resources/ee.jpg"));
		
		//
		driver.close();
		driver.quit();
	}

}
