package test_cases;

import org.testng.annotations.Test;

import pages.PageBase;
import pages.SignuUpPage;

public class E2E_TestCase001_SignUpWithMobileNumber extends TestBase {

	SignuUpPage signuUpPage;

	@Test(priority = 1, groups = "smoke", description = "Sign up With Mobile Number")
	public void testSignUpWithMobileNumber() throws InterruptedException {

		signuUpPage = new SignuUpPage(driver);
		
		PageBase.assertToObjectExistWithGetText(signuUpPage.signUpTextView, "Sign Up");// assert to specific text

		signuUpPage.signUpWithMobileNumber();

		Thread.sleep(4000);
		
		PageBase.captureScreenshot(driver, "verifyMobileNumber");// take screenshot after summation operation
	}
}
