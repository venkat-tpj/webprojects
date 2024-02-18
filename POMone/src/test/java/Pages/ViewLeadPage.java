package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Base.zBaseClass;

public class ViewLeadPage extends zBaseClass {
		
			public ViewLeadPage(ChromeDriver driver) {
				this.driver=driver;
			}
	
			public void verifyFirstname () {
			String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
			if(text.contains("Dilip")) {
				System.out.println("passed");
			}else {
				System.out.println("not passsed");
			}
		}
}
