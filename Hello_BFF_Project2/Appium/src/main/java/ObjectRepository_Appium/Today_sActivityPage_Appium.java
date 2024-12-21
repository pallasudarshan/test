package ObjectRepository_Appium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Today_sActivityPage_Appium {

	public AndroidDriver driver;

	public Today_sActivityPage_Appium(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Opening the Line of Communication']/parent::*[@class='android.view.View']/child::android.view.View[@content-desc='Expand']/android.widget.Button")
	private WebElement    openingTheLineOfCommunicationBtn_SocialInteractions;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Nurturing Conversational Seeds']/parent::*[@class='android.view.View']/child::android.view.View[@content-desc='Expand']/android.widget.Button")
	private WebElement    nurturingConversationalSeedsBtn_SocialInteractions;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Setting the Social Stage']/parent::*[@class='android.view.View']/child::android.view.View[@content-desc='Expand']/android.widget.Button")
	private WebElement    settingTheSocialStageBtn_SocialInteraction;
	
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Finish\"]")
	private WebElement    finishBtn;
	

}
