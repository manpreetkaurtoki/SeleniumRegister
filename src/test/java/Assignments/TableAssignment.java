package Assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TableAssignment extends Base {
	By langAny = By.xpath("//input[@name='lang' and @value='Any']");
	By langCheck = By.xpath("//input[@name='lang' and @value='Java']");
	By langPython = By.xpath("//input[@type='radio' and @value='Python']");
	By checkboxIntermediate = By.xpath("//input[@type='checkbox' and @value='Intermediate']");
	By checkboxAdvanced = By.xpath("//input[@type='checkbox' and @value='Advanced']");
	By checkboxBeginner = By.xpath("//input[@type='checkbox' and @value='Beginner']");
	By dropdownLabel = By.xpath("//span[@class='dropdown-label']");
	By filterEnroll = By.xpath("//ul[@class='dropdown-menu']/li[text()='10,000+']");
	By resetBtn = By.id("resetFilters");
	By sort = By.xpath("//select[@id='sortBy']");

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
			// finds cell inside current row where data matches these conditions
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

	@Test
	public void TestCase5() {
		driver.navigate().to("https://practicetestautomation.com/practice-test-table/?utm_source=chatgpt.com");
		driver.findElement(langPython).click();
		driver.findElement(checkboxBeginner).click();
		driver.findElement(checkboxIntermediate).click();

		WebElement noMatch = driver.findElement(By.xpath("//div[@id='noData']"));
		Assert.assertTrue(noMatch.isDisplayed(), " matching courses. ");
	}

	@Test
	public void TestCase6() {
		driver.navigate().to("https://practicetestautomation.com/practice-test-table/?utm_source=chatgpt.com");
		driver.findElement(langCheck).click();
		WebElement checkReset = wait.until(ExpectedConditions.visibilityOfElementLocated(resetBtn));
		Assert.assertTrue(checkReset.isDisplayed(), "Reset btn is not displayed");

		checkReset.click();

		WebElement checkAnyLang = wait.until(ExpectedConditions.visibilityOfElementLocated(langAny));
		Assert.assertTrue(checkAnyLang.isSelected(), "Any lanaguage option is not selected");

		WebElement checkCheckboxBeginner = wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxBeginner));
		WebElement checkCheckboxAdvanced = wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxAdvanced));
		WebElement checkCheckboxIntermediate = wait
				.until(ExpectedConditions.visibilityOfElementLocated(checkboxIntermediate));

		WebElement anyOption = driver.findElement(By.xpath("//ul[@role='listbox']//li[@data-value='any']"));

		String isSelected = anyOption.getAttribute("aria-selected");

		Assert.assertEquals(isSelected, "true", "'Any' option is not selected");
		Assert.assertTrue(checkCheckboxBeginner.isSelected(), "Beginner is not selected");
		Assert.assertTrue(checkCheckboxAdvanced.isSelected(), "Advanced is not selected");
		Assert.assertTrue(checkCheckboxIntermediate.isSelected(), "Intermediate is not selected");

		List<WebElement> listOfData = driver.findElements(By.xpath("//table/tbody/tr"));
		for (WebElement row : listOfData) {
			Assert.assertTrue(row.isDisplayed(), "All rows are not visible");
		}

	}

	@Test
	public void TestCase7() {
		driver.navigate().to("https://practicetestautomation.com/practice-test-table/?utm_source=chatgpt.com");
		WebElement sortDropDown = driver.findElement(sort);
		Select sortBy = new Select(sortDropDown);
		sortBy.selectByIndex(4);

		List<WebElement> listOfData = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table/tbody/tr/td[@headers='col_enroll']")));
		List<Integer> values = new ArrayList<>();
		for (WebElement row : listOfData) {
			values.add(Integer.parseInt(row.getText().replace(",", "")));
			System.out.println(row.getText().replace(",", ""));
		}

		List<Integer> sorted = new ArrayList<>(values);
		Collections.sort(sorted);
		Assert.assertEquals(values, sorted, "Enroll values are not sorted in ascending numeric order.");
	}

	@Test
	public void TestCase8() {
		driver.navigate().to("https://practicetestautomation.com/practice-test-table/?utm_source=chatgpt.com");
		WebElement sortDropDown = driver.findElement(sort);
		Select sortBy = new Select(sortDropDown);
		sortBy.selectByIndex(1);

		List<WebElement> listOfData = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table/tbody/tr/td[@headers='col_course']")));
		List<String> actual = new ArrayList<>();
		for (WebElement row : listOfData) {
			actual.add(row.getText());
			System.out.println(row.getText());
		}

		List<String> sorted = new ArrayList<>(actual);
		Collections.sort(sorted, String.CASE_INSENSITIVE_ORDER);
		Assert.assertEquals(actual, sorted, "Courses are not sorted in Alphabetical order");

		sortBy.selectByIndex(2);

		List<WebElement> newList = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table/tbody/tr/td[@headers='col_course']")));
		List<String> list1Text = listOfData.stream().map(WebElement::getText).collect(Collectors.toList());

		List<String> list2Text = newList.stream().map(WebElement::getText).collect(Collectors.toList());
		Assert.assertNotEquals(list1Text, list2Text, "Both lists are equal.");

	}
}
