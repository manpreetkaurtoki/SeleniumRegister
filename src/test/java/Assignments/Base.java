package Assignments;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class Base {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void preReq()
	{
		
		driver= new ChromeDriver();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 System.out.println("entered in pre condition method");
	}
	public void quit()
	{
		driver.quit();
		 System.out.println("entered in closing browser method");
	}
	
}
