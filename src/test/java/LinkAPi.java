
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class LinkAPi {
	@Test
	public void linkTest() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");

		List<WebElement> all_links = driver.findElements(By.tagName("a"));
		System.out.println("Total links: " + all_links.size());

		for (WebElement link : all_links) {

			String url = link.getAttribute("href");

			if (url == null || url.isEmpty()) {
				System.out.println("URL is empty");
				continue;
			}

			try {
				URL linkUrl = new URL(url);
				HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
				int responseCode = connection.getResponseCode();
				if (responseCode >= 400) {
					System.out.println(url + " Link is not working");
				} else {
					System.out.println(url + " Link is working");
				}

			} catch (Exception e) {
				System.out.println(url + "Error occurred");
			}
		}

		driver.quit();

	}

}
