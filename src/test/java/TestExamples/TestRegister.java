package TestExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRegister {

	@Test
	public void performClick()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://with-bugs.practicesoftwaretesting.com/#/");

		WebElement signInElement = driver.findElement(By.xpath("//a[text()='Sign in']"));
		signInElement.click();
		
	
	}
}
