package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TableAssignment extends Base {
	By langCheck = By.xpath("//input[@name='lang' and @value='Java']");
	By checkboxIntermediate = By.xpath("//input[@type='checkbox' and @value='Intermediate']");
	By checkboxAdvanced = By.xpath("//input[@type='checkbox' and @value='Advanced']");

	@Test
	public void TestCase1() {

		driver.navigate().to("https://practicetestautomation.com/practice-test-table/?utm_source=chatgpt.com");
		WebElement langFilterJava = driver.findElement(langCheck);
		langFilterJava.click();

		List<WebElement> listOfData = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table/tbody/tr[not(contains(@style,'display: none'))]")));
		System.out.println(listOfData.size());

		// table//tr//td[@headers='col_lang' and text()='Java']
		for (WebElement element : listOfData) {
			String language = element.findElement(By.xpath("//table//tr//td[@headers='col_lang']")).getText();
			System.out.println(language);
			Assert.assertEquals(language, "Java");
		}
	}

	@Test
	public void TestCase2() {
		driver.navigate().to("https://practicetestautomation.com/practice-test-table/?utm_source=chatgpt.com");
		driver.findElement(checkboxIntermediate).click();
		driver.findElement(checkboxAdvanced).click();

		List<WebElement> listOfData = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table/tbody/tr[not(contains(@style,'display: none'))]")));
		System.out.println(listOfData.size());

		for (WebElement element : listOfData) {
			String level = element.findElement(By.xpath("//table//tr//td[@headers='col_level']")).getText();
			System.out.println(level);
			Assert.assertEquals(level, "Beginner");
		}
	}
}
