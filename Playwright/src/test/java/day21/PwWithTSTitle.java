package day21;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PwWithTSTitle {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		Browser browser = browserType.launch(new BrowserType.LaunchOptions()
		        .setHeadless(true));
		BrowserContext context = browser.newContext(
				new Browser.NewContextOptions().setStorageStatePath(Paths.get("auth.json"))
				);
		Page page = context.newPage();
//		PLAYWRIGHT WITH TYPESCRIPT - 2023
		
		page.navigate("https://www.youtube.com/playlist?list=PL699Xf-_ilW7EyC6lMuU4jelKemmS6KgD");
		Locator headone = page.locator("//h3[@class='style-scope ytd-playlist-video-renderer']//a");
		int count = headone.count();
		System.out.println(count);
		
		for (int i=0; i<count; i++) {
			String print = headone.nth(i).textContent();
			System.out.println(print);
		}
		
		
		/*
		System.out.println(textCont);
		
		int count = textCont.count();
//		System.out.println("Total: "+count);
//		page.locator("(//h3[@class='style-scope ytd-playlist-video-renderer']//a)[1]").textContent();
		

		for(int i=0;i<count;i++) {
			String content = head.textContent();
			System.out.println(content);
		}*/
//		playwright.close();
	}
}
