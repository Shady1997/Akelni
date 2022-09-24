package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignuUpPage {

	public SignuUpPage(AppiumDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// sign up with mobile number
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='0']")
	public WebElement signUpTextView;
	
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
	private WebElement mobileNumberInputField;

	@AndroidFindBy(xpath = "//android.widget.Button[@index='3']")
	private WebElement continueButton;
	
	public void signUpWithMobileNumber() {
		String mobileNumber="01203199"+PageBase.generateInteger(9)+PageBase.generateInteger(9)+PageBase.generateInteger(9);
		mobileNumberInputField.sendKeys(mobileNumber);
		continueButton.click();
	}
	
	@AndroidFindBy(id = "tv_login_facebook")
	private WebElement signUpWithFacebook;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='1']")
	private WebElement signUpWithGoogle;

	public void signUpWithFacebook() {
		signUpWithFacebook.click();
	}

}
