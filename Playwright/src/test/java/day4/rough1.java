package day4;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class rough1 {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://letcode.in/dropdowns");
		
		Locator fruitsDD = page.locator("#fruits");
		page.selectOption("id=fruits", "0");
		Locator options = fruitsDD.locator("option");
		int count = options.count();
		int i=0;
		System.out.println("Len: "+count);
		List<String> allInnerTexts = options.allInnerTexts();
//		allInnerTexts.forEach(i-> System.out.println(i));
		
		for(i=0;i<=count-1;i++) {
//			count++;
			
		}
		System.out.println(allInnerTexts);
		playwright.close();
	
	}
}
