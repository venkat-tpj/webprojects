package day10;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class LearnTraceViewer {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();

		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Browser browser = browserType.launch(headless);

		BrowserContext context = browser.newContext();

		context.tracing().start(
				new Tracing.StartOptions()
				.setScreenshots(true)
				.setSnapshots(true)
				.setSources(true)
				);

		Page page = context.newPage();
		
		// basic input field interaction
		page.navigate("https://letcode.in/edit");
		page.locator("#fullName").fill("Koushik C");
		page.locator("#join").clear();
		page.locator("#join").fill("I am a good person");
//		page.fill("#fullName", "Koushik C");
		String value = page.locator("id=getMe").getAttribute("value");
		System.out.println(value);
		page.locator("(//label[text()='Clear the text']/following::input)[1]").clear();
		
		// login
		page.navigate("https://bookcart.azurewebsites.net/");
		page.click("//span[text()=' Login ']/..");
		page.locator("input[formcontrolname='username']").fill("ortoni");
		page.locator("input[formcontrolname='password']").fill("Pass1234$");
		page.locator("//span[text()='Login']").click();
		String userName = page.locator("(//a[contains(@class,'mat-mdc-menu-trigger mdc-button')]//span)[2]")
				.textContent();
		System.out.println(userName.split(" ")[1].split(" ")[0]);
		
		context.tracing().stop(
				new Tracing.StopOptions()
				.setPath(Paths.get("trace.zip"))
				);

		context.close();
		playwright.close();
	}
}