package Assignments;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class Base {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	@BeforeMethod
	public void preReq() {
		String browser = "Chrome";
		switch (browser) {
		case "Chrome":
			driver = new ChromeDriver();
			break;
		case "Safari":
			driver = new SafariDriver();
			break;
		case "Edge":
			driver = new EdgeDriver();
			break;
		case "Explorer":
			driver = new InternetExplorerDriver();
			break;
		}

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		actions = new Actions(driver);
		System.out.println("entered in pre condition method");
	}

	public void quit() {
		driver.quit();
		System.out.println("entered in closing browser method");
	}

}
