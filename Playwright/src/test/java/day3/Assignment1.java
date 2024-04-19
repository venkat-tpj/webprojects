package day3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Assignment1 {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		page.locator("(//input[@id='user-message'])[1]").fill("NeverGiveUp");
		page.locator("id=showInput").click();
		String content1 = page.locator("(//div[@id='user-message']//p)[1]").textContent();
		System.out.println(content1);
		
		page.locator("(//p[contains(@class,'text-gray-900 text-size-15')]/following-sibling::input)[2]").fill("100");
		page.locator("(//form[@id='gettotal']//input)[2]").fill("200");
		page.locator("//form[@id='gettotal']//button[1]").click();
		
		String content2 = page.locator("#addmessage").textContent();
		System.out.println(content2);
//		playwright.close();
	}
}
