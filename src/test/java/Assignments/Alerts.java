package Assignments;

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

public class Alerts extends Base {
	@Test
	public void onClickJsAlert() {

		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

		WebElement jsAlertEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Alert']")));
		jsAlertEle.click();

		// Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();

		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='result']")));
		String messageAlert = text.getText();
		Assert.assertEquals(messageAlert, "You successfully clicked an alert");
	}

	@Test
	public void onClickJsConfirmAlert() {

		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

		WebElement jsAlertConfirmEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Confirm']")));
		jsAlertConfirmEle.click();

		// Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();

		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='result']")));
		String messageAlert = text.getText();
		Assert.assertTrue(messageAlert.equals("You clicked: Ok"));

	}

	@Test
	public void onClickJsConfirmDismissAlert() {

		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

		WebElement jsAlertConfirmEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Confirm']")));
		jsAlertConfirmEle.click();

		// Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='result']")));
		String messageAlert = text.getText();
		Assert.assertTrue(messageAlert.equals("You clicked: Cancel"));

	}

	@Test
	public void onClickJsPromptAlert() {

		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

		WebElement jsAlertPromptEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Prompt']")));
		jsAlertPromptEle.click();

		// Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String valalert = "Manpreet";
		alert.sendKeys(valalert);
		alert.accept();

		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='result']")));
		String messageAlert = text.getText();
		Assert.assertTrue(messageAlert.equals("You entered: " + valalert));
		// Assert.assertTrue(messageAlert.equals("You clicked: Cancel"));

	}

	@Test
	public void onClickJsPromptCancelAlert() {

		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

		WebElement jsAlertPromptEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Prompt']")));
		jsAlertPromptEle.click();

		// Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		System.out.println("Text of alert is" + alert.getText());
		alert.dismiss();

		WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='result']")));
		String messageAlert = text.getText();
		Assert.assertTrue(messageAlert.equals("You entered: null"));

	}

}
