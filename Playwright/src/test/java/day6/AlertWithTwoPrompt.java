package day6;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

//class MyDialog implements Consumer<Dialog> {
//
//	@Override
//	public void accept(Dialog alert) {
//		System.out.println(alert.message());
//		alert.accept();
//		}
//	}
public class AlertWithTwoPrompt {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
		page.navigate("https://letcode.in/alert");
		/*
		Consumer<Dialog> alert= new Consumer<Dialog>() {
			@Override
			public void accept (Dialog d) {
				d.accept("venkat");
//				page.offDialog(this);
	}
};
		*/
		/*
		page.onDialog(alert);
//		page.onDialog(dialog -> dialog.accept("Evershine"));
		page.locator("id=prompt").click();
		*/
		
	}
	
	
}
