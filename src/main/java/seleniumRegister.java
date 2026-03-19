import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class seleniumRegister {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://with-bugs.practicesoftwaretesting.com/#/");

		WebElement signInElement = driver.findElement(By.xpath("//a[text()='Sign in']"));
		signInElement.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		WebElement registerLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Register your account']")));
		registerLink.click();

		// WebElement registerElement= driver.findElement(By.xpath("//a[text()='Register
		// your account']"));
		// registerElement.click();

		// input[@id='first_name']

		WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));
		// firstName.sendKeys("Manpreet");
		firstName.sendKeys(new Faker().name().firstName());

		// input[@id='last_name']
		WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));
		// lastName.sendKeys("Kaur");
		lastName.sendKeys(new Faker().name().lastName());

		// input[@id='dob']
		WebElement dob = driver.findElement(By.xpath("//input[@id='dob']"));
		dob.sendKeys("11-03-1999");

		// input[@id='address']
		WebElement address = driver.findElement(By.xpath("//input[@id='address']"));
		// address.sendKeys("Amritsar");
		address.sendKeys(new Faker().address().streetName());

		// input[@id='postcode']
		WebElement postcode = driver.findElement(By.xpath("//input[@id='postcode']"));
		// postcode.sendKeys("147654");
		postcode.sendKeys(new Faker().address().zipCode());

		WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
		city.sendKeys(new Faker().address().cityName());

		WebElement state = driver.findElement(By.xpath("//input[@id='state']"));
		state.sendKeys(new Faker().address().state());

		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		Select countyDropdown = new Select(country);
		List<WebElement> options = countyDropdown.getOptions();
		int size = options.size();
		// Select second last option
		countyDropdown.selectByIndex(size - 2);

		// countyDropdown.selectByIndex(5);
		// countyDropdown.selectByValue("DZ");
		// countyDropdown.selectByVisibleText("Albania");

		// input[@id='phone']
		WebElement phone = driver.findElement(By.xpath("//input[@id='phone']"));
		// phone.sendKeys("9876543678");
		phone.sendKeys(new Faker().phoneNumber().cellPhone());

		// input[@id='email']
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		// email.sendKeys("kaur@gmail.com");
		email.sendKeys(new Faker().internet().emailAddress());

		// input[@id='password']
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		// password.sendKeys("34256@@");
		password.sendKeys(new Faker().internet().password());

		// driver.quit();
		// driver.close();
	}

}
