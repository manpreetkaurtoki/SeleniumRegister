package Assignments;

import java.util.List;

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
	By formAuth = By.xpath("//a[text()='Form Authentication']");
	By userName = By.xpath("//input[@id='username']");
	By dragDrop = By.xpath("//a[text()='Drag and Drop']");
	By boxA = By.xpath("//div[@id='column-a']");
	By boxB = By.xpath("//div[@id='column-b']");
	By header = By.xpath("//div[@id='column-b']/header[text()='A']");
	By hover = By.xpath("//a[text()='Hovers']");
	By userImg = By.xpath("(//img[@src='/img/avatar-blank.jpg'])[1]");
	By userNameTitle = By.xpath("//h5[text()='name: user1']");
	By viewProfile = By.xpath("//a[@href='/users/1']");
	By userheading = By.xpath("//h1[text()='Not Found']");
	By solutionDropDown = By.xpath("//a[@href='https://www.testsmith.io/solutions']");
	By robertDropDownItem1 = By.xpath("//a[contains(@class,'dropdown-item') and normalize-space()='Robotisering']");
	By dropdownSelectedHeading = By.xpath("//h1[text()='Robotisering']");

	@Test
	public void selectAll() {
		driver.navigate().to("https://the-internet.herokuapp.com");

		WebElement formAuthEle = wait.until(ExpectedConditions.visibilityOfElementLocated(formAuth));
		formAuthEle.click();
		WebElement usernameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
		actions.click(usernameEle).sendKeys("tomsmith").keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND)
				.perform();
	}

	@Test
	public void dragDrop() {
		driver.navigate().to("https://the-internet.herokuapp.com");
		WebElement dragDropEle = wait.until(ExpectedConditions.visibilityOfElementLocated(dragDrop));
		dragDropEle.click();

		WebElement boxASource = wait.until(ExpectedConditions.visibilityOfElementLocated(boxA));
		WebElement boxBTarget = wait.until(ExpectedConditions.visibilityOfElementLocated(boxB));
		actions.dragAndDrop(boxASource, boxBTarget).perform();

		boxBTarget = wait.until(ExpectedConditions.visibilityOfElementLocated(header));
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

		WebElement hoverEle = wait.until(ExpectedConditions.visibilityOfElementLocated(hover));
		hoverEle.click();

		WebElement imageEle = wait.until(ExpectedConditions.visibilityOfElementLocated(userImg));

		actions.moveToElement(imageEle).perform();

		WebElement userNameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameTitle));
		String usernameValue = userNameEle.getText();
		Assert.assertEquals(usernameValue, "name: user1");

		WebElement viewProfileEle = wait.until(ExpectedConditions.visibilityOfElementLocated(viewProfile));
		viewProfileEle.click();

		WebElement headingUser = wait.until(ExpectedConditions.visibilityOfElementLocated(userheading));
		System.out.println(headingUser.getText());

		driver.navigate().back();

	}

	@Test
	public void hoverFunctionality() {
		driver.navigate().to("https://www.testsmith.io");

		WebElement solution = wait.until(ExpectedConditions.visibilityOfElementLocated(solutionDropDown));

		actions.moveToElement(solution).perform();

		WebElement dropDownItem = wait.until(ExpectedConditions.visibilityOfElementLocated(robertDropDownItem1));
		actions.moveToElement(dropDownItem).click().perform();

		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownSelectedHeading));
		String header = heading.getText();

		Assert.assertEquals(header, "Robotisering");

	}

	/*@Test
	public void hoverClickDropdownItems() {
		driver.navigate().to("https://www.testsmith.io");

		WebElement solution = wait.until(ExpectedConditions.visibilityOfElementLocated(solutionDropDown));

		actions.moveToElement(solution).perform();
		// Step 4: Re-fetch elements (avoid stale)
		List<WebElement> dropDownItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
				"//div[contains(@class,'dropdown-menu') and contains(@style,'display: block')]//a[contains(@class,'dropdown-item')]")));

		for (int i = 0; i < dropDownItems.size(); i++) {
			WebElement menuElement = wait.until(ExpectedConditions.visibilityOfElementLocated(solutionDropDown));
			actions.moveToElement(menuElement).perform();

			// Step 2: Locate current dropdown item by index (fresh element)
			By currentItemLocator = By
					.xpath("(//div[contains(@class,'dropdown-menu') and contains(@style,'block')]//a)[" + i + "]");
			WebElement item = wait.until(ExpectedConditions.elementToBeClickable(currentItemLocator));

			// Step 3: Click the item
			item.click();

			// Step 4: Wait for navigation to finish
			wait.until(ExpectedConditions.urlContains("/solutions/"));

			// Step 5: Navigate back
			driver.navigate().back();

			// Step 6: Wait for menu to appear again
			wait.until(ExpectedConditions.presenceOfElementLocated(solutionDropDown));
		}
	}*/

}
