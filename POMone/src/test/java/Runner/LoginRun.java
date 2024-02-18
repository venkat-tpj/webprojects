package Runner;

import org.testng.annotations.Test;

import Base.zBaseClass;
import Pages.LoginPage;


public class LoginRun extends zBaseClass {
	@Test
	public void runLogin () {
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUsername("DemoSalesManager").enterPassword("crmsfa").clickOnLoginButton();
	}
}
