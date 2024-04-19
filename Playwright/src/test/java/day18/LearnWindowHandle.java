package day18;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnWindowHandle {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		
		page.navigate("https://letcode.in/windows");
		/*
		Page popup = page.waitForPopup(()->{
			page.locator("id=home").click();
		});
		popup.waitForLoadState();	//it waits untill page completely loads
		System.out.println("New Tab: "+popup.title());
		System.out.println("New Tab: "+popup.url());
		*/
//		popup.close();
//		page.close();
//		playwright.close();
		
//		To handle multiple windows
		
		page.waitForPopup(new Page.WaitForPopupOptions().setPredicate(
				p->p.context().pages().size()==3),
				()->{
					page.locator("id=multi").click();
				});
		
		List<Page> pages = page.context().pages();
		for(Page tabs: pages) {
			System.out.println(tabs.url());
		}
		Page alertPg = pages.get(1);
		Page ddPg = pages.get(2);
		System.out.println("Alert pg: "+alertPg.textContent("h1"));
		System.out.println("ddPg: "+ddPg.textContent("h1"));
	}
}
