package day13;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class LearnDebug {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://bookcart.azurewebsites.net/");
				
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
				.setName("Login")).first().click();
		page.getByLabel("Username").fill("ortoni");
		page.getByLabel("Password").fill("Pass1234$");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
				.setName("Login")).last().click();
		
		page.pause();
		
		page.getByPlaceholder("Search books", new Page.GetByPlaceholderOptions()
				.setExact(!true)).fill("The Hookup");
		page.getByRole(AriaRole.OPTION).first().click();
		page.getByAltText("Book cover image").click();
		System.out.println(page.url());
		playwright.close();
		
	}
}
