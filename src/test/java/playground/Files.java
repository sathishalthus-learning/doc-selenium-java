package playground;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Files {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement fileInput = driver.findElement(By.id("file-upload"));
		File uploadFile = new File(
				"src/test/resources//doc-selenium-java/src/test/resources/selenium-files/Finders.html");

		fileInput.sendKeys(uploadFile.getAbsolutePath());
		driver.findElement(By.id("file-submit")).click();
		
		 WebElement fileName = driver.findElement(By.id("uploaded-files"));
		 assertEquals("selenium-snapshot.png", fileName.getText());

		driver.close();
		driver.quit();
	}

}
