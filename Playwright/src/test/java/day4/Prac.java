package day4;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.SelectOptionOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class Prac {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
				.setHeadless(false)
				.setChannel("msedge")
				);
		Page page = browser.newPage();
		page.navigate("https://letcode.in/dropdowns");
		
		page.selectOption("#fruits", "0");
		String print = page.locator("//div[@class='notification is-success']//p[1]").textContent();
		System.out.println(print);
		/*
		Locator locator = page.locator("#fruits");
		String innerText = locator.innerText();
		System.out.println(innerText);
		*/
		/*
		Locator itemDD = page.locator("#fruits");
//		itemDD.selectOption("Mango");
//		itemDD.selectOption(new SelectOption().setLabel("banana"));
//		itemDD.selectOption(new SelectOptionOptions().setForce(true));
		*/
		/*
//		itemDD.selectOption(new SelectOption().setValue("2"));
//		itemDD.selectOption(new SelectOption().setIndex(5));
		String innerText = itemDD.innerText();
		System.out.println(innerText);
		*/
//		Locator heroDD = page.locator("#superheros");		
//		heroDD.selectOption(new String[] {"am", "aq","ta"});
		
		Locator langgDD = page.locator("id=lang");
		Locator options = langgDD.locator("option");
		int count = options.count();
		System.out.println(count);
		String innerText = langgDD.innerText();
		System.out.println(innerText);
//		langgDD.selectOption(new SelectOption().setLabel("Python"), new SelectOptionOptions().setForce(true));
		langgDD.selectOption(new SelectOption().setLabel("Java"), new SelectOptionOptions().setNoWaitAfter(true));
		
		
		
		
		
	}
}
