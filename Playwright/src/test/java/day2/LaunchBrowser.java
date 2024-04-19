package day2;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create(); //ctrl+2L
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
				.setHeadless(false) 				// setHeadless(true) will not show the browser
				.setChannel("chrome") 				//To run using local chrome browser from laptop
				);
		Page page = browser.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
		
		String title = page.title();
		System.out.println("Page title: " +title);
		
		String url = page.url();
		System.out.println("Page url: " +url);
		
		page.close();
		browser.close();
//		playwright.close();
		
//		To open in different browser		
		Browser fbrowser = playwright.firefox().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page fpage = fbrowser.newPage();
		fpage.navigate("http://leaftaps.com/opentaps/control/main");
		String ftitle = fpage.title();
		System.out.println("Page title = " +ftitle);
		fpage.close();
		fbrowser.close();
		playwright.close();
	}
}
