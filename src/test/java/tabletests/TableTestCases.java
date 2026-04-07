package tabletests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageclasses.TableFilter;

public class TableTestCases extends BaseTest {

	TableFilter filterObj;

	@Test
	public void TestCase1() {
		filterObj = new TableFilter(driver, wait);
		List<String> listofJava = filterObj.filterLang();
		for (String element : listofJava) {
			System.out.println(element);
			Assert.assertEquals(element, "Java");
		}
	}

	@Test
	public void TestCase2() {
		filterObj = new TableFilter(driver, wait);
		List<WebElement> listOfLevel = filterObj.filterLevel();
		for (WebElement element : listOfLevel) {
			System.out.println(element.getText());
			Assert.assertEquals(element.getText(), "Beginner");

		}

	}

	@Test
	public void TestCase3() {
		filterObj = new TableFilter(driver, wait);
		List<WebElement> listOfEnroll = filterObj.dropDownfilterMinEnroll();
		for (WebElement element : listOfEnroll) {
			int value = Integer.parseInt(element.getText().trim());
			Assert.assertTrue(value >= 10000);
		}
	}

	@Test
	public void TestCase5() {
		filterObj = new TableFilter(driver, wait);
		WebElement noMatch = filterObj.noData();
		Assert.assertTrue(noMatch.isDisplayed(), " matching courses. ");

	}

}
