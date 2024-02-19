package Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import Utils.LearnExcelData;



public class zBaseClass {

	public ChromeDriver driver;
	public String filenames, sheetno;
	
			@BeforeSuite
			public void cloudConection() {
				System.out.println("Establish the connection");
			}
			
			@AfterSuite
			public void disConection() {
				System.out.println("End the connection");
			}
			
			@BeforeMethod
			public void preCondition() {
				
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://leaftaps.com/opentaps/");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			}
			
			@AfterMethod
			public void postCondition() {
				driver.close();
			}
			
			@DataProvider(name="fetchData")
			public String[][] sendData() throws IOException {
				return LearnExcelData.readData(filenames, sheetno);
			}

}