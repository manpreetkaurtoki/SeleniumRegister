package TestExamples;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRegister {

	@Test
	public void performClick() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://with-bugs.practicesoftwaretesting.com/#/");

		WebElement signInElement = driver.findElement(By.xpath("//a[text()='Sign in']"));
		signInElement.click();

	}

	@Test
	public void practiceSelenium() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

		WebElement alertClick = driver.findElement(By.xpath("//button[contains(text(),'Alerts, Frames & Windows')]"));
		alertClick.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement alerts = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' Alerts']")));
		alerts.click();

		WebElement seeAlert = driver.findElement(By.xpath("//button[text()='Alert']"));
		seeAlert.click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		// label[contains(text(),'alert will appear after 5 seconds')]/following::button[1]

		WebElement buttonAlertClick = driver.findElement(By.xpath("//button[@onclick='myMessage()']"));
		buttonAlertClick.click();
		
		Thread.sleep(7000);
		alert.accept();
		
		
		
	}
}
