package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TableAssignment extends Base {
	By langCheck = By.xpath("//input[@name='lang' and @value='Java']");
	By langPython = By.xpath("//input[@type='radio' and @value='Python']");
	By checkboxIntermediate = By.xpath("//input[@type='checkbox' and @value='Intermediate']");
	By checkboxAdvanced = By.xpath("//input[@type='checkbox' and @value='Advanced']");
	By dropdownLabel = By.xpath("//span[@class='dropdown-label']");
	By filterEnroll = By.xpath("//ul[@class='dropdown-menu']/li[text()='10,000+']");

	@Test
	public void TestCase1() {

		driver.navigate().to("https://practicetestautomation.com/practice-test-table/?utm_source=chatgpt.com");
		WebElement langFilterJava = driver.findElement(langCheck);
		langFilterJava.click();

		List<WebElement> listOfData = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//table/tbody/tr[not(contains(@style,'display: none'))]//td[@headers='col_lang']")));
		System.out.println(listOfData.size());
		for (WebElement element : listOfData) {
			System.out.println(element.getText());
			Assert.assertEquals(element.getText(), "Java");
		}
	}

	@Test
	public void TestCase2() {
		driver.navigate().to("https://practicetestautomation.com/practice-test-table/?utm_source=chatgpt.com");
		driver.findElement(checkboxIntermediate).click();
		driver.findElement(checkboxAdvanced).click();

		List<WebElement> listOfData = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//table/tbody/tr[not(contains(@style,'display: none'))]//td[@headers='col_level']")));

		for (WebElement element : listOfData) {
			System.out.println(element.getText());
			Assert.assertEquals(element.getText(), "Beginner");

		}
	}

	@Test
	public void TestCase3() {
		driver.navigate().to("https://practicetestautomation.com/practice-test-table/?utm_source=chatgpt.com");
		driver.findElement(dropdownLabel).click();
		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='dropdown-menu']/li")));
		WebElement enrolment = wait.until(ExpectedConditions.elementToBeClickable(filterEnroll));
		enrolment.click();
		List<WebElement> listOfData = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//table/tbody/tr[not(contains(@style,'display: none'))]//td[@headers='col_enroll']")));
		System.out.println(listOfData.size());
		for (WebElement element : listOfData) {
			int value = Integer.parseInt(element.getText().trim());
			Assert.assertTrue(value >= 10000);
		}

	}

	@Test
	public void TestCase4() {
		driver.navigate().to("https://practicetestautomation.com/practice-test-table/?utm_source=chatgpt.com");
		driver.findElement(langPython).click();
		driver.findElement(checkboxAdvanced).click();
		driver.findElement(checkboxIntermediate).click();
		driver.findElement(dropdownLabel).click();
		driver.findElement(filterEnroll).click();

		List<WebElement> listOfData = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table/tbody/tr[not(contains(@style,'display: none'))]")));

		for (WebElement element : listOfData) {
			//it finds cell inside current row where data matches these conditions
			String lang = element.findElement(By.xpath("./td[@data-col='language']")).getText();
			String level = element.findElement(By.xpath("./td[@data-col='level']")).getText();
			String enrollAmount = element.findElement(By.xpath("./td[@data-col='enrollments']")).getText();
			System.out.println(lang);
			System.out.println(level);
			System.out.println(enrollAmount);

			Assert.assertEquals(lang, "Python");
			Assert.assertEquals(level, "Beginner");
			int value = Integer.parseInt(enrollAmount.trim());
			Assert.assertTrue(value >= 10000);

		}
	}
}
