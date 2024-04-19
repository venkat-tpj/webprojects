package day6;

import java.util.function.Consumer;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


class MyDialog implements Consumer<Dialog>{

	@Override
	public void accept(Dialog alert) {
		System.out.println(alert.message());
		alert.accept("venkat");
		
	}
}

public class LearnAlerts {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
				.newPage();
		page.navigate("https://letcode.in/alert");
		/*
		page.onDialog(dialog -> 
		{
			System.out.println(dialog.defaultValue());
			System.out.println(dialog.message());
			dialog.accept("venkat");
			dialog.dismiss();
			page.offDialog(this);
			
		});
		*/
		
//		page.onDialog(Alert -> Alert.accept());
		Consumer<Dialog> alert = a-> {
			System.out.println(a.message());
			a.accept("venkat");
		};
		page.onDialog(alert);
		page.locator("#accept").click();
//		page.locator("#confirm").click();

		page.locator("#prompt").click();
		System.out.println(page.locator("#myName").textContent());
		page.close();
	}
}
