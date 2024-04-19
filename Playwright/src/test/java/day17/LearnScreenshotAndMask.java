package day17;

import java.nio.file.Paths;
import java.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ScreenshotCaret;

public class LearnScreenshotAndMask {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		
		page.navigate("https://github.com/ortoniKC/playwright-java-2023");
		/*
//		When embedding with ExtentReport:
//		byte[] screenshot = page.screenshot();
		page.screenshot(new ScreenshotOptions().setPath(Paths.get("./snaps/img.png")));
		page.screenshot(new ScreenshotOptions().setPath(Paths.get("./snaps/full.png"))
				.setFullPage(true));
		*/
//		Taking Screenshot at Locator level
		Locator searchLoc = page.getByPlaceholder("Search");
		
		searchLoc.screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get("./snaps/locator.png")));
		
//		caretoption: blink
		searchLoc.click();
		searchLoc.screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get("./snaps/initial.png"))
				.setCaret(ScreenshotCaret.INITIAL));
		
		searchLoc.screenshot(new Locator.ScreenshotOptions()
				.setPath(Paths.get("./snaps/hide.png"))
				.setCaret(ScreenshotCaret.HIDE));
		
		
//		set Mask
		page.screenshot(new ScreenshotOptions()
				.setPath(Paths.get("./snaps/masking.png"))
				.setCaret(ScreenshotCaret.INITIAL)
				.setMask(Arrays.asList(searchLoc)));
		
		
		playwright.close();
	}
}
