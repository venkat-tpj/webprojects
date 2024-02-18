package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.zBaseClass;

public class MyLeads extends zBaseClass {

	public MyLeads(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public CreateLeadPage clickOnCreateLead () {
		driver.findElement(By.linkText("Create Lead")).click();
			return new CreateLeadPage (driver);
			}

}
