package pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import manager.ExtentTestManager;
import utils.UiActionUtils;
import utils.WaitUtils;

public class HomePage {
	By dropdownFilter = By.className("product_sort_container");
	By productList = By.className("inventory_item");
	By price = By.className("inventory_item_price");
	By addToCartBtn = By.xpath("//button[text()='Add to cart']");

	public void chooseFilter(int index) {
		UiActionUtils.selectByIndex(WaitUtils.visibilityOfElementLocated(dropdownFilter), index);
	}

	public void showItems() {
		List<WebElement> products = UiActionUtils.getList(productList);
		for (int i = 0; i < products.size(); i++) {
			WebElement product = products.get(i);
			try {

				String title = product.findElement(price).getText().toLowerCase();
				System.out.println(title);

				if (title.equalsIgnoreCase("$7.99")) {

					if (product.findElement(addToCartBtn).isDisplayed()) {
						UiActionUtils.click(addToCartBtn, "Product cart");
					}
					System.out.println("hel");
					break;
				}

			} catch (Exception e) {
				System.out.println("Skipping item at index: " + i);
			}
		}
	}

}
