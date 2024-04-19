package day5;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Codegen {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://letcode.in/");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Log in")).click();
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter registered email")).click();
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter registered email")).fill("venkatveera.tpj@gmail.com");
      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter registered email")).press("Tab");
      page.getByPlaceholder("Enter password").fill("Tester@2572");
      page.getByPlaceholder("Enter password").press("Tab");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("LOGIN")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign out")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Work-Space")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Drop-Down")).click();
      page.locator("#fruits").selectOption("3");
      page.getByText("You have selected Banana").click();
      playwright.close();
    }
    
  }
}