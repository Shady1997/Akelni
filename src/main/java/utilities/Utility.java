package utilities;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class Utility {

	// drag and drop method
	public void dragDrop(AndroidDriver<AndroidElement> driver, WebElement source, WebElement destination) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(longPressOptions().withElement(element(source)).withDuration(ofSeconds(2)))
				.moveTo(element(destination)).release().perform();
	}

	// pull down for refresh
	public void pullDown(AndroidDriver<AndroidElement> driver) {
//		First get device height and width
		int deviceWidth = driver.manage().window().getSize().getWidth();
		int deviceHeight = driver.manage().window().getSize().getHeight();
//		calculate midX and midY
		int midX = (deviceWidth / 2);
		int midY = (deviceHeight / 2);
//		calculate bottom edge
		int bottomEdge = (int) (deviceHeight * 0.85f);
//		perform a pull to refresh using TouchAction class
		new TouchAction(driver).press(PointOption.point(midX, midY)).waitAction()
				.moveTo(PointOption.point(midX, bottomEdge)).release().perform();
	}

}
