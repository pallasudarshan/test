package ObjectRepository_Appium;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage {
	public AndroidDriver driver;

	public ProfilePage(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Profile']")
	private WebElement profileBtn;

	@AndroidFindBy(xpath = "(//android.view.View[@content-desc])[3]")
	private WebElement name;

	@AndroidFindBy(xpath = "(//android.view.View[@content-desc])[4]")
	private WebElement email;

	@AndroidFindBy(xpath = "(//android.view.View[@content-desc])[5]")
	private WebElement mobileNo;

	@AndroidFindBy(xpath = "(//android.view.View[@content-desc])[6]")
	private WebElement address;

	public void clickOnProfileBtn(AndroidDriver driver) {
		profileBtn.click();
	}

	public String captureName(AndroidDriver driver) {
		String text = name.getText();
		Pattern pattern = Pattern.compile("Name : (.+)");
		Matcher matcher = pattern.matcher(text);

		if (matcher.find()) {
			String extractedText = matcher.group(1).trim();
			System.out.println("Extracted Text: " + extractedText);
			return extractedText;
		} else {
			System.out.println("Pattern not found in the string.");
			return null;
		}
	}
}
