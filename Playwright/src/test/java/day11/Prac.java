package day11;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Prac {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
		
		page.getByLabel("Username").fill("demoSalesManager");
		page.getByLabel("Password").fill("crmsfa");
		page.locator("class=decorativeSubmit").click();
		page.close();
		playwright.close();
		
	}
}
