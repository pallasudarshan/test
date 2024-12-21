package ObjectRepository_Appium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import GenericUtility_Appium.AndroidDriverUtility;
import Hello_Bff_GenericUtility.WebDriverUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Check_InsPage extends AndroidDriverUtility {

	public AndroidDriver androidDriver;

	public Check_InsPage(AndroidDriver androidDriver) {
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.Button")
	private WebElement plusBtn;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Check-Ins']")
	private WebElement checkInsButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Loneliness']")
	private WebElement LonelinessButton;

	@AndroidFindBy(xpath = "(//android.view.View[@content-desc])[2]")
	private WebElement firstQuestion;

	public void clickOnPlusBtn(AndroidDriver androidDriver) {
		explicitWaitElementToBeClickable(androidDriver, plusBtn);
		plusBtn.click();
	}

	public void clickOnCheckInBtn() {
		explicitWaitElementToBeClickable(androidDriver, checkInsButton);
		checkInsButton.click();
	}

	public void clickOnLonelinessButton() {
		explicitWaitElementToBeClickable(androidDriver, LonelinessButton);
		LonelinessButton.click();
	}

	public String captureFirstQuestion() {
		waitForElementVisibility(androidDriver, firstQuestion);
		return firstQuestion.getAttribute("content-desc");
	}

}
