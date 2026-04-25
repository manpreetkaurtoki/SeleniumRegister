package collectionexample;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentCollection {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-table/?utm_source=chatgpt.com");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> listOfData = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table/tbody//tr/td[@headers='col_course']")));

		List<String> actual = new ArrayList<>();
		for (WebElement row : listOfData) {
			actual.add(row.getText());
			System.out.println(row.getText());
		}

		//Using collections.sort
		List<String> sorted = new ArrayList<>(actual);// copy
		Collections.sort(sorted);
		for (String val : sorted) {
			System.out.println("Sorted Values " + val);
		}
		
		
		
		//Using TreeSet
		TreeSet<String> myTree = new TreeSet<>();
		myTree.addAll(actual);

		for (String val : myTree) {
			System.out.println("Tree Values " + val);
		}
		
		
		// Final checks/validation
		boolean check = actual.size()== myTree.size();
		System.out.println(check);
		
		
		boolean isEqual = actual.equals(sorted);
		System.out.println(isEqual);
		
		boolean checkSort = sorted.equals(sorted);
		System.out.println(checkSort);

	}

}
