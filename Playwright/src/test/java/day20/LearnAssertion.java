package day20;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnAssertion {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		
		page.navigate("https://letcode.in/edit");
		
		Locator header = page.locator("h1");
		
//		setDefaultAssertionTimeout(10000);
		
		assertThat(page).hasTitle("Interact with Input fields");
		assertThat(page).hasURL("https://letcode.in/edit");
		assertThat(header).hasText("Input");
		
		assertThat(page.locator("#join")).hasAttribute("value", "I am good");
		
		page.navigate("https://letcode.in/radio");
		assertThat(page.locator("#notfoo")).isChecked();
//		assertThat(page.locator("#notfoo")).not().isChecked();
		
		playwright.close();
		
	}

	
}
