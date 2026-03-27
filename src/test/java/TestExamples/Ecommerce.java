package TestExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Ecommerce {

	@Test
	public void ecommerceFunc() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.ca");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement search = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='twotabsearchtextbox']")));
		search.sendKeys("Laptop");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='nav-search-submit-button']")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.//span[text()=\"Lenovo\"]]"))).click();
		//Thread.sleep(6000);

		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		WebElement priceFilter = wait.until(
			    ExpectedConditions.presenceOfElementLocated(
			        By.xpath("//a[.//span[contains(text(),\"600\") and contains(text(),\"1200\")]]")
			    )
			);
			priceFilter.click();
	}

}
