package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ActionsExamples extends Base {

	@Test
	public void selectAll() {
		driver.navigate().to("https://the-internet.herokuapp.com");

		WebElement formAuthEle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Form Authentication']")));
		formAuthEle.click();
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

		WebElement boxASource = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='column-a']")));
		WebElement boxBTarget = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='column-b']")));
		actions.dragAndDrop(boxASource, boxBTarget).perform();

		boxBTarget = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='column-b']/header[text()='A']")));
		String headerText = boxBTarget.getText();

		// Assert.assertEquals(headerText, "A");

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(headerText, "A", "Header Validation failed");

		System.out.println("I am trying drag and drop functionality ");
		System.out.println("I am testing soft assertion if condition get fails ");
		System.out.println("I am testing if it keeps executing next lines ");
		softAssert.assertAll();
	}

	@Test
	public void hoverMouse() {
		driver.navigate().to("https://the-internet.herokuapp.com");

		WebElement hoverEle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Hovers']")));
		hoverEle.click();

		WebElement imageEle = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[1]")));
		
		actions.moveToElement(imageEle).perform();

		WebElement userNameEle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='name: user1']")));
		String usernameValue = userNameEle.getText();
		Assert.assertEquals(usernameValue, "name: user1");

		WebElement viewProfileEle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/users/1']")));
		viewProfileEle.click();

		WebElement headingUser = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Not Found']")));
		System.out.println(headingUser.getText());

		driver.navigate().back();

	}

	@Test
	public void hoverFunctionality() {
		driver.navigate().to("https://www.testsmith.io");
		
		WebElement solution = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@href='https://www.testsmith.io/solutions']")));
	
		actions.moveToElement(solution).perform();

		WebElement dropDownItem = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[contains(@class,'dropdown-item') and normalize-space()='Robotisering']")));
		actions.moveToElement(dropDownItem).click().perform();

		WebElement heading = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Robotisering']")));
		String header = heading.getText();

		Assert.assertEquals(header, "Robotisering");

	}

}
