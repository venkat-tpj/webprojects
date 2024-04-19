package day19;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitForSelectorState;

public class LearnElements {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		
		page.navigate("https://letcode.in/elements");
		
		page.getByPlaceholder("Enter your").fill("ortoniKC");
		page.locator("id=search").click();
		
		Locator links = page.locator("ol li a");
		links.last().waitFor(new Locator.WaitForOptions()
				.setState(WaitForSelectorState.ATTACHED)
				.setTimeout(20000));
		
		int count = links.count();
		System.out.println("Count: "+count);
		
		for(int i=0; i<count; i++) {
			String textContent = links.nth(i).textContent();
			System.out.println(textContent);
		}
	}
}
