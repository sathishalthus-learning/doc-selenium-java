package doc.selenium;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class S03_BrowserOptions {
	//
	@Test
	public void setPageLoadStrategies() {
		//
		ChromeOptions chromeOptions = new ChromeOptions();
		
		//1.
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		//2.
		//chrmeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
		//3.
		//chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		try {
			// Navigate to Url
			driver.get("https://doc.selenium.dev");
		} finally {
			driver.quit();
		}
	}


	
	@Test
	public void allCapabilities() {
		//
		ChromeOptions chromeOptions = new ChromeOptions();
		// 1. Browser
		chromeOptions.setCapability("browserName","chrome");
		//2. Browser Version
		//chromeOptions.setBrowserVersion("120");
		chromeOptions.setCapability("browserVersion", "120");
		//3. Platform Name
		chromeOptions.setCapability("platformName", "Windows");
		//4. insecure certificate
		chromeOptions.setCapability("acceptInsecureCerts", true);
		// 5. script timeout
		chromeOptions.setScriptTimeout(Duration.ofSeconds(1));
		//6. page load timeout
		chromeOptions.setPageLoadTimeout(Duration.ofSeconds(3));
		//7. implicit wait timeout
		chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(2));
		//8. unhandled prompt behaviour
		chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
		//9.  proxy
		   Proxy proxy = new Proxy();
		    proxy.setHttpProxy("<HOST:PORT>");
		    chromeOptions.setCapability("proxy", proxy);
		// 10. set window rect
		    
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		try {
			// Navigate to Url
			driver.get("https://doc.selenium.dev");
		} finally {
			driver.quit();
		}
	}

}
