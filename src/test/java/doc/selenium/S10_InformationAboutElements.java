package doc.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class S10_InformationAboutElements {
	//
	@Test
	public void isDisplayed() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/doc.selenium/web/inputs.html");
		// isDisplayed
		// Get boolean value for is element display
		boolean isEmailVisible = driver.findElement(By.name("email_input")).isDisplayed();
		assertEquals(isEmailVisible, true);
		//
		driver.quit();
	}

	//
	@Test
	public void isEnabled() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/doc.selenium/web/inputs.html");
		// isEnabled
		// returns true if element is enabled else returns false
		boolean isEnabledButton = driver.findElement(By.name("button_input")).isEnabled();
		assertEquals(isEnabledButton, true);
		//
		driver.quit();
	}

	//
	@Test
	public void isSelected() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/doc.selenium/web/inputs.html");
		// isSelected
		// returns true if element is checked else returns false
		boolean isSelectedCheck = driver.findElement(By.name("checkbox_input")).isSelected();
		assertEquals(isSelectedCheck, true);
		//
		driver.quit();
	}

	//
	@Test
	public void getTagName() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/doc.selenium/web/inputs.html");
		// TagName
		// returns TagName of the element
		String tagNameInp = driver.findElement(By.name("email_input")).getTagName();
		assertEquals(tagNameInp, "input");
		//
		driver.quit();
	}

	//
	@Test
	public void getSizeAndPosition() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/doc.selenium/web/inputs.html");
		// GetRect
		// Returns height, width, x and y coordinates referenced element
		Rectangle res = driver.findElement(By.name("range_input")).getRect();
		// Rectangle class provides getX,getY, getWidth, getHeight methods
		assertEquals(res.getX(), 10);
		//
		driver.quit();
	}

	//
	@Test
	public void getCSSValue() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/doc.selenium/web/inputs.html");
		// Retrieves the computed style property 'font-size' of field
		String cssValue = driver.findElement(By.name("color_input")).getCssValue("font-size");
		assertEquals(cssValue, "13.3333px");
		//
		driver.quit();
	}

	//
	@Test
	public void getTextContent() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/doc.selenium/web/inputs.html");
		// GetText
		// Retrieves the text of the element
		String text = driver.findElement(By.tagName("h1")).getText();
		assertEquals(text, "Testing Inputs");
		//
		driver.quit();
	}

	//
	@Test
	public void getAttributesAndProperties() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/doc.selenium/web/inputs.html");
		// FetchAttributes
		// identify the email text box
		WebElement emailTxt = driver.findElement(By.name(("email_input")));
		// fetch the value property associated with the textbox
		String valueInfo = emailTxt.getAttribute("value");
		assertEquals(valueInfo, "admin@localhost");
		//
		driver.quit();
	}
}
