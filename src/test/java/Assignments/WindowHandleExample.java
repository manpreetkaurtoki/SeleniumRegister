package Assignments;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowHandleExample extends Base {

	By newTab = By.id("tabButton");
	By newWindow = By.id("windowButton");
	By newWindowMsg = By.id("messageWindowButton");

	@Test
	public void windowHandles() {
		driver.navigate().to("https://demoqa.com/browser-windows");
		WebElement tabHandle = driver.findElement(newTab);
		WebElement windowHandle = driver.findElement(newWindow);
		WebElement windowMsg = driver.findElement(newWindowMsg);
		String mainWindow = driver.getWindowHandle();

		tabHandle.click();
		windowHandle.click();
		// windowMsg.click();

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			System.out.println("Size of handles" + driver.getWindowHandles().size());
			System.out.println(handle);

			if (!handle.equals(mainWindow)) {

				driver.switchTo().window(handle);
				String message = wait.until(ExpectedConditions.elementToBeClickable(By.id("sampleHeading"))).getText();
				Assert.assertEquals(message, "This is a sample page");
				/*
				 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 * String bodyText =
				 * wait.until(ExpectedConditions.elementToBeClickable(By.tagName("body"))).
				 * getText(); System.out.println("Message: " + bodyText);
				 */
			}

		}

	}

}
