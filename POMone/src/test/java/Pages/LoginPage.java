package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.zBaseClass;

	public class LoginPage extends zBaseClass {

				public LoginPage(ChromeDriver driver) {
					this.driver=driver;
				}
				
				public LoginPage enterUsername(String username) {
					driver.findElement(By.id("username")).sendKeys(username);
					return this;
				}
				
				public LoginPage enterPassword(String password) {
					driver.findElement(By.id("password")).sendKeys(password);
					return this;
				}
				
				public HomePage clickOnLoginButton() {
					driver.findElement(By.className("decorativeSubmit")).click();
					return new HomePage(driver);
				}
	
}
