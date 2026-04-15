package pageclasses;

import org.openqa.selenium.By;

import utils.UiActionUtils;
import utils.WaitUtils;

public class HomePage {
	By dropdownFilter = By.className("product_sort_container");
	
	public void chooseFilter(int index)
	{
		UiActionUtils.selectByIndex(WaitUtils.visibilityOfElementLocated(dropdownFilter), index);
	}

}
