import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class seleniumRegister {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
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

		WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));
		// firstName.sendKeys("Manpreet");
		firstName.sendKeys(new Faker().name().firstName());

		WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));
		// lastName.sendKeys("Kaur");
		lastName.sendKeys(new Faker().name().lastName());

		WebElement dateofBirth = driver.findElement(By.xpath("//input[@id='dob']"));
		// dateofBirth.sendKeys("11-03-1999");
		Date dob = new Faker().date().birthday(18, 60);

		// Format to YYYY-MM-DD
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dobString = formatter.format(dob);
		dateofBirth.sendKeys(dobString);
		System.out.println(dobString);

		WebElement address = driver.findElement(By.xpath("//input[@id='address']"));
		// address.sendKeys("Amritsar");
		address.sendKeys(new Faker().address().streetName());

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

		WebElement phone = driver.findElement(By.xpath("//input[@id='phone']"));
		// phone.sendKeys("9876543678");
		String phn = new Faker().phoneNumber().cellPhone().replaceAll("[^0-9]", "");
		// System.out.println(phn.replaceAll("[^0-9]", ""));
		phone.sendKeys(phn);

		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		// email.sendKeys("kaur@gmail.com");
		email.sendKeys(new Faker().internet().emailAddress());

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		// password.sendKeys("34256@@");
		password.sendKeys(new Faker().internet().password());
		password.sendKeys(Keys.TAB);

		// WebElement registerClick =
		// driver.findElement(By.xpath("//button[@type='submit']"));
		// Thread.sleep(5000);
		// registerClick.click();

		WebDriverWait regiWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Scroll
		WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		// Re-locate & wait
		WebElement clickableElement = regiWait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		clickableElement.click();
		// driver.quit();
		// driver.close();
	}

}
