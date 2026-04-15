package utils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import manager.DriverManager;

public class WaitUtils {
	private static WebDriverWait wait;

	public static void initWait() throws NumberFormatException, IOException {
		wait = new WebDriverWait(DriverManager.getDriver(),
				Duration.ofSeconds(Integer.valueOf(BaseUtils.getConfigValue("wait"))));
	}

	public WebDriverWait getWait() {
		return wait;

	}
	public static WebElement elementToBeClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static WebElement visibilityOfElementLocated(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static List<WebElement> visibilityOfAllElementsLocatedBy(By locator) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public static WebElement find(By locator) {
		return DriverManager.getDriver().findElement(locator);
	}
}
