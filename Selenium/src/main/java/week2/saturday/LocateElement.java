package week2.saturday;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocateElement {

	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username"));
		
		driver.findElement(By.id("username")).sendKeys("demosalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		WebElement list = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select option=new Select(list);
		option.selectByIndex(2);
		List<WebElement> options = option.getOptions();
		for (WebElement dd : options) {
			System.out.println(dd.getText());
		}
		
		
//		op.selectByIndex(2);
		
		
	}

}
