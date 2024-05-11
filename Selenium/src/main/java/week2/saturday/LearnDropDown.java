package week2.saturday;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropDown {

	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/select.xhtml");
		driver.manage().window().maximize();
		
		WebElement parentEle = driver.findElement(By.className("ui-selectonemenu"));
		// Select obj=new Select(WebElement)
		Select dd=new Select(parentEle);
		//dd.selectByIndex(2);
		dd.selectByVisibleText("Playwright");
		
		
	// After week3
		
		List<WebElement> options = dd.getOptions();
			System.out.println(options);			//prints alphanumeric in console
	// Therefore Use for-each loop
		for(WebElement values:options) {
			System.out.println(values.getText());	//getText allows to print webElements(DropDown name), otherwise alphanumeric value
		}
		
		
		
		
	}
}
