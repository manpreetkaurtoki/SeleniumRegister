package demoecom;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import manager.DriverManager;
import utils.BaseUtils;

public class Base {
	WebDriverWait wait;

	@BeforeSuite
	public void initialise() throws IOException {
	}

	@BeforeMethod
	public void preReq(Method method) throws IOException {
		DriverManager.initDriver();
		DriverManager.getDriver();
		//WaitUtils.initWait();
		DriverManager.goToUrl(BaseUtils.getConfigValue("url"));
	}

	@AfterMethod
	public void endTest(ITestResult result) throws IOException {

		DriverManager.quitDriver();
		System.out.println("entered in closing browser method");

	}

	
}
