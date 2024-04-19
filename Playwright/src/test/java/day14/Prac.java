package day14;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Prac {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions()
//				.setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://letcode.in/frame");
		
		Frame frame = page.frame("firstFr");
		frame.getByPlaceholder("Enter name").fill("Rajini");
		frame.getByPlaceholder("Enter email").fill("kanth");
		
//		List<Frame> childFrames = frame.childFrames();
		
		
		/*
		childFrames.forEach(f->
			{System.out.println(f.url());
			System.out.println(f.title());
		});
		*/
//		Frame innerFrame = page.frameByUrl("https://letcode.in/innerFrame");
//		innerFrame.getByPlaceholder("Enter email").fill("rajini@gmail.com");
		
		
	}
}
