package utils;

import org.openqa.selenium.By;

import manager.ExtentTestManager;


public class UiActionUtils {
	public static String getText(By locator) {
		String uitext = WaitUtils.visibilityOfElementLocated(locator).getText();
		return uitext;

	}

	public static void enterText(By locator, String text) {

		WaitUtils.visibilityOfElementLocated(locator).sendKeys(text);
		ExtentTestManager.log.info("Entered Text : " + text);
	}

	public static void enterPassword(By locator, String text) {

		WaitUtils.visibilityOfElementLocated(locator).sendKeys(text);
		ExtentTestManager.log.info("Entered Password : " + "********");
	}

	public static void click(By locator, String text) {
		WaitUtils.elementToBeClickable(locator).click();
		ExtentTestManager.log.info(text + " has been clicked");
	}

}
