package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ActionsExamples extends Base {

	public void hoverMouse() {

	}

	@Test
	public void selectAll() {
		driver.navigate().to("https://the-internet.herokuapp.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement formAuthEle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Form Authentication']")));
		formAuthEle.click();

		Actions actions = new Actions(driver);
		WebElement usernameEle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
		actions.click(usernameEle).sendKeys("tomsmith").keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND)
				.perform();
	}

	@Test
	public void dragDrop() {

	}

}
