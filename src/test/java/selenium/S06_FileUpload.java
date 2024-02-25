package selenium;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S06_FileUpload {
	//
	@Test
	public void fileUploadTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		File uploadFile = new File("src/test/resources/selenium-snapshot.png");

		WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
		fileInput.sendKeys(uploadFile.getAbsolutePath());
		driver.findElement(By.id("file-submit")).click();

		WebElement fileName = driver.findElement(By.id("uploaded-files"));
		Assert.assertEquals("selenium-snapshot.png", fileName.getText());
	}

}
