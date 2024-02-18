package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.zBaseClass;

public class MyHomePage extends zBaseClass {

	public MyHomePage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public MyLeads clickOnLeads () {
		driver.findElement(By.linkText("Leads")).click();
		return new MyLeads (driver);
	}
	
}
