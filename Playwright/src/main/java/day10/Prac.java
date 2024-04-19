package day10;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class Prac {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
				
		context.tracing().start(
				new Tracing.StartOptions()
//						.setScreenshots(true)
//						.setSnapshots(true)
						.setSources(true)
						);
		Page page = context.newPage();
		
		page.navigate("https://letcode.in/edit");
		page.locator("#fullName").fill("Koushik C");
		page.locator("#join").clear();
		page.locator("#join").fill("I am a good person");
//		page.fill("#fullName", "Koushik C");
		String value = page.locator("id=getMe").getAttribute("value");
		System.out.println(value);
		page.locator("(//label[text()='Clear the text']/following::input)[1]").clear();
		
		context.tracing().stop(
				new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
		
		context.close();
		
		
		
	}
}
