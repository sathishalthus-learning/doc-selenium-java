package doc.selenium;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class S13_Cookies {
	//
	//
	@Test
	public void addCookie() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.example.com");
		driver.manage().addCookie(new Cookie("key", "value"));
		driver.quit();
	}

	@Test
	public void getNamedCookie() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.example.com");
		driver.manage().addCookie(new Cookie("foo", "bar"));

		// Get cookie details with named cookie 'foo'
		Cookie cookie1 = driver.manage().getCookieNamed("foo");
		System.out.println(cookie1);
		driver.quit();
	}

	@Test
	public void getAllCookies() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.example.com");
		// Add few cookies
		driver.manage().addCookie(new Cookie("test1", "cookie1"));
		driver.manage().addCookie(new Cookie("test2", "cookie2"));

		// Get All available cookies
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies);
		driver.quit();
	}

	@Test
	public void deleteCookie() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.example.com");
		driver.manage().addCookie(new Cookie("test1", "cookie1"));
		Cookie cookie1 = new Cookie("test2", "cookie2");
		driver.manage().addCookie(cookie1);

		// delete a cookie with name 'test1'
		driver.manage().deleteCookieNamed("test1");

		/*
		 * Selenium Java bindings also provides a way to delete cookie by passing cookie
		 * object of current browsing context
		 */
		driver.manage().deleteCookie(cookie1);
		driver.quit();
	}

	@Test
	public void deleteAllCookies() {
		//
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.example.com");
		driver.manage().addCookie(new Cookie("test1", "cookie1"));
		driver.manage().addCookie(new Cookie("test2", "cookie2"));

		// deletes all cookies
		driver.manage().deleteAllCookies();
		driver.quit();
	}

	@Test
	public void samesiteCookies() {	
		//
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.example.com");
		Cookie cookie = new Cookie.Builder("key", "value").sameSite("Strict").build();
		Cookie cookie1 = new Cookie.Builder("key", "value").sameSite("Lax").build();
		driver.manage().addCookie(cookie);
		driver.manage().addCookie(cookie1);
		System.out.println(cookie.getSameSite());
		System.out.println(cookie1.getSameSite());
		driver.quit();
	}
}
