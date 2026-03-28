package Assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class Base {

	WebDriver driver;
	
	@BeforeMethod
	public void preReq()
	{
		driver= new ChromeDriver();
		
	}
	public void quit()
	{
		driver.quit();
	}
	
}
