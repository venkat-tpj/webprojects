package day8;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Prac {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
//		Page amazpage = context.newPage();
		Page flipPage = context.newPage();
//		amazpage.navigate("https://www.amazon.in/");
		flipPage.navigate("https://www.flipkart.com/");
		
		BrowserContext context2 = browser.newContext();
		Page apage = context2.newPage();
		apage.navigate("https://www.amazon.in/");
		
		
		
		
		
	}
}
