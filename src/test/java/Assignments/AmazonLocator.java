package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AmazonLocator extends Base {

	By search = By.id("twotabsearchtextbox");
	By searchbtn = By.id("nav-search-submit-button");
	By listofProducts = By.xpath("//div[@data-component-type='s-search-result']");
	By titleofProducts = By.xpath(".//a/h2/span");
	int iphone12Index = -1;
	int iphone15Index = -1;

	@Test
	public void locateiPhone() throws InterruptedException {
		driver.navigate().to("https://www.amazon.ca");
		WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(search));
		WebElement searchBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(searchbtn));
		searchField.sendKeys("iphone");
		searchBtn.click();

		

		List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listofProducts));

		System.out.println(products.size());

		for (int i = 0; i < products.size(); i++) {

			WebElement product = products.get(i);

			try {
				String title = product.findElement(titleofProducts).getText().toLowerCase();

				System.out.println(i + " is index of " + title);

				
				if (title.equalsIgnoreCase("Apple iPhone 12, 64GB, Purple - Unlocked (Renewed)")) {
					iphone12Index = i;
					System.out.println("iPhone 12 located at index: " + i);
				}

				if (title.equalsIgnoreCase("Apple iPhone 15 Pro Max, 256GB, Natural Titanium - Unlocked (Renewed)")) {
					iphone15Index = i;
					System.out.println("iPhone 15 Pro Max located at index: " + i);
				}

			} catch (Exception e) {
				System.out.println("Skipping item at index: " + i);
			}
		}
		if (iphone12Index != -1 && iphone15Index != -1) {

			if (iphone15Index > iphone12Index) {
				System.out.println("iPhone 15 Pro Max with index "+ iphone15Index+ " appears after iPhone 12 " + "=" +iphone12Index);
			} else {
				System.out.println("Order is incorrect");
			}

		} else {
			System.out.println("One or both products not found");
		}

	}

}
