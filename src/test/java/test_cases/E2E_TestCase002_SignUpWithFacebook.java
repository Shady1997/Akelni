package test_cases;

import org.testng.annotations.Test;

import pages.FacebookLoginPage;
import pages.PageBase;
import pages.SignuUpPage;

public class E2E_TestCase002_SignUpWithFacebook extends TestBase{
	
	SignuUpPage signuUpPage;
	FacebookLoginPage facebookLoginPage;

	@Test(priority = 2, groups = "smoke", description = "Sign up With Facebook")
	public void testSignUpWithFacebook() throws InterruptedException {

		signuUpPage = new SignuUpPage(driver);
		facebookLoginPage=new FacebookLoginPage(driver);
		
		PageBase.assertToObjectExistWithGetText(signuUpPage.signUpTextView, "Sign Up");// assert to specific text

		signuUpPage.signUpWithFacebook();

		Thread.sleep(9000);
		
		facebookLoginPage.loginWithFacebook();
		
		Thread.sleep(9000);
		
		PageBase.captureScreenshot(driver, "verifyFacebookLoginStart");// take screenshot after summation operation
	}


}
