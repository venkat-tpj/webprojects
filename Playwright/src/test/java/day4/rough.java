package day4;

import java.util.List;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class rough {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
		Page page = playwright.chromium().launch(headless).newPage();
		page.navigate("https://letcode.in/dropdowns");

//		page.selectOption("#fruits", "1");

		Locator fruitsDD = page.locator("#fruits");
		fruitsDD.selectOption("2");
		fruitsDD.selectOption(new SelectOption().setIndex(3));
		fruitsDD.selectOption(new SelectOption().setLabel("Banana"));
		fruitsDD.selectOption(new SelectOption().setValue("4"));

		String content = page.locator("//div[@class='notification is-success']//p[1]").textContent();
		System.out.println(content);

		Locator herosDD = page.locator("#superheros");
		herosDD.selectOption(new String[] {"aq", "bt", "ca"});
		String content2 = page.locator("(//p[@class='subtitle'])[2]").textContent();
		System.out.println(content2);

		Locator langDD = page.locator("#lang");
		Locator options = langDD.locator("option");

		List<String> allInnerTexts = options.allInnerTexts();
		allInnerTexts.forEach(i-> System.out.println(i));
		int count = options.count();
		System.out.println("Length: "+count);
		langDD.selectOption(new SelectOption().setIndex(count-1));
	}
}
