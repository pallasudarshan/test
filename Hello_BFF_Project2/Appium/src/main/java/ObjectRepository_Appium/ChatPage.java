package ObjectRepository_Appium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import GenericUtility_Appium.AppiumDriverUtility;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class ChatPage extends AppiumDriverUtility {
	public AndroidDriver androidDriver;
	public ChatPage(AndroidDriver androidDriver) {
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Chat\"]/android.view.View/android.view.View/android.widget.ImageView")
	public WebElement chatBtn;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	public WebElement textField;

	@AndroidFindBy(xpath = "//android.widget.Button")
	public WebElement sendBtn;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='hello']")
	public WebElement helloText;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='AUTO CHAT']")
	public WebElement autoChatBtn;

	public void clickOnChatBtn(AndroidDriver androidDriver) {
		chatBtn.click();
	}

	public void clickOnAutoChat(AndroidDriver androidDriver) {
		autoChatBtn.click();
	}

	public void enterDataInTetField(AndroidDriver androidDriver, String text) {
		textField.click();
		textField.clear();
		textField.sendKeys("YourData");
		androidDriver.hideKeyboard();
	}

	public void clickOnSendBtn(AndroidDriver androidDriver) {
		sendBtn.click();
	}

	public String captureHelloText(AndroidDriver androidDriver) {
		return helloText.getText();
	}
}
