package day8;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WhatIsBrowserContext {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		BrowserType browserType = playwright.chromium();
		Browser browser = browserType.launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://bookcart.azurewebsites.net/");	
		
		page.locator("xpath=//span[text()=' Login ']/..").click();
		page.locator("//input[@formcontrolname='username']").fill("ortoni");
		page.locator("//input[@formcontrolname='password']").fill("Pass1234$");
		page.locator("//span[text()='Login']").click();
		String userName = page.locator("(//a[contains(@class,'mat-mdc-menu-trigger mdc-button')]//span)[2]").textContent();
		System.out.println(userName.split(" ")[1].split(" ")[0]);
		page.close();
		/*
//		To open another tab in the same browser
		Page newPage = context.newPage();
		newPage.navigate("https://bookcart.azurewebsites.net/");
		String userName1 = page.locator("//button[contains(@class,'mat-focus-indicator mat-menu-trigger')]//span[1]").textContent();
		System.out.println(userName1.split(" ")[1].split(" ")[0]);
		page.close();
		newPage.close();
		
//		To open new Window
		BrowserContext context2 = browser.newContext();
		Page page2 = context2.newPage();
		
//		page.bringToFront(); This will bring the working window to the front.
		*/
	}
	
}
