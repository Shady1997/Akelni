package test_cases;

import capabilities.Capabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import pages.SignuUpPage;
import pages.PageBase;

import java.io.FileInputStream;
import java.io.IOException;

public class TestBase extends Capabilities{

	// declare class properties
	static AndroidDriver<AndroidElement> driver;
	static SignuUpPage mainPage;
	protected static String result = null;
	FileInputStream readProperty;
	JavascriptExecutor js;

	@BeforeTest
	public static void prepare() throws IOException {
		// TODO start application with appium
		driver = baseCapabilities("AppName");
		PageBase.captureScreenshot(driver, "startApp");// take screenshot for app when start

		mainPage = new SignuUpPage(driver);
	}

	@AfterClass
	public static void TearDown() {
		driver.quit();
	}

	public static void getScreenshotOnFailure() {
		PageBase.captureScreenshot(driver, "fail" + java.time.LocalTime.now().toString());
	}

}
