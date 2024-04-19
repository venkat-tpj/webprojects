package day4;

import java.util.List;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class LearnDropdown {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(headless).newPage();
		page.navigate("https://letcode.in/dropdowns");
		
//	Method-1
//		page.selectOption("#fruits", "1");
				
//	Method-2 Using element
		Locator fruitDD = page.locator("#fruits");
//		fruitDD.selectOption("1");
//		fruitDD.selectOption(new SelectOption().setLabel("Banana"));
		fruitDD.selectOption(new SelectOption().setIndex(3));
		String notificationMsg = page.locator("//div[@class='notification is-success']//p[1]").textContent();
		System.out.println(notificationMsg);
		
//	To select multiple options:
		Locator herosDD = page.locator("id=superheros");
		herosDD.selectOption(new String[] {"aq", "bt", "cm"});
		
//	How to select last progamming langg
		Locator langDD = page.locator("#lang");
		Locator options = langDD.locator("option");
		
		List<String> allInnerTexts = options.allInnerTexts();
		
		allInnerTexts.forEach(i-> System.out.println(i));
		int count = options.count();
		System.out.println("Length: " +count);
		langDD.selectOption(new SelectOption().setIndex(count-1)
//				, new SelectOptionOptions().setTimeout(10000)
//				, new SelectOptionOptions().setForce(false)
//				, new SelectOptionOptions().setNoWaitAfter(false)
				);
//		page.close();
	}
	
}
