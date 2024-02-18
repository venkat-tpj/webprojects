package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.zBaseClass;

		public class CreateLeadPage extends zBaseClass {

				public CreateLeadPage(ChromeDriver driver) {
					this.driver=driver;
				}
			
				public CreateLeadPage enterCompanyname (String cname) {
					driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
					return this;
				}
				
				public CreateLeadPage enterFirstname (String fname) {
					driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
					return this;
				}
				
				public CreateLeadPage enterLastname (String lname) {
					driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
					return this;
				}
				
				public CreateLeadPage enterPhonename (String phno) {
					driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
					return this;
				}
				
				public ViewLeadPage clickOnCreateLeadButton () {
					driver.findElement(By.name("submitButton")).click();
					return new ViewLeadPage (driver);
				}
	
}
