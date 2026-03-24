package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

	@Test
	public void enableTextField() {
		WebDriver driver = new ChromeDriver();

		// Step 1
		driver.navigate().to("https://the-internet.herokuapp.com/");

		// Step 2
		WebElement disableElement = driver.findElement(By.xpath("//a[text()='Dynamic Controls']"));
		disableElement.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Step 3
		WebElement disableField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text' and @disabled]")));

		// Step 4
		WebElement enableBtn = driver.findElement(By.xpath("//button[text()='Enable']"));
		enableBtn.click();

		// Step 5 a,b,c
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text()='Enable']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Disable']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Disable']")));

		// Step 6
		WebElement compareText = driver.findElement(By.xpath("//p[@id='message']"));
		Assert.assertEquals(compareText.getText(), "It's enabled!");

	}

	@Test
	public void removeAddCheckBox() {
		WebDriver driver = new ChromeDriver();
		// Step 1
		driver.navigate().to("https://the-internet.herokuapp.com/");

		// Step 2
		WebElement disableElement = driver.findElement(By.xpath("//a[text()='Dynamic Controls']"));
		disableElement.click();

		// Step 3
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement remove = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Remove']")));

		// Step 4
		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		checkbox.click();

		// Step 5
		remove.click();

		// Step 6
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text()='Remove']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add']")));

		// Step 7
		WebElement compareText = driver.findElement(By.xpath("//p[@id='message']"));
		Assert.assertEquals(compareText.getText(), "It's gone!");
	}

	@Test
	public void dropdownPerform() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
		WebElement dropdownEle = driver.findElement(By.xpath("//a[text()='Dropdown']"));
		dropdownEle.click();

		WebElement dropSelect = driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select dropChoose = new Select(dropSelect);
		dropChoose.selectByIndex(2);
	}

}
