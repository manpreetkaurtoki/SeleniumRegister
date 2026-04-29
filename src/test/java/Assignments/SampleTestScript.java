package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SampleTestScript {

	WebDriver driver;
	WebDriverWait wait;
	By to = By.xpath("//input[@id = 'destinput']");
	By from = By.xpath("//input[@id = 'srcinput']");

	@Test
	public void selectDate() {
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(to));
		wait.until(ExpectedConditions.visibilityOfElementLocated(from));

		driver.findElement(from).sendKeys("Bangalore");

		driver.findElement(from).sendKeys("Delhi");
	
	}
}
