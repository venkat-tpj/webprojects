package day3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class rough {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
				.setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://letcode.in/edit");
		
		String content = page.locator("(//label[@class='label'])[1]").textContent();
		System.out.println(content);
		page.locator("#fullName").fill("peter fernwood");
		Locator locator = page.locator("#join");
		locator.fill("I am a good person");
		String attribute = page.locator("#getMe").getAttribute("value");
		System.out.println(attribute);
		
		String attribute2 = page.locator("(//input[@class='input'])[3]").getAttribute("value");
		System.out.println(attribute2);
		page.locator("(//input[@class='input'])[3]").clear();
		boolean disabled = page.locator("#noEdit").isDisabled();
		System.out.println(disabled);
		
		Locator labelone = page.locator("//label[@for='name']");
		int count = labelone.count();
		System.out.println(count);
		
		for(int i=0; i<count; i++) {
		
			String first = labelone.nth(i).textContent();
			System.out.println(first);
		}
		
		playwright.close();
		
	}
}
