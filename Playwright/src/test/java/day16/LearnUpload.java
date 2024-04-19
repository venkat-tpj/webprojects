package day16;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnUpload {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false)
				);
		Page page = browser.newPage();
		
//		page.navigate("https://www.sendgb.com/");
//		
//		page.locator("button:has-text('Close') >> visible=true").click();
//		page.locator("span:has-text('OK') >> visible=true").click();
		/*
//		To upload single file:
		page.locator("input[type='file']").setInputFiles(Paths.get("sample.xlsx"));
		
//		To upload multiple files:
		page.locator("input[type='file']").setInputFiles(new Path[] {
				Paths.get("sample.xlsx"),
				Paths.get("medIns.xlsx")
				});
		*/
//		How to check whether multiple files can be loaded?
		page.navigate("https://the-internet.herokuapp.com/upload");
		FileChooser fileChooser = page.waitForFileChooser(()->{
			page.locator("id=drag-drop-upload").click();
		});
		
		System.out.println(fileChooser.isMultiple());
		if(fileChooser.isMultiple()) {
			fileChooser.setFiles(new Path[] {
					Paths.get("sample.xlsx"),
					Paths.get("medIns.xlsx")
					});
		}
		else System.out.println("only one");
	}
}
