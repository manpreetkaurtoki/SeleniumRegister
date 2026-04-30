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
	By datefield = By.xpath("//div[@role='combobox']");

	@Test
	public void selectDate() {
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(from)).sendKeys("Bangalore");
		// wait.until(ExpectedConditions.visibilityOfElementLocated(to)).sendKeys("Delhi");

		wait.until(ExpectedConditions.elementToBeClickable(datefield)).click();
		while (true) {
			String displayedMonth = driver.findElement(By.className("monthYearHolidayWrap___6ee5fb")).getText();
			System.out.println(displayedMonth);

			if (displayedMonth.equals("May 2026")) {
				break;
			} else {
			driver.findElement(By.xpath("//i[@role='button' and @tabindex='0']")).click();
			}
		}

		// Select day
		driver.findElement(By.xpath("//span[text()='30']")).click();
	}
}
