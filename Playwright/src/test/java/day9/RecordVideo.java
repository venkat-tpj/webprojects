package day9;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
 

public class RecordVideo {

public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		Browser browser = browserType.launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
				.setRecordVideoDir(Paths.get("videos/"))
				.setRecordVideoSize(1280, 720));
//		videos will be saved in webm format.
		
		Page page = context.newPage();
		page.navigate("https://bookcart.azurewebsites.net/");	
		page.click("//span[text()=' Login ']/..");	
		page.locator("input[formcontrolname='username']").fill("ortoni");
		page.locator("input[formcontrolname='password']").fill("Pass1234$");
		page.locator("//span[text()='Login']").click();
		String userName = page.locator("(//a[contains(@class,'mat-mdc-menu-trigger mdc-button')]//span)[2]").textContent();
		System.out.println(userName.split(" ")[1].split(" ")[0]);
		context.close(); //this is must to save the video.
//		playwright.close();
	
}
}