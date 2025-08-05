package doc.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S17_Actions {
	//
	
	@Test
	public void keyboardActions() {
		//
		WebDriver driver = new ChromeDriver();
		
		//
		//keyDown, keyUp
        driver.get("https://www.selenium.dev/doc.selenium/web/single_text_input.html");
        new Actions(driver)
	        .keyDown(Keys.SHIFT)
	        .sendKeys("a")
	        .keyUp(Keys.SHIFT)
	        .sendKeys("b")
	        .perform();

        WebElement textField = driver.findElement(By.id("textInput"));
        Assert.assertEquals("Ab", textField.getAttribute("value"));
        
        //
        // sendKeysToActiveElement
        driver.get("https://www.selenium.dev/doc.selenium/web/single_text_input.html");

        new Actions(driver)
                .sendKeys("abc")
                .perform();

        WebElement activeElement = driver.findElement(By.id("textInput"));
        Assert.assertEquals("abc", activeElement.getAttribute("value"));
        
        //
        // sendKeysToDesignatedElement
        driver.get("https://www.selenium.dev/doc.selenium/web/single_text_input.html");
        driver.findElement(By.tagName("body")).click();

        WebElement designatedElement = driver.findElement(By.id("textInput"));
        new Actions(driver)
                .sendKeys(designatedElement, "Selenium!")
                .perform();

        Assert.assertEquals("Selenium!", textField.getAttribute("value"));
        
        //
        // copyAndPaste
        driver.get("https://www.selenium.dev/doc.selenium/web/single_text_input.html");

        Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;

        WebElement targetField = driver.findElement(By.id("textInput"));
        new Actions(driver)
                .sendKeys(targetField, "Selenium!")
                .sendKeys(Keys.ARROW_LEFT)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.ARROW_UP)
                .keyUp(Keys.SHIFT)
                .keyDown(cmdCtrl)
                .sendKeys("xvv")
                .keyUp(cmdCtrl)
                .perform();

        Assert.assertEquals("SeleniumSelenium!", textField.getAttribute("value"));
        //
        driver.quit();
	}
	
	//
	//
	@Test
	public void mouseActions() {
		//
		WebDriver driver = new ChromeDriver();
		
		//
		//click and hold
        driver.get("https://www.selenium.dev/doc.selenium/web/single_text_input.html");
        
        WebElement clickandhold = driver.findElement(By.id("clickable"));
        new Actions(driver)
                .clickAndHold(clickandhold)
                .perform();
        
        //
        // click and release
        WebElement clickandrelease = driver.findElement(By.id("click"));
        new Actions(driver)
                .click(clickandrelease)
                .perform();
        
        
        //
        //context click
        WebElement contextclick = driver.findElement(By.id("clickable"));
        new Actions(driver)
                .contextClick(contextclick)
                .perform();
        
        
        //
        // double click
        WebElement doubleclick = driver.findElement(By.id("clickable"));
        new Actions(driver)
                .doubleClick(doubleclick)
                .perform();
        
        //
        // move to element
        WebElement hoverable = driver.findElement(By.id("hover"));
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();
        //
        // move by offset from element
        WebElement tracker = driver.findElement(By.id("mouse-tracker"));
        new Actions(driver)
                .moveToElement(tracker, 8, 0)
                .perform();
        
        // move by offset from current position
        new Actions(driver)
        .moveByOffset(13, 15)
        .perform();
        
        //
        // drag and drop by element
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform();
        
        // drag and drop by offset
        WebElement draggable2 = driver.findElement(By.id("draggable"));
        Rectangle start = draggable2.getRect();
        Rectangle finish = driver.findElement(By.id("droppable")).getRect();
        new Actions(driver)
                .dragAndDropBy(draggable2, finish.getX() - start.getX(), finish.getY() - start.getY())
                .perform();
       // 
       driver.quit();
	}
}
