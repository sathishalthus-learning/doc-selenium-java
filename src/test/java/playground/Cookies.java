package playground;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies {
	public static void main(String[] args) {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/cookies.html");
		//
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie:cookies) {
			System.out.println(cookie);
		}
		
		//
		driver.close();
		driver.quit();
		
	}
}
