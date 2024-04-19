package day12;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PwLocators {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		
		/*
		page.navigate("https://letcode.in/test");
		
//		page.click("text=Click");
//		Another way
		page.click("'Click'");
//		System.out.println(page.url());
		
		page.locator("button:has-text('Goto Home')").click();
//		System.out.println(page.url());
		
		page.locator("nav :text('Product')").click();
		System.out.println(page.url());
		*/
		
		page.navigate("http://127.0.0.1:5500/allText/index.html");
		page.locator("button.btn.btn-primary:visible").click();
//		Another way using xpath
		page.locator("//button[@class='btn btn-primary'] >> visible=true").click();
		System.out.println(page.locator("#attach").textContent());
		
//		Using nth locator
		page.locator("button").locator("nth=1").click();
		System.out.println(page.locator("#attach").textContent());
		page.locator("button").locator("nth=2").click();
		Thread.sleep(3000);
		System.out.println(page.locator("#attach").textContent());
		
//		Using this or that locator
		page.locator("#innerText, #innerText2").click();
//		using xpath
		page.locator("//button[text()='Inner Text'] | //button[text()='Inner Text 1']").click();
//		playwright.close();
		
	}
}
