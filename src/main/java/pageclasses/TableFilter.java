package pageclasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TableFilter {
	WebDriver driver;
	WebDriverWait wait;

	public TableFilter(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;

	}

	By langJava = By.xpath("//input[@name='lang' and @value='Java']");
	By langAny = By.xpath("//input[@name='lang' and @value='Any']");
	By langPython = By.xpath("//input[@type='radio' and @value='Python']");
	By listOfAllVisibleData = By.xpath("//table/tbody/tr[not(contains(@style,'display: none'))]");
	By listofLang = By.xpath("//table/tbody/tr[not(contains(@style,'display: none'))]//td[@headers='col_lang']");
	By listOfLevel = By.xpath("//table/tbody/tr[not(contains(@style,'display: none'))]//td[@headers='col_level']");
	By listOfEnrollments = By
			.xpath("//table/tbody/tr[not(contains(@style,'display: none'))]//td[@headers='col_enroll']");
	By checkboxIntermediate = By.xpath("//input[@type='checkbox' and @value='Intermediate']");
	By checkboxAdvanced = By.xpath("//input[@type='checkbox' and @value='Advanced']");
	By checkboxBeginner = By.xpath("//input[@type='checkbox' and @value='Beginner']");
	By dropdownLabel = By.xpath("//span[@class='dropdown-label']");
	By filterEnroll = By.xpath("//ul[@class='dropdown-menu']/li[text()='10,000+']");
	By resetBtn = By.id("resetFilters");
	By sort = By.xpath("//select[@id='sortBy']");

	public List<String> filterLang() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(langJava)).click();

		List<WebElement> listOfData = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listofLang));
		List<String> rowText = new ArrayList<>();
		for (WebElement row : listOfData) {
			rowText.add(row.getText());
		}
		return rowText;

	}

	public List<WebElement> filterLevel() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxIntermediate)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxAdvanced)).click();

		List<WebElement> listOfData = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listOfLevel));

		return listOfData;
	}

	public List<WebElement> dropDownfilterMinEnroll() {
		wait.until(ExpectedConditions.elementToBeClickable(dropdownLabel)).click();
		wait.until(ExpectedConditions.elementToBeClickable(filterEnroll)).click();
		List<WebElement> listOfData = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listOfEnrollments));

		return listOfData;
	}

	
}
