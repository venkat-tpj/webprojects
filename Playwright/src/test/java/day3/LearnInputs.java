package day3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnInputs {

	public static void main(String[] args) {
	
		Playwright playwright = Playwright.create(); //ctrl+2L
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
				.setHeadless(false) 				// setHeadless(true) will not show the browser
				.setChannel("chrome") 				//To run using local chrome browser from laptop
				);
		Page page = browser.newPage();
		page.navigate("https://letcode.in/edit");
		
		page.fill("#fullName", "peter");
//		page.locator("#fullName").type("peter"); 	//.type() is deprecated
//		page.locator("#fullName").fill("peter");
		
		Locator locator = page.locator("#join");
//		locator.press("End");
		locator.fill("I am a good man");
//		locator.press("Tab");
		String attribute = page.locator("id=getMe").getAttribute("value");
		System.out.println(attribute);
		page.locator("(//label[text()='Clear the text']/following::input)[1]").clear();
	}
	
}
