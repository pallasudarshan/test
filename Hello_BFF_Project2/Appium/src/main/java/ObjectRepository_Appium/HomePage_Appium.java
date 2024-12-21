package ObjectRepository_Appium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import GenericUtility_Appium.AndroidDriverUtility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage_Appium extends AndroidDriverUtility {

	public AndroidDriver driver;

	public HomePage_Appium(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(accessibility = "Social Interaction")
	private WebElement socialInteractionLinkBtn;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Social Interaction']/android.widget.RadioButton")
	private WebElement socialInteractionRadio;

	@AndroidFindBy(accessibility = "There is always time for yoga.")
	private WebElement thereIsAlwaysTimeForYogaLinkBtn;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='There is always time for yoga.']/android.widget.RadioButton")
	private WebElement thereIsAlwaysTimeForYogaRadioBtn;

	@AndroidFindBy(accessibility = "Relaxing Music")
	private WebElement relaxingMusicLinkBtn;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Relaxing Music']/android.widget.RadioButton")
	private WebElement relaxingMusicRadioBtn;

	@AndroidFindBy(xpath = "Gratitude Journaling")
	private WebElement gratitudeJournalingLinkBtn;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Gratitude Journaling']/android.widget.RadioButton")
	private WebElement gratitudeJournalingRadioBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[1]")
	private WebElement plusBtn;
//	
//	@AndroidFindBy(xpath="")
//	private WebElement    ;
//	
//	@AndroidFindBy(xpath="")
//	private WebElement    ;
//	
//	@AndroidFindBy(xpath="")
//	private WebElement    ;
//	
//	@AndroidFindBy(xpath="")
//	private WebElement    ;
//	
//	@AndroidFindBy(xpath="")
//	private WebElement    ;
//	

	public void clickOnThePlusButton() {
		plusBtn.click();
	}

}
