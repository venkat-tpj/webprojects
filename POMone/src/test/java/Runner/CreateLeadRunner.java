package Runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.zBaseClass;
import Pages.LoginPage;

public class CreateLeadRunner extends zBaseClass {

	@BeforeClass
	public void setfileName() {
		filenames="dataprovexcel";
		
		
	}
	
	@Test(dataProvider="fetchData")
	public void runCreate (String cname, String fname, String lname, String phno) {
		
		LoginPage lp=new LoginPage(driver);
		lp.enterUsername("DemoSalesManager").enterPassword("crmsfa").clickOnLoginButton().clickOnCRMSFA()
		.clickOnLeads().clickOnCreateLead().enterCompanyname(cname).enterFirstname(fname).enterLastname(lname)
		.enterPhonename(phno).clickOnCreateLeadButton().verifyFirstname();
	
	}
	
}
