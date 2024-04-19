package day14;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnFrames {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		page.navigate("https://letcode.in/frame");
		
//		To check number of frames:
		List<Frame> frames = page.frames();
		System.out.println(frames.size()); 
		/*
//		Method-1
		
		Frame frame = page.frame("firstFr");
		frame.getByPlaceholder("Enter name").fill("Rajini");
		frame.getByPlaceholder("Enter email").fill("kanth");
		
		Frame innerFrame = page.frameByUrl(Pattern.compile("innerFrame"));
//		frameBYUrl works only when src variable present
		innerFrame.getByPlaceholder("Enter email").fill("rajini@gmail.com");
		*/
		/*
//		Method-2
		Frame frame = page.frame("firstFr");
		frame.getByPlaceholder("Enter name").fill("Rajini");
		frame.getByPlaceholder("Enter email").fill("kanth");
		List<Frame> childFrames = frame.childFrames();
		childFrames.forEach(f->
			{System.out.println(f.url());
		});
		
		Frame innerFrame = page.frameByUrl("https://letcode.in/innerFrame");
		innerFrame.getByPlaceholder("Enter email").fill("rajini@gmail.com");
		*/
		/*
//		Method-3
		Frame frame = page.frame("firstFr");
		frame.getByPlaceholder("Enter name").fill("Rajini");
		frame.getByPlaceholder("Enter email").fill("kanth");
		List<Frame> childFrames = frame.childFrames();
		childFrames.forEach(f->
			{System.out.println(f.url());
			});
		
		FrameLocator frameLoc = frame.frameLocator("//div[contains(@class,'container has-text-centered')]//iframe[1]");
		frameLoc.getByPlaceholder("Enter email").fill("rajini@gmail.com");
		*/
		
//		playwright.close();
			
	}
}
