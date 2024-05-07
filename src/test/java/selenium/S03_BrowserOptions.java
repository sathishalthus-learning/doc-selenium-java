package selenium;

import org.junit.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class S03_BrowserOptions {
	//
	@Test
	public void setPageLoadStrategyNormal() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBrowserVersion("120");
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		WebDriver driver = new ChromeDriver(chromeOptions);
		try {
			// Navigate to Url
			driver.get("https://selenium.dev");
		} finally {
			driver.quit();
		}
	}

	@Test
	public void setPageLoadStrategyEager() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBrowserVersion("120");
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
		WebDriver driver = new ChromeDriver(chromeOptions);
		try {
			// Navigate to Url
			driver.get("https://selenium.dev");
		} finally {
			driver.quit();
		}
	}

	@Test
	public void setPageLoadStrategyNone() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBrowserVersion("120");
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver = new ChromeDriver(chromeOptions);
		try {
			// Navigate to Url
			driver.get("https://selenium.dev");
		} finally {
			driver.quit();
		}
	}
	
	@Test
	public void capabilities() {
		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.setBrowserVersion("120");
		chromeOptions.setCapability("browserName","chrome");
		chromeOptions.setCapability("browserVersion", 120);
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		WebDriver driver = new ChromeDriver(chromeOptions);
		try {
			// Navigate to Url
			driver.get("https://selenium.dev");
		} finally {
			driver.quit();
		}
	}

}
