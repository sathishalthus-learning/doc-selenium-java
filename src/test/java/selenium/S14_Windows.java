package selenium;


import java.io.File;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.print.PrintOptions;
import org.apache.commons.io.FileUtils;

public class S14_Windows {
	//
	//
	@Test
	public void windowsAndTabs() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/workspaces/selenium/Locators.html");
		//
		driver.getWindowHandle();
		//Store the ID of the original window
		String originalWindow = driver.getWindowHandle();

		//Check we don't have other windows open already
		assert driver.getWindowHandles().size() == 1;

		//Click the link which opens in a new window
		driver.findElement(By.linkText("new window")).click();

		//Wait for the new window or tab
		wait.until(numberOfWindowsToBe(2));

		//Loop through until we find a new window handle
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}

		//Wait for the new tab to finish loading content
		wait.until(titleIs("Selenium documentation"));
		//
		
		// Opens a new tab and switches to new tab
		driver.switchTo().newWindow(WindowType.TAB);

		// Opens a new window and switches to new window
		driver.switchTo().newWindow(WindowType.WINDOW);
		  

		driver.switchTo().newWindow(WindowType.TAB);
		
		//Close the tab or window
		driver.close();

		//Switch back to the old tab or window
		driver.switchTo().window(originalWindow);

		//
		driver.quit();
	}
	
	@Test
	public void windowManagement() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/workspaces/selenium/Locators.html");
		//
		
		//Access each dimension individually
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();

		//Or store the dimensions and query them later
		Dimension size = driver.manage().window().getSize();
		int width1 = size.getWidth();
		int height1 = size.getHeight();
		  
		// set window size
		driver.manage().window().setSize(new Dimension(1024, 768));
		
		//get window position
		// Access each dimension individually
		int x = driver.manage().window().getPosition().getX();
		int y = driver.manage().window().getPosition().getY();

		// Or store the dimensions and query them later
		Point position = driver.manage().window().getPosition();
		int x1 = position.getX();
		int y1 = position.getY();
		
		// set window position
		// Move the window to the top left of the primary monitor
		driver.manage().window().setPosition(new Point(0, 0));
		  
		// maximize window
		driver.manage().window().maximize();
		
		// minimize window
		driver.manage().window().minimize();
		
		//full screen window
		driver.manage().window().fullscreen();
		
		//
		driver.quit();
	}
	
	@Test
	public void screenshot() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/workspaces/selenium/Locators.html");
		//
		// screenshot window
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./image.png"));
		
        // element screenshot
        WebElement element = driver.findElement(By.cssSelector("h1"));
        File scrFile = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./image.png"));
        
	}
	
	@Test
	public void executingScripts() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/workspaces/selenium/Locators.html");
		//
	    //Creating the JavascriptExecutor interface object by Type casting
	      JavascriptExecutor js = (JavascriptExecutor)driver;
	    //Button Element
	      WebElement button =driver.findElement(By.name("btnLogin"));
	    //Executing JavaScript to click on element
	      js.executeScript("arguments[0].click();", button);
	    //Get return value from script
	      String text = (String) js.executeScript("return arguments[0].innerText", button);
	    //Executing JavaScript directly
	      js.executeScript("console.log('hello world')");
	}
	
	@Test
	public void printPage() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/workspaces/selenium/Locators.html");
		//
	
	    driver.get("https://www.selenium.dev");
	    printer = (PrintsPage) driver;

	    PrintOptions printOptions = new PrintOptions();
	    printOptions.setPageRanges("1-2");

	    Pdf pdf = printer.print(printOptions);
	    String content = pdf.getContent();
	}
}
