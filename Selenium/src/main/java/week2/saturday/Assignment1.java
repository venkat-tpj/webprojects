package week2.saturday;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("demosalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("CoronisHealth");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Venkatesan");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Veeran");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Venkat");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("Veera");
		driver.findElement(By.name("departmentName")).sendKeys("CLAIMS");
		driver.findElement(By.name("description")).sendKeys("OnlyDenialFollowUp");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("venkat.evershine@gmail.com");
		
		WebElement place = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd=new Select (place);
		dd.selectByVisibleText("New York");
		
		driver.findElement(By.className("smallSubmit")).click();
		String title=driver.getTitle();
		System.out.println(title);
		
		
	}

}
