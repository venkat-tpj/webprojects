package day6;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AlertSelfResolved {

	public static void main(String[] args) {

				Playwright playwright = Playwright.create();
				Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
				page.navigate("https://letcode.in/alert");
		
				page.onDialog(dialog-> {
					dialog.accept("Evershine Hero");
					System.out.println(dialog.message());
				});
				page.locator("id=accept").click();
				page.locator("id=confirm").click();
				page.locator("id=prompt").click();
		
				page.locator("id=modern").click();
				String textContent = page.locator("p.title").textContent();
				System.out.println(textContent);
				page.locator("//button[@class='modal-close is-large']").click();
				page.close();

//				In case, if I have two prompt field to enter Firstname and Lastname, 
//				I cannot use onDialog. I should use Consumer.
	}

}
