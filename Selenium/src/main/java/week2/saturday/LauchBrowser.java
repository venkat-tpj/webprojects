package week2.saturday;
import org.openqa.selenium.chrome.ChromeDriver;

public class LauchBrowser {

	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		
		
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		
		
	}
}
 