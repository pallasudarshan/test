package GenericUtility_Appium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Hello_Bff_GenericUtility.JavaUtility;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidDriverUtility {

	public AndroidDriver driver;
	public JavaUtility jutil = new JavaUtility();

	/*
	 * Tap on the element
	 * 
	 */
	public void TapOnTheElement(WebElement element) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
	}

	/*
	 * Long press on the element
	 * 
	 * 
	 */

	public void longPressOnTheElement(WebElement element) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
	}

	// Tap: Taps on a specific point on the screen
	public void tapAtPoint(int x, int y) {
		new TouchAction((PerformsTouchActions) driver).tap(PointOption.point(x, y)).perform();
	}

	// Long Press: Presses and holds down on an element
	public void longPressOnElement(WebElement element) {
		new TouchAction(driver).longPress(ElementOption.element(element)).perform();
	}

	// Long Press: Presses and holds down at a specific point on the screen for a
	// specified duration
	public void longPressAtPoint(int x, int y, int durationInMillis) {
		new TouchAction(driver).longPress(PointOption.point(x, y)).waitAction().waitAction().perform();
	}

	// Press: Presses at a specific point on the screen for a specified duration
	public void pressAtPoint(int x, int y, int durationInMillis) {
		new TouchAction(driver).press(PointOption.point(x, y)).waitAction().release().perform();
	}

	// Move To: Moves from one element to another
	public void moveToElement(WebElement sourceElement, WebElement targetElement) {
		new TouchAction(driver).longPress(ElementOption.element(sourceElement))
				.moveTo(ElementOption.element(targetElement)).release().perform();
	}

	// Swipe: Swipes from one point to another
	public void swipe(int startX, int startY, int endX, int endY) {
		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(startX, startY))
				.moveTo(PointOption.point(endX, endY)).release().perform();
	}

	// Pinch: Performs a pinch gesture (zoom out) on two elements
	public void pinch(AndroidDriver driver, WebElement element1, WebElement element2) {
		new MultiTouchAction(driver)
				.add(new TouchAction(driver).press(ElementOption.element(element1))
						.moveTo(ElementOption.element(element2)))
				.add(new TouchAction(driver).press(ElementOption.element(element2))
						.moveTo(ElementOption.element(element1)))
				.perform();
	}

	// Zoom: Performs a zoom gesture (pinch in) on two elements
	public void zoom(AndroidDriver driver, WebElement element1, WebElement element2) {
		new MultiTouchAction(driver)
				.add(new TouchAction(driver).press(ElementOption.element(element1))
						.moveTo(ElementOption.element(element2)))
				.add(new TouchAction(driver).press(ElementOption.element(element2))
						.moveTo(ElementOption.element(element1)))
				.perform();
	}

	// Two-finger Swipe: Performs a swipe gesture using two fingers simultaneously.
	public void twoFingerSwipe(AndroidDriver driver, int startX1, int startY1, int endX1, int endY1, int startX2,
			int startY2, int endX2, int endY2) {
		TouchAction touchAction1 = new TouchAction((PerformsTouchActions) driver);
		TouchAction touchAction2 = new TouchAction((PerformsTouchActions) driver);

		touchAction1.press(PointOption.point(startX1, startY1)).moveTo(PointOption.point(endX1, endY1)).release();
		touchAction2.press(PointOption.point(startX2, startY2)).moveTo(PointOption.point(endX2, endY2)).release();

		new MultiTouchAction(driver).add(touchAction1).add(touchAction2).perform();
	}

	// Drag and Drop: Drags an element from one location to another.
	public void dragAndDrop(AndroidDriver driver, WebElement sourceElement, WebElement targetElement) {
		new TouchAction(driver).longPress(ElementOption.element(sourceElement))
				.moveTo(ElementOption.element(targetElement)).release().perform();
	}

	// Shake: Simulates shaking the device.
	public void shake(AndroidDriver driver) {
		// Implementation depends on the platform and may require additional steps or
		// ADB commands.
	}

	public static void waitForElementVisibility(AndroidDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	}

	public static void explicitWaitElementToBeClickable(AndroidDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
	}
}
