package demoecom;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.MediaEntityBuilder;

import manager.DriverManager;
import manager.ExtentManager;
import manager.ExtentTestManager;
import utils.BaseUtils;
import utils.WaitUtils;

public class Base {
	WebDriverWait wait;
	@BeforeSuite
	public void initialise() throws IOException {
		ExtentManager.initReport();
	}

	@BeforeMethod
	public void preReq(Method method) throws IOException {
		ExtentTestManager.createTest(method.getName());
		DriverManager.initDriver();
		DriverManager.getDriver();
		WaitUtils.initWait();
		DriverManager.goToUrl(BaseUtils.getConfigValue("url"));
	}

	@AfterMethod
	public void endTest(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestManager.log.pass("Test Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.log.fail(result.getThrowable());
			ExtentTestManager.log.fail(result.getThrowable(),
					MediaEntityBuilder
							.createScreenCaptureFromPath(BaseUtils.getScreenShotPath(DriverManager.getDriver(),
									result.getInstance().getClass().getSimpleName() + "." + result.getMethod()))
							.build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentTestManager.log.skip("Test Skipped");
		}
		//DriverManager.quitDriver();
		System.out.println("entered in closing browser method");

	}

	@AfterSuite
	public void tearDown() {
		ExtentManager.flushReport();
	}
}
