package day9;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Prac {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext(
				new Browser.NewContextOptions()
				.setRecordVideoDir(Paths.get("Leaftap/"))
				.setRecordVideoSize(1280, 720)
				);
		
		Page page = context.newPage();
		page.navigate("http://leaftaps.com/opentaps/control/main");
		page.locator("id=username").fill("demoSalesManager");
		page.locator("id=password").fill("crmsfa");
		page.locator(".decorativeSubmit").click();
		
		context.close();
		
		
	}
}
