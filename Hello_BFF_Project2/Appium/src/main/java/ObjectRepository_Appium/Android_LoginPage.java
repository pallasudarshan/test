package ObjectRepository_Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Android_LoginPage {

	public AndroidDriver androidDriver;

	public Android_LoginPage(AndroidDriver androidDriver) {
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
	}

	@AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
	private WebElement usernameText;

	@AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
	private WebElement passwordText;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Log In']")
	private WebElement loginBtn;

	public void loginToTheApp(AndroidDriver androidDriver, String MobileUsername, String MobilePassword) {
		usernameText.click();
		usernameText.sendKeys(MobileUsername);
		passwordText.click();
		passwordText.sendKeys(MobilePassword);
		androidDriver.hideKeyboard();
		loginBtn.click();
		try {
			WebElement allowButton = androidDriver.findElement(By.xpath(
					"//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']"));
			if (allowButton.isDisplayed()) {
				allowButton.click();
			}
		} catch (Exception e) {
			System.out.println("Notification popup not displayed");
		}
	}

}
