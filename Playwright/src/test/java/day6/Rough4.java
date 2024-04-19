package day6;

import java.util.function.Consumer;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Rough4 {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
				.newPage();
		page.navigate("https://letcode.in/alert");

		//		Consumer<Dialog> alert= a -> {
		//			System.out.println(a.message());
		//			a.accept("peter");
		//		};

		Consumer<Dialog> alert= new Consumer<Dialog>() {
			public void accept(Dialog d) {
				d.accept("peter");
				page.offDialog(this);
			}
		};
		
		page.onDialog(alert);
		page.locator("#accept").click();

		page.onDialog(dialog -> {
			System.out.println(dialog.message());
			dialog.accept("fernwood");

		});
		page.locator("#prompt").click();
		String content = page.locator("#myName").textContent();
		System.out.println(content);

	}
}
