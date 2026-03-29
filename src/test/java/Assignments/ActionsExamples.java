package Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsExamples extends Base {

	public void hoverMouse() {

	}

	@Test
	public void selectAll() {
		driver.navigate().to("https://the-internet.herokuapp.com");

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
		driver.navigate().to("https://the-internet.herokuapp.com");
		WebElement dragDropEle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Drag and Drop']")));
		dragDropEle.click();

		Actions actions = new Actions(driver);
		WebElement boxASource = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='column-a']")));
		WebElement boxBTarget = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='column-b']")));
		actions.dragAndDrop(boxASource, boxBTarget).perform();

		boxBTarget = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='column-b']/header[text()='A']")));
		String headerText = boxBTarget.getText();
		
		Assert.assertEquals(headerText, "A");
	}

}
