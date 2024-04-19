package day14;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnFramesWay2 {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://letcode.in/frame");
		/*
//		Recommended Way
		FrameLocator frameLoc = page.frameLocator("#firstFr");
		frameLoc.getByPlaceholder("Enter name").fill("Abdul");
		frameLoc.getByPlaceholder("Enter email").fill("kalam");
		*/
//		Another way
		Frame frame = page.frame("firstFr");
		frame.getByPlaceholder("Enter name").fill("Ajith");
		frame.getByPlaceholder("Enter email").fill("kumar");
		
		Frame innerFrame = page.frameByUrl("https://letcode.in/innerFrame");
		innerFrame.getByPlaceholder("Enter email").fill("ajith@gmail.com");
		
//		Pw can interact from child frame to parent frame
		frame.getByPlaceholder("Enter name").fill("Rajini");
		
		
	}
}
