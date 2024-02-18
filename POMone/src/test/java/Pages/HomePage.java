package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.zBaseClass;

public class HomePage extends zBaseClass {

	public HomePage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public MyHomePage clickOnCRMSFA () {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage(driver);
	}
	
}
