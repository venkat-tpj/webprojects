package day4;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Assignment1 {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://testsheepnz.github.io/BasicCalculator.html");
		page.locator("#number1Field").fill("100");
		page.locator("#number2Field").fill("25");
		Locator opeDD = page.locator("#selectOperationDropdown");
		opeDD.selectOption("0");
		page.locator("#calculateButton").click();
		String answer = page.locator("//label[text()='Answer']").textContent();
		System.out.println(answer);
		String attribute = page.locator("id=numberAnswerField").getAttribute("value");
		System.out.println(attribute);
		
		
	}
}
